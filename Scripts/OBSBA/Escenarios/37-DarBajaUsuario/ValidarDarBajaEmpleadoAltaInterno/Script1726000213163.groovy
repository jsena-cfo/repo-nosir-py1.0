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

/**Author: Jer**/
/**Da de baja un usuario interno**/
/**si existe una fecha de baja y se borra dicha información en el campo
 * “FH Baja” de Administrar Usuario, el campo FH_BAJA de la tabla BUSUARIO_PORTAL
 * debe quedar en NULL**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

boolean validar = false

'Se registra un empleado'
String cuitEmpleado = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarEmpleadoAlt'), [('password') : pass
        , ('telefono') : varTelefono, ('direccion') : varDomicilio, ('email') : varEmail, ('url') : varUrl, ('fileXlsUsuarios') : GlobalVariable.fileXlsEmpleados
        , ('dataFileUsuarios') : GlobalVariable.dataFileEmpleados], FailureHandling.STOP_ON_FAILURE)

'Se loguea como administrador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'empleado'
        , ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : cuitEmpleado, ('varFechaDesde') : '', ('varFechaHasta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

'Se da de baja al empleado'
(mapBoolean['1']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/DarBajaUsuario'), [('varUsuarioBloqueo') : cuitEmpleado], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

String usuario = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioConCuilSinGuiones'(cuitEmpleado)

'se registra al empleado como interno luego de la baja'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : usuario, ('varCuil') : cuitEmpleado
        , ('varPassword') : pass, ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
    false, FailureHandling.OPTIONAL)

if (registroSatisfactorio == true) {
    boolean activado = false

    String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuitEmpleado)

    token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

    activado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuitEmpleado, ('varToken') : token], 
        FailureHandling.STOP_ON_FAILURE)

	//retorna el cuit y el usuario
    //String cuitReturn = cuilSinGuiones.toString()
	(mapBoolean['2']) = activado
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['3'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarUsuarioLogin'), [('varUsuario') : cuitEmpleado, ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

System.out.println('Mapboolean Validaciones: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

assert validar