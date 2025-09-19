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

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuOCA'), [('varOpcion') : 'AdministrarSolicitudes'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

String numOCASRD = WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ObtenerNumOCASRD'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EscribirLogStr'), [('varStr') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroOCA'), [('varNumOCA') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarEstado'), [('varOpcion') : 'ingresado'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickBuscar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederPrimerDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

WebUI.scrollToElement(findTestObject('SIGAF-WEB/Page_sigaf-redet-transicionar/button_Anular'), 2)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickAnular'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/CargarComentarioAnular'), [('varComentario') : 'Se anula la SRD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickAceptarAnular'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.sendKeys(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/div_modalAnular'), Keys.chord(Keys.TAB))

not_run: WebUI.sendKeys(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/div_modalAnular'), Keys.chord(Keys.ENTER))

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

anulada = WebUI.verifyElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/div_mensajeExitoAnulada'), 2)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert anulada

