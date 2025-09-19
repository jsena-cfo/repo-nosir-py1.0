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

//formato dd/mm/aaaa
String fecha1 = getBinding().getAt('varFecha1').toString()

String fecha2 = getBinding().getAt('varFecha2').toString()

String fecha1dStr = fecha1.substring(0, 2)

String fecha1mStr = fecha1.substring(3, 5)

String fecha1aStr = fecha1.substring(6)

String fecha2dStr = fecha2.substring(0, 2)

String fecha2mStr = fecha2.substring(3, 5)

String fecha2aStr = fecha2.substring(6)

System.out.println((((('Fecha 1: ' + fecha1dStr) + '/') + fecha1mStr) + '/') + fecha1aStr)

System.out.println((((('Fecha 2: ' + fecha2dStr) + '/') + fecha2mStr) + '/') + fecha2aStr)

int fecha1d = fecha1dStr.toInteger()

int fecha1m = fecha1mStr.toInteger()

int fecha1a = fecha1aStr.toInteger()

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha1'))

CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha1'), fecha1d, fecha1m, fecha1a, 
    2000, FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Agoda/calendar'), fecha1d, fecha1m, fecha1a, 2000, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-calendar/div__col q-input-target ellipsis justify-start-fecha2'))

