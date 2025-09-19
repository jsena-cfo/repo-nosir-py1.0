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

WebUI.click(findTestObject('BAO/Adjudicacion/Orden de compra/btnEditar'))

WebUI.waitForElementPresent(findTestObject('BAO/Adjudicacion/btnCompletarDatosDeContrato'), 5)

WebUI.click(findTestObject('BAO/Adjudicacion/btnCompletarDatosDeContrato'))

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/Orden de compra/selectCondDePago'), 'Días corridos', false)

WebUI.setText(findTestObject('BAO/Adjudicacion/Orden de compra/inputPlazoCondicionPago'), '15')

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/Orden de compra/selectPlazoGarantia'), 'Días corridos', false)

WebUI.setText(findTestObject('BAO/Adjudicacion/Orden de compra/inputPlazoGarantia'), '15')

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/Orden de compra/selectPlazoEjecucion'), 'Días corridos', false)

WebUI.setText(findTestObject('BAO/Adjudicacion/Orden de compra/inputPlazoEjecucion'), '15')

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/Orden de compra/selectPlazoCertificacion'), 'Días corridos', false)

WebUI.setText(findTestObject('BAO/Adjudicacion/Orden de compra/inputPlazoCertificacion'), '15')

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/Orden de compra/selectPlazoMantenimiento'), 'Días corridos', 
    false)

WebUI.setText(findTestObject('BAO/Adjudicacion/Orden de compra/inputPlazoMantenimiento'), '15')

WebUI.click(findTestObject('BAO/Adjudicacion/Orden de compra/a_Guardar y Volver'))

WebUI.click(findTestObject('BAO/Adjudicacion/Orden de compra/btnVolver'))

