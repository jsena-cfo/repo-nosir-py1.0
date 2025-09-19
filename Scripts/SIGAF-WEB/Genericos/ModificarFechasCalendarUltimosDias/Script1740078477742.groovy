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


String varMesesAtras= this.getBinding().getAt('varMesesAtras').toString()

int intMesesAtras = varMesesAtras.toInteger()

//formato dd/mm/aaaa
WebUI.waitForElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha1'), 
    2)

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha1'))

WebUI.waitForElementClickable(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/button_chevron_left'), 2)

for (int i = 0; i < intMesesAtras; i++) {
  WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/button_chevron_left'))
}

WebUI.waitForElementClickable(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div_27'), 2)

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div_27'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha2'), 
    2)

//CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Agoda/calendar'), fecha1d, fecha1m, fecha1a, 2000, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha2'))

WebUI.waitForElementClickable(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/button_chevron_left'), 2)

for (int i = 0; i < intMesesAtras; i++) {
  WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/button_chevron_left'))
}

WebUI.waitForElementClickable(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div_28'), 2)

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div_28'))

