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

String cantidad = getBinding().getAt('varCantidad').toString()

String domicilio = getBinding().getAt('varDomicilio').toString()

String observaciones = getBinding().getAt('varObservaciones').toString()

//Switch to iframe WebUI.switchToFrame(findTestObject('ifr_TextArea'), 5)'
WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/a_Completar Datos3'))

not_run: WebUI.check(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/input_checkVerifiqueIingresadoDetallesCantidad'))

WebUI.check(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/input_checkAll'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickCompletarDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/iframe_Completar detalle'), 
    5)

WebUI.sendKeys(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/input_CantidadEntregar1'), cantidad)

WebUI.sendKeys(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/input_CantidadEntregar2'), cantidad)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/select_TipoDeDia'))

WebUI.selectOptionByValue(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/select_TipoDeDia'), 
    '1', false)

WebUI.selectOptionByValue(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/select_LugarEntrega'), 
    '-1', false)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/input_OtroLugar de entrega'), domicilio)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitudEntrega/textarea_Observaciones'), observaciones)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAgregarDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickCerrar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarVolver'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarYVolver'), [:], FailureHandling.STOP_ON_FAILURE)

