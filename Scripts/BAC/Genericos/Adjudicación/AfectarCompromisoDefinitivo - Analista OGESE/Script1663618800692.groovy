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

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPCDesdeHomePage'), [('nroPC') : nroPC, ('user') : GlobalVariable.userAdministrador
//        , ('pass') : GlobalVariable.passAdministrador], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarAfectacionPC'), [('user') : GlobalVariable.userAnalista
        , ('pass') : GlobalVariable.passAnalista, ('nroPC') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/selectAnalistaOGEPU'), 'Sandra Mazza', true)

not_run: WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_AgregarAnalistaSG'))

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/input_DatosUsuariotxtClave'), GlobalVariable.passAdministrador)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/a_Autorizar'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/a_Confirmar'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/MensajeDeExitoAfectacion'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/a_Enviar a UOA'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/MensajeDeExitoPase'))

WebUI.closeBrowser()

