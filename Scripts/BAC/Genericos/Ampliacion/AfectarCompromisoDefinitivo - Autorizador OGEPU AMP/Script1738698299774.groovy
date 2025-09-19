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
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarAfectacionPC'), [('user') : GlobalVariable.userAutorizadorOGEPU
        , ('pass') : '12345678', ('nroPC') : nroAmpliacion, ('nombreUE') : '611 - DIR.GRAL.OFICINA DE GESTION PUBLICA Y PRESUPUESTO'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicacion/btn_Autorizar'))

WebUI.verifyElementPresent(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/MensajeDeExitoPase'), 5)

WebUI.closeBrowser()

