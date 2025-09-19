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

boolean errorLogin = false

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederUrl'), [('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/h2_Ingreso al Sistema'), 1)

WebUI.sendKeys(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/input_Usuario_LoginpnlEmptyUserName'), varUser)

WebUI.sendKeys(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/input_Contrasea_LoginpnlEmptyPassword'), varPass1)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickLogin'), [:], FailureHandling.STOP_ON_FAILURE)

errorLogin = WebUI.verifyElementVisible(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/span_Contrasea incorrecta'))

'SI hay un error de login prueba con el pass2'
String msjError = WebUI.getAttribute(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/span_Contrasea incorrecta'), 'text')

    System.out.println('Error: ' + msjError)
	
	if(msjError!= null) {

      WebUI.sendKeys(findTestObject('SIGAF-WEB/Page_sigaf-redet_Login/input_Contrasea_LoginpnlEmptyPassword'), varPass2)

      WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickLogin'), [:], FailureHandling.STOP_ON_FAILURE)
    }

