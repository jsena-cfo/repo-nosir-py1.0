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

boolean anulada = false

def mapBoolean = [('estaDetalle') : false, ('esNumeroOCA') : false, ('noClickeable') : false]

boolean validations = false

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuOCA'), [('varOpcion') : 'AdministrarSolicitudes'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

String numOCASRD = WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ObtenerNumOCASRD'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EscribirLogStr'), [('varStr') : "Numero OCA: " + numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroOCA'), [('varNumOCA') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarEstado'), [('varOpcion') : 'anulado'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickBuscar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederPrimerDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

(mapBoolean['estaDetalle']) = WebUI.verifyElementText(findTestObject('SIGAF-WEB/Page_sigaf-redet-detalle/span_Detalle'), 
    'Detalle')

(mapBoolean['esNumeroOCA']) = WebUI.verifyElementText(findTestObject('SIGAF-WEB/Page_sigaf-redet-detalle/label_detalleOCA'), 
    numOCASRD)

not_run: WebUI.verifyElementText(findTestObject('SIGAF-WEB/Page_sigaf-redet-detalle/estado_detalle'), 'ANULADO')

not_run: WebUI.verifyElementAttributeValue(findTestObject('SIGAF-WEB/Page_sigaf-redet-detalle/estado_detalle'), 'text', 
    'ANULADO', 2)

(mapBoolean['noClickeable']) = WebUI.verifyElementNotClickable(findTestObject('SIGAF-WEB/Page_sigaf-redet-detalle/estado_detalle'))

validations = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert validations

