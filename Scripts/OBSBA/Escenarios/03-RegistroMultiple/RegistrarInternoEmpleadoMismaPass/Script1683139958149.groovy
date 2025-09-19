import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

/**Script registra un usuario como interno y luego como empleado con la misma pass**/
'Se registra como interno'
def cuit = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInterno'), [('password') : password], 
    FailureHandling.STOP_ON_FAILURE)

String emailMayuscula = emailDos.toString().toUpperCase()

'Se registra como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleado'), [('email') : emailMayuscula, ('password') : password
        , ('cuit') : cuit, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

String reg = '  ->Registrar Perfil Empleado Interno misma pass en entorno ' + url

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/cuilUsed.txt'], 
    FailureHandling.STOP_ON_FAILURE)

String logTexto= "***Log: Valida mensaje error: Registra un interno y luego lo registra como empleado con el mismo pass: "

String valorTexto= '\n' + logTexto + cuit.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

