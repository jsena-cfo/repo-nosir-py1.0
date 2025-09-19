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

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/select_ProvinciaDomicilio'), provincia, false)

WebUI.waitForElementPresent(findTestObject('RIUPP/Page_BAC - Indice 2/select_Partido'), 5)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/select_Partido'), partido, false)

WebUI.waitForElementPresent(findTestObject('RIUPP/Page_BAC - Indice 2/select_Localidad'), 5)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/select_Localidad'), localidad, false)

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Calle'), 'test')

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Nmero'), '1234')

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Cdigo postal'), '1234')

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Nmero de telfono'), '1122334455')

not_run: WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Nmero de telfono alternativo'), 
    '1122334466')

not_run: WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/input_Nmero de fax'), '1122334477')

