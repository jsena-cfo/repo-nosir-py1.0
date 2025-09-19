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

int number= CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

def mapBoolean = [('guardada') : false, ('textoValido') : false]

String comentario = 'Carga comentario ' + number.toString()

boolean guardada = false

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuOCA'), [('varOpcion') : 'AdministrarSolicitudes'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

String numOCASRD = WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ObtenerNumOCASRD'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EscribirLogStr'), [('varStr') : 'Numero OCA: ' + numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroOCA'), [('varNumOCA') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarEstado'), [('varOpcion') : 'ingresado'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickBuscar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederPrimerDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

WebUI.scrollToElement(findTestObject('SIGAF-WEB/Page_sigaf-redet-guardar/textarea_comentario'), 1)

WebUI.clearText(findTestObject('SIGAF-WEB/Page_sigaf-redet-guardar/textarea_comentario'))

WebUI.setText(findTestObject('SIGAF-WEB/Page_sigaf-redet-guardar/textarea_comentario'), comentario)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickConfirmar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['guardada']) = WebUI.verifyElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-guardar/div_Registro guardado'), 
    2)

String val = WebUI.getAttribute(findTestObject('SIGAF-WEB/Page_sigaf-redet-guardar/textarea_comentario'), 'value')

(mapBoolean['textoValido']) = comentario.equals(val)

System.out.println('Comentario guardado: ' + val)

System.out.println('Map Booleans: ' + mapBoolean.toString())

guardada = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert guardada

