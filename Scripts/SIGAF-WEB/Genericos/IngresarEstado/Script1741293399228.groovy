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

String opcion = getBinding().getAt('varOpcion').toString()

WebUI.waitForElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet_filtrar/select_estado'), 2)

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet_filtrar/select_estado'))

switch (opcion) {
	case 'ingresado':
		WebUI.selectOptionByValue(findTestObject('SIGAF-WEB/Page_sigaf-redet_filtrar/select_estado'), 'I', false)

		break
	case 'anulado':
		WebUI.selectOptionByValue(findTestObject('SIGAF-WEB/Page_sigaf-redet_filtrar/select_estado'), 'X', false)

		break
	case 'autorizado':
		WebUI.selectOptionByValue(findTestObject('SIGAF-WEB/Page_sigaf-redet_filtrar/select_estado'), 'A', false)

		break
}


