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

//Agregar Garantía
WebUI.click(findTestObject('BAC/Page_BAC - Vista Proveedor/a_IngresarGarantia'))

def montoAConstituir = WebUI.getText(findTestObject('BAO/Proveedor/txtMontoAConstituir'))

def montoParseado = montoAConstituir.replaceAll('[^\\d,]', '')

WebUI.selectOptionByValue(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/ddFormaDePago'), '0', true)

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/inp_NumeroDocumento'), '12345678')

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/inp_EntidadLegal'), '122')

WebUI.setText(findTestObject('BAC/Page_BAC - Vista Proveedor/inpMonto'), montoParseado)

WebUI.click(findTestObject('BAO/Proveedor/inputObsGarantia'))

WebUI.setText(findTestObject('BAO/Proveedor/inputObsGarantia'), 'test')

WebUI.waitForElementClickable(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/a_IngresarGarantia'), 5)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/a_IngresarGarantia'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/a_Guardar y volver (1)'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/a_SiguientePaso'))

