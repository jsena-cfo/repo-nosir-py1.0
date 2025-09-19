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
String usuarioBloqueo = getBinding().getAt('varUsuarioBloqueo').toString()

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

String tomorrow = CustomKeywords.'tool.DateGenerator.tomorrow'()

boolean validar = false

System.out.println('Dia mañana: ' + tomorrow)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/button_darBaja'))

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/span_CONFIRMARBaja'), 1)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_fechaBaja'), tomorrow)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_motivoBaja'), 'prueba baja')

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/span_CONFIRMARBaja'))

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/h2_msjOperacionRealizadaExitosamente'),
	1)

(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/h2_msjOperacionRealizadaExitosamente'),
	'Operación realizada exitosamente')

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/p_msjUsuarioBaja'),
	'El usuario fue dado de baja.')

(mapBoolean['3']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/ValidarUsuarioFHBajaBD'),
	[('varUsuario') : usuarioBloqueo, ('varValidarCondicion') : 'noNull'], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

return validar