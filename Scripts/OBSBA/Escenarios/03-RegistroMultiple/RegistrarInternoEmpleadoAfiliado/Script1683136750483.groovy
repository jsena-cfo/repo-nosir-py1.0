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

/**Script registra a un usuario como interno, luego como empleado y luego como afiliado**/
'Lo registra como interno'
String cuit = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInterno'), [('password') : password], 
    FailureHandling.STOP_ON_FAILURE)

//System.out.println('Cuit disponible: ' + cuit)
String userEmpleado = 'REGRESION' + cuit.toString()

String emailMayuscula = emailDos.toString().toUpperCase()

String token

//String emailMinuscula = emailDos
System.out.println('Email mayuscula: ' + emailMayuscula)

'Lo registra como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('varEmail') : emailMayuscula, ('varPassword') : password
        , ('varCuit') : cuit, ('varUser') : userEmpleado, ('varTelefono') : telefono, ('varDireccion') : direccion, ('varUrl') : url], 
    FailureHandling.STOP_ON_FAILURE)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

'Lo registra como afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuit, ('varPassword') : password, ('varPerfil') : 'Afiliado'
        , ('varUsuario') : userEmpleado, ('varEmail') : emailMayuscula, ('varTelefono') : telefono, ('varDomicilio') : direccion
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

String logTexto= "***Log: Valida mensaje error: Registra un interno, luego lo registra como empleado y luego como afiliado: "

String valorTexto= '\n' + logTexto + cuit.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

