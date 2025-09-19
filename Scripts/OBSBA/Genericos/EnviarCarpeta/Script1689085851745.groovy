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

boolean enviado = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/button_ENVIAR'), 1)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/button_ENVIAR'), 
    1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickEnviar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/h2_msjDocumentoEnviado'), 1)

//String mensajeValidado = 'La documentación se ha enviado exitosamente.'
String mensajeValidado = 'La documentación se ha enviado exitosamente'

//(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/h2_msjDocumentoEnviado'), 
//    mensajeValidado, FailureHandling.OPTIONAL)

(mapBoolean['2'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : mensajeValidado], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

enviado = !(mapBoolean.containsValue(false))

return enviado

