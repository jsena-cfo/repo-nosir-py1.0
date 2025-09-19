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

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/select_TipoDocumento'), tipoDocumento, false)

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/select_Anio'), anio, false)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/input_Reparticion'), reparticion)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/input_Numero'), numero)

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/radio_sade'))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/btn_Buscar'))

WebUI.waitForElementClickable(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/button_Opciones'), 30)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/button_Opciones'))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/option_Vincular'))

WebUI.waitForElementPresent(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/btn_Finalizar'), 10)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - ActoAdministrativo/btn_Finalizar'))

