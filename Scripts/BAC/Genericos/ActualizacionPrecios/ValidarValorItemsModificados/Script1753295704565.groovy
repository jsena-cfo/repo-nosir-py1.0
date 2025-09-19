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

String valorItem1 = getBinding().getAt('varValorItem1').toString()

String valorItem2 = getBinding().getAt('varValorItem2').toString()

String moneda = getBinding().getAt('varMoneda').toString()

boolean preciosValidos = false

mapBoolean = [('validarMoneda') : false, ('validarValorItem1') : false, ('validarValorItem2') : false]

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/a_Completar Datos2'))

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/input_CantidadAComprar1'), 
    2)

WebUI.scrollToElement(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/input_CantidadAComprar1'), 2)

String precioItem1 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/span_itemPrecio1'))

String moneda1 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/span_itemMoneda1'))

String precioItem2 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/span_itemPrecio2'))

String moneda2 = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/span_itemMoneda2'))

(mapBoolean['validarMoneda']) = ((moneda1 == moneda) && (moneda2 == moneda))

(mapBoolean['validarValorItem1']) = (valorItem1 == precioItem1)

(mapBoolean['validarValorItem2']) = (valorItem2 == precioItem2)

System.out.println('ValorItem1: ' + valorItem1)

System.out.println('PrecioItem1: ' + precioItem1)

System.out.println('ValorItem2: ' + valorItem2)

System.out.println('PrecioItem2: ' + precioItem2)

System.out.println('MapBoolean: ' + mapBoolean)

preciosValidos = !(mapBoolean.containsValue(false))

return preciosValidos

