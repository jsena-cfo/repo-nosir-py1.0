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

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 6 UT/inputLugarConstitucin'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 6 UT/inputfechaConstitucion'), GlobalVariable.fechaActual)

def fechaVigencia = CustomKeywords.'tool.DateGenerator.dateNDaysLaterToday'(365)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 6 UT/inputfechaVigencia'), fechaVigencia)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6 UT/btnSiguiente'))

WebUI.verifyTextPresent('Debe ingresar al menos un proveedor', false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 6 UT/inputRazonSocial'), 'fischetti')

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6 UT/btnBuscarRazonSocial'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6 UT/btnAgregarProvAsociado'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6 UT/btnSiguiente'))

