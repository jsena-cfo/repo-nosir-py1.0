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


String monto= this.getBinding().getAt('varMonto').toString()

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/a_Completar Datos4Partidas'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarIngresarPartidas'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.check(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/input_checkPartidas'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickIngresarImputacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/input_montoPartida'), monto)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickIngresarDetalleImputacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/iframe_Ingresar imputacin presupuestaria'), 
    5)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/a_Agregar nueva imputacin2'), 
    2)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/a_Agregar nueva imputacin2'))

WebUI.sendKeys(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/input_Fecha imputacin'), hoy)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/input_Monto importe'), monto)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAceptarImputacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarVolver'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarYVolver'), [:], FailureHandling.STOP_ON_FAILURE)

