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
/**Script registra a un usuario como interno y luego como empleado**/
'Toma al usuario interno'
String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuit)

String ultimos4Digitos = CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dni)

//System.out.println('Cuit disponible: ' + cuit)
String userEmpleado = usuario + ultimos4Digitos

//String emailMayuscula = emailDos.toString().toUpperCase()
String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(emailHotmail)

String token

//String emailMinuscula = emailDos
System.out.println('Email mayuscula: ' + emailMayus)

'Lo registra como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('varEmail') : emailMayus, ('varPassword') : password
        , ('varCuit') : cuilSinGuiones, ('varUser') : userEmpleado, ('varTelefono') : telefono, ('varDireccion') : direccion
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuilSinGuiones, ('varToken') : token], 
    FailureHandling.STOP_ON_FAILURE)

String logTexto = ('***Log: Registro: Registra al usuario interno ' + cuilSinGuiones) + ', luego lo registra como empleado.'

String valorTexto = ('\n' + logTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitIntEmpAfi = cuilSinGuiones

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

