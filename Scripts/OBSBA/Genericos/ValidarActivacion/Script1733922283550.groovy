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


String numeroCuilSinBlancos= this.getBinding().getAt('varCuil').toString()

//numeroCuilSinBlancos = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(numeroCuil)

String numeroCuilConGuiones= CustomKeywords.'adicionales.CuilRandomGenerator.agregarGuionesCuil'(numeroCuilSinBlancos) 

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

boolean activado= false

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h1_RegistroExitoso'), 1)

//activado= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h1_RegistroExitoso'), 'Gracias por su Registro')

(mapBoolean['1'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Gracias por su Registro'], FailureHandling.STOP_ON_FAILURE)

String cuilValor = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_RegistroCUITCUIL_cuit'), 'value')

'quita los \'-\' del cuil'
String cuitValorModificadoSinBlancos = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuilValor)

(mapBoolean['2'])= WebUI.verifyMatch(numeroCuilSinBlancos, cuitValorModificadoSinBlancos, false)

//(mapBoolean['2'])= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_RegistroCUITCUIL_cuit'), numeroCuilConGuiones)

activado = !(mapBoolean.containsValue(false))

return activado