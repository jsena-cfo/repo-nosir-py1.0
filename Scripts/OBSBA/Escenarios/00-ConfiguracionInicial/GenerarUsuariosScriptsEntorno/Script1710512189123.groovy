import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**Author: JER**/
/**Registra 5 nuevos usuarios: afiliado, prestador, interno, empleado y administrador**/
/**Se actualiza el registro temporal de usuarios para luego utilizarlo en los scripts subsiguientes**/
boolean validarUsuariosActivados = false

boolean validarUsuariosRegistrados = false

boolean validar = false

def mapCuils

mapCuils = [('1') : 'error', ('2') : 'error', ('3') : 'error', ('4') : 'error', ('5') : 'error']

def mapRangos

mapRangos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRangosDni'), [('varRangoIntMin') : rangoIntMin], FailureHandling.STOP_ON_FAILURE)

//int intDniCuilIntMin = ((mapRangos['dniIntMin']) as int)
int rangoDniIntMax = ((mapRangos['dniIntMax']) as int)

//int intDniCuilEmpMin = ((mapRangos['dniEmpMin']) as int)
int rangoDniEmpMax = ((mapRangos['dniEmpMax']) as int)

System.out.println('Map Rangos: ' + mapRangos)

String cuitAfiliado = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarObsbaAfiliado'), [('varPassword') : pass
        , ('varEmail') : email, ('varUsuario') : 'REGRESIONAFI', ('varTelefono') : telefono, ('varDomicilio') : domicilio
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuitAfiliado, ('varPerfil') : 'afiliado'
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

(mapCuils['1']) = cuitAfiliado

String cuitPrestador = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarObsbaPrestador'), [('varPassword') : pass
        , ('varEmail') : email, ('varUsuario') : 'REGRESIONPRE', ('varTelefono') : telefono, ('varDomicilio') : domicilio
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuitPrestador, ('varPerfil') : 'prestador'
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

(mapCuils['2']) = cuitPrestador

String cuitInterno = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInterno'), [('password') : pass
        , ('url') : url, ('fileXlsUsuarios') : GlobalVariable.fileXlsInternos, ('dataFileUsuarios') : GlobalVariable.dataFileInternos], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuitInterno, ('varPerfil') : 'interno'
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

(mapCuils['3']) = cuitInterno

String cuitEmpleado = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarEmpleadoAlt'), [('password') : pass
        , ('telefono') : telefono, ('direccion') : domicilio, ('email') : email, ('url') : url, ('fileXlsUsuarios') : GlobalVariable.fileXlsEmpleados
        , ('dataFileUsuarios') : GlobalVariable.dataFileEmpleados], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuitEmpleado, ('varPerfil') : 'empleado'
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

(mapCuils['4']) = cuitEmpleado

String cuitAdministrador = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/27-PantallaConsultaUsuarios/RegistroUsuarioAdministrador'), 
    [('password') : pass, ('url') : url, ('fileXlsUsuarios') : xlsFileInterno, ('dataFileUsuarios') : dataFileInterno], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuitAdministrador, ('varPerfil') : 'administrador'
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

(mapCuils['5']) = cuitAdministrador

System.out.println('Valor maps cuils: ' + mapCuils)

'valida que no contenga false y todos hayan sido activados'
validarUsuariosActivados = !(mapCuils.containsValue('error'))

'valida que todos los usuarios registrados esten registrados en la BD usuarios y usuarios portal'
validarUsuariosRegistrados = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarUsuariosRegistrados'), [('varMapCuils') : mapCuils], 
    FailureHandling.STOP_ON_FAILURE)

System.out.println('Usuarios fueron activados: ' + validarUsuariosActivados)

System.out.println('Usuarios fueron registrados: ' + validarUsuariosRegistrados)

if ((validarUsuariosActivados == true) && (validarUsuariosRegistrados == true)) {
    String textoCalculado

    textoCalculado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CantidadRegistrosDisponibles'), [('varCuitInterno') : cuitAdministrador
            , ('varCuitEmpleado') : cuitEmpleado, ('varRangoDniIntMax') : rangoDniIntMax, ('varRangoDniEmpMax') : rangoDniEmpMax], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALogUsuario'), [('varAfiliado') : cuitAfiliado, ('varPrestador') : cuitPrestador
            , ('varInterno') : cuitInterno, ('varEmpleado') : cuitEmpleado, ('varAdministrador') : cuitAdministrador, ('varTexto') : textoCalculado], 
        FailureHandling.STOP_ON_FAILURE)

    /**textoCalculado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CantidadRegistrosDisponibles'), [('varCuitInterno') : cuitAdministrador
            , ('varCuitEmpleado') : cuitEmpleado, ('varRangoDniIntMax') : rangoDniIntMax, ('varRangoDniEmpMax') : rangoDniEmpMax], 
        FailureHandling.STOP_ON_FAILURE)**/
    String entorno = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RetornarEntorno'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

    String titulo = 'OBSBA QA Automation - CFO'

    String asunto = 'Usuarios Registro Simple - Ent: ' + entorno

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtml'), [('varTitulo') : titulo, ('varAsunto') : asunto
            , ('varTextoCalculado') : textoCalculado, ('varTipoBody') : 'Simple', ('varCuilAfiliado') : cuitAfiliado, ('varCuilPrestador') : cuitPrestador
            , ('varCuilInterno') : cuitInterno, ('varCuilEmpleado') : cuitEmpleado, ('varCuilAdministrador') : cuitAdministrador], 
        FailureHandling.STOP_ON_FAILURE)

    validar = true
}

assert validar

