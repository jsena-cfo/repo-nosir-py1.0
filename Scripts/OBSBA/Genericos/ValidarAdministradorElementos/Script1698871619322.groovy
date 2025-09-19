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

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/label_Consulta Usuarios'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Apellido  Nombre  Razon Social_fullName'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Tipo usuario'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Nombre de Usuario_userName'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Intentos Fallidos_failedAttempts'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_CUITCUIL_nDocumento'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha desde_dateFrom'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha hasta_dateTo'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/span_Limpiar'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/button_Buscar'), 2, FailureHandling.STOP_ON_FAILURE)

