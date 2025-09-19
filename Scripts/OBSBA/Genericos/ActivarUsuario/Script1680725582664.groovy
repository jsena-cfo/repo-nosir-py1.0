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

boolean activado = false

String numeroCuil = getBinding().getAt('varCuil').toString()

String token = getBinding().getAt('varToken').toString()

String numeroCuilSinBlancos = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(numeroCuil)

//String linkActivacion = ('https://obsba-homo.dguiaf-gcba.gov.ar/register/complete/' + numeroCuilSinBlancos) + '/1515'
//String linkActivacion = (url + 'register/complete/' + numeroCuilSinBlancos) + '/1515'
String linkActivacion = (((url + 'register/complete/') + numeroCuilSinBlancos) + '/') + token

System.out.println('Url: ' + linkActivacion)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : linkActivacion], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h1_RegistroExitoso'), 1)

//activado= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h1_RegistroExitoso'), 'Gracias por su Registro')
not_run: activado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Gracias por su Registro'], 
    FailureHandling.STOP_ON_FAILURE)

not_run: String cuilValor = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_RegistroCUITCUIL_cuit'), 
    'value')

'quita los \'-\' del cuil'
not_run: String cuitValorModificadoSinBlancos = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuilValor)

not_run: WebUI.verifyMatch(numeroCuil, cuitValorModificadoSinBlancos, false)

activado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarActivacion'), [('varCuil') : numeroCuilSinBlancos], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolverRegistro'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolverRegistroFinalizar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Activado: ' + activado.toString())

return activado

