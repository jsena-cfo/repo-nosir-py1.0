import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser(GlobalVariable.URL_Acelerador)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Acelerador/inputNroPliego', [('variable') : accion]), pliego)

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Acelerador/btnAccion', [('variable') : accion]))

def mensajeObtenido = WebUI.getText(findTestObject('BAC/Pre Adjudicacion/Acelerador/spanMsj'))

def colorMensajeObtenido = WebUI.getAttribute(findTestObject('BAC/Pre Adjudicacion/Acelerador/spanMsj'), 'style')

if (colorMensajeObtenido.contains('green')) {
    KeywordUtil.logInfo(mensajeObtenido)
    WebUI.takeScreenshot()
} else {
    KeywordUtil.markFailedAndStop(mensajeObtenido)
}

WebUI.closeBrowser()
