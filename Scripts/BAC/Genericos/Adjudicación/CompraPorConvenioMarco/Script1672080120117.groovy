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

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnComprarPorCVM'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnComprar'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpCantidadAComprar'), '1')

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnGuardaryVolver'))

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/selectAutorizadores'), autorizador, false)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnAgregarAutorizador'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpTelefono'), '12345678')

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnSiguientePaso'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnSolicitarAfectacion'))

WebUI.waitForElementPresent(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/txt_SolicitudDeCompra'), 5)

def solicitudDeCompra = WebUI.getText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/txt_SolicitudDeCompra'))

return solicitudDeCompra