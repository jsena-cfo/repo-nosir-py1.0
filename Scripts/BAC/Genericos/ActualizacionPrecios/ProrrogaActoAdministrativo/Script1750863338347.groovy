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

not_run: WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/btn_IndiceActoAdministrativo'))

WebUI.selectOptionByValue(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/select_TipoDocumento'), 
    '1', false)

WebUI.selectOptionByLabel(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/select_TipoAo'), 
    anio, false)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/input_txtNumero'), 
    numero)

WebUI.check(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/check_SADE_'))

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/input_txtReparticion'), 
    reparticion)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/btn_Buscar'))

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/span_selectSADE'))

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/btn_Vincular'))

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/btn_GuardaryVolver'))

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Page_BAC - ActoAdministrativoProrroga/btn_AceptarFinalProrroga'))

