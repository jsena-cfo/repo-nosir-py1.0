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

boolean todosVacios = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false, ('7') : false]

(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Apellido  Nombre  Razon Social_fullName'),
	'')

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Tipo usuario'),
	'')

(mapBoolean['3']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Nombre de Usuario_userName'),
	'')

(mapBoolean['4']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Intentos Fallidos_failedAttempts'),
	'')

(mapBoolean['5']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_CUITCUIL_nDocumento'),
	'')

(mapBoolean['6']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha desde_dateFrom'),
	'')

(mapBoolean['7']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha hasta_dateTo'),
	'')

todosVacios = !mapBoolean.containsValue(false)

return todosVacios
