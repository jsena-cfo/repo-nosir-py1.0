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

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/btn_CompletarDatos'))

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/input_PorcGarantiaImpugnacion'), porcGarantiaImpugnacion)

if (procedimiento == 'Licitación Pública') {
    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/input_PorcPreAdjudicacion'), porcPreAdjudicacion)
}

def garantiaCumplimientoContrato = CustomKeywords.'tool.utilities.capitalize'(garantiaCumplimientoContrato)

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/radio_GarantiaCumplimientoContrato', [
            ('eleccion') : garantiaCumplimientoContrato]))

def contraGarantia = CustomKeywords.'tool.utilities.capitalize'(contraGarantia)

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/radio_Contragarantia', [('eleccion') : contraGarantia]))

WebUI.setText(findTestObject('BAO/Proceso de Contratacion/Garantias/inputFondoGarantiasYReparos'), porcFondoGarantiasYReparos)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/option_Peso Argentino'))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/btn_AgregarMoneda'))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - Garantias/btn_Guardar y Volver'))

