import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/**Registra y activa un usuario con rol Interno**/
/**Toma la informacion de carga del xls usuariosInternos.xlsx**/
/**Ejecutar la suite de RegistroUsr y RegistroMultiple, cargan en los xls interno 
 * y empleado: 7 internos y 5 empleados**/
//String path = '\\Xls\\obsba\\usersSigafXls\\' + fileXlsUsuarios
//def pathExcel = System.getProperty('user.dir') + path
//def pathRelativo2 = pathExcel.replace('\\', '\\\\')
///**Ej: C:/Devs/Projects/Katalon/NOSIR**/
//String pathLocation = CustomKeywords.'tool.UploadFile.pathRelativeProject'()
//def pathRelativo = (pathLocation + '/Xls/obsba/usersSigafXls/') + fileXlsUsuarios
//System.out.println('Path relativo: ' + pathRelativo)
//String dataFile = dataFileUsuarios
//row_control = findTestData(dataFile).getRowNumbers()

String pass = getBinding().getAt('varPass').toString()

String url = getBinding().getAt('varUrl').toString()

String cuil = getBinding().getAt('varCuil').toString()

String email = getBinding().getAt('varEmail').toString()

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuil)

String usuario = 'REGRESION' + CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dni)

//String cuit
'busca un usuario en la planilla que no ha sido insertado'
System.out.println('Se busca usuario en la planilla que se pueda usar')

String emailMayus= CustomKeywords.'tool.StringCK.pasarAMayuscula'(email)

WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/InsertarUsuarioSigafUnicoBD'), [('varCuil') : cuil
        , ('varEmail') : emailMayus], FailureHandling.STOP_ON_FAILURE)

boolean encontroSinUsar = false

int index = 1

def estadoVal

String usuarioVal

boolean usuarioNoEstaRegistrado = false

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String txtIntento = (((('Se intenta registrar usuario: ' + usuario) + ' dni: ') + dni) + ' cuit: ') + cuil

System.out.println('Usuario: ' + usuario)

System.out.println('Dni: ' + dni)

System.out.println('Cuit: ' + cuil)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtIntento], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : usuario, ('varCuil') : cuilSinGuiones, ('varPassword') : pass
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
    false, FailureHandling.OPTIONAL)

if (registroSatisfactorio == true) {
    token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuil, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

    //String cantRegDisponibles = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRegistrosDisponibles'), [('varDni') : dni
    //        , ('varCuitMax') : rangoMaxCuitPlanilla.toString()], FailureHandling.STOP_ON_FAILURE)
    //System.out.println('Cantidad Registros disponible: ' + cantRegDisponibles)
    String txtRegistrado = (((('Se registro y activo usuario: ' + usuario) + ' dni: ') + dni) + ' cuit: ') + cuil

    String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

    String reg = '  ->Registro Perfil Interno en entorno ' + url

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Interno Registrado: '], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)

    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Cantidad Registros disponible: ' + 
    //       cantRegDisponibles], FailureHandling.STOP_ON_FAILURE)
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
            , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

    //if (paramRetorno.equals(1)) {
    //retorna el cuit
    return cuil.toString() //retorna el cuit y el usuario
    //} else if (paramRetorno.equals(2)) {
    //def mapDatos = [('cuil') : cuitDisponible, ('usuario') : UserSigaf]
    //return mapDatos
    //break  
    //KeywordUtil.logInfo('Estado del usuario: ' + estado)
} else {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'El usuario no fue registrado'], FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot()
}

