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
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false, ('7') : false, ('8') : false
	, ('9') : false]

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Usuario'), 1)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Usuario'),
	1)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Perfil'),
	1)

(mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_CUITCUIL'),
	1)

(mapBoolean['4']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Usu SIGAF'),
	1)

(mapBoolean['5']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Telefono'),
	1)

(mapBoolean['6']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Email'),
	1)

(mapBoolean['7']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Int. Fall'),
	1)

(mapBoolean['8']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_FH Alta'),
	1)

(mapBoolean['9']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_FH Baja'),
	1)

return mapBoolean