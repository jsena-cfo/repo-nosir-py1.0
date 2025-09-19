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
import com.kms.katalon.core.testobject.ConditionType

//Mobile.waitForElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/button_AceptarAnular'), 2)

//WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/button_AceptarAnular'))

//not_run: WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-anular/div_AceptarAnular'))

//TestObject dynamicObject = new TestObject('Object Repository/Page/dynamicObject').addProperty('name', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'nome_do_solicitante', true)


xpath = '/html/body/div[3]/div[2]/div[3]/button[1]'
TestObject dynamicObject = new TestObject(xpath)
dynamicObject.addProperty("xpath", ConditionType.EQUALS, xpath)

WebUI.click(dynamicObject)
