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

/**Author: JER**/
/**Accede al link que contiene la pantalla de error y se valida el formato especificado**/
WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : varUrl + 'error'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/span_INICIO'), 1)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/p_labelPaginaNo'), 1)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/p_labelEncontrada'), 1)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/p_label404'), 1)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/p_labelComunicarse'), 1)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/span_INICIO'), 1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ValidarError404/span_INICIO'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

