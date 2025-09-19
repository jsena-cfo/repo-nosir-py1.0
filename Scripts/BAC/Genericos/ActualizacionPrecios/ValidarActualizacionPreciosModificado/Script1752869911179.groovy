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

String valor = getBinding().getAt('varValor').toString()

String numeroOca = getBinding().getAt('varNumeroOca').toString()

String moneda= getBinding().getAt('varMoneda').toString()

String monto1 = moneda + ' ' + getBinding().getAt('varMonto1').toString()

String monto2 = moneda + ' ' + getBinding().getAt('varMonto2').toString()

boolean flujoValidado = false

WebUI.scrollToElement(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/a_Ver solicitudes'), 
    2)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/a_Ver solicitudes'))

not_run: WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_Solicitudes de Actualizacin de Precio'), 
    2)

WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_numeroOCA'), 
    2)

if (valor == 'vacio') {
    flujoValidado = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/h4_msjSinSolicitudes'), 
        2)
} else if (valor == 'modificada') {
    WebUI.scrollToElement(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_Plus1'), 
        2)

    WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_Plus1'))

    String precioActual1 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_precioActual1'))

    int compare1 = monto1.compareToIgnoreCase(precioActual1)

    WebUI.scrollToElement(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_Plus2'), 
        2)

    WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_Plus2'))

    String precioActual2 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ConsultaSolicitudesActualizacion/span_precioActual2'))

    int compare2 = monto2.compareToIgnoreCase(precioActual2)

    if ((compare1 == 0) && (compare2 == 0)) {
        flujoValidado = true
    }
}

return flujoValidado

