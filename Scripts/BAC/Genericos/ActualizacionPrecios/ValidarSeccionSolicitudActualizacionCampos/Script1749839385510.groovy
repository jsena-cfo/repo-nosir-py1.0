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


boolean validados = false

mapBoolean = [('columna1') : false, ('columna2') : false, ('columna3') : false
	, ('columna4') : false, ('columna5') : false, ('columna6') : false, ('columna7') : false]


(mapBoolean['columna1'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Documento'),
	1)

(mapBoolean['columna2'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Proceso de compra'),
	1)

(mapBoolean['columna3'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Descripcin'),
	1)

(mapBoolean['columna4'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Tipo de tarea'),
	1)

(mapBoolean['columna5'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Fecha de creacin'),
	1)

(mapBoolean['columna6'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Das transcurridos'),
	1)

(mapBoolean['columna7'])= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/th_Accin'), 
    1)

validados = !(mapBoolean.containsValue(false))

return validados










