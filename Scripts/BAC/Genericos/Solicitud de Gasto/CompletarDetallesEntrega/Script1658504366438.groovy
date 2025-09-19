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

if (WebUI.verifyElementPresent(findTestObject('BAC/Home/btn_CompletarDatosEntrega'), 5, FailureHandling.OPTIONAL) == true) {
    WebUI.click(findTestObject('BAC/Home/btn_CompletarDatosEntrega'))
}

WebUI.check(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/chkboxSeleccionarItem', [('codigoItem') : codigoItem]))

WebUI.click(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/btn_Completar Detalle'))

WebUI.waitForElementClickable(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/input_CantAEntregar', 
        [('codigoItem') : codigoItem]), 10)

def cantAEntregar = WebUI.getAttribute(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/label_CantPendiente'), 
    'value')

WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/input_CantAEntregar', [('codigoItem') : codigoItem]), 
    cantAEntregar)

WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/input_PlazoDeEntrega'), plazoEntrega)

WebUI.selectOptionByLabel(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/selectLugarDeEntrega'), 
    'Otra', false)

WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/input_OtroLugarDeEntrega'), 'test')

WebUI.selectOptionByLabel(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/selectTelefono'), 'Otra', 
    false)

WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/input_OtroTelefono'), '12345678')

WebUI.scrollToElement(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/btn_Agregar Detalle'), 5)

WebUI.click(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar datos de entrega/btn_Agregar Detalle'))

WebUI.refresh()



