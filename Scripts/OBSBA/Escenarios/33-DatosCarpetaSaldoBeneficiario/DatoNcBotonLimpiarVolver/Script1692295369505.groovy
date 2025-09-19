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

/**Author: Jer**/
/**Valida el funcionamiento de los botones limpiar y volver**/
/**Valida que al presionar limpiar se limpia el tipo de carpeta
 * el check y los campos hidden se ocultan**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false]

boolean ingreso = false

'Se loguea como prestador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

'Valida que haya vuelto a la pantalla anterior'
(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Nueva Carpeta'), 
    1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

'Carga tipo de carpeta Bien Salud (no reintegro)'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : 'BienSalud'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

boolean check = WebUI.verifyElementChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 1, FailureHandling.OPTIONAL)

if (check == false) {
    System.out.println('Check marcado')

    WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkNoSoyBeneficiario'))

String fecha = '06/06/2023'

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), usuario)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), fecha)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), '100')

//WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin'), '100')
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

//String val1= WebUI.getAttribute('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion', 'value')
//System.out.println('Tamanio1: ' + val1.length())
//int lenght2 = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion')).length()
//System.out.println('Tamanio2: ' + lenght2)
//String val01 = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 'value', FailureHandling.OPTIONAL)
'Valida que el check se haya limpiado'
(mapBoolean['2']) = WebUI.verifyElementNotChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 
    1)

'Valida que el check se haya limpiado'
(mapBoolean['3']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/inputTipoCarpeta'), '')

'Valida que el input importe se haya limpiado'
not_run: boolean bool022 = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin'), 
    2, FailureHandling.OPTIONAL)

'Valida que el input fecha se haya limpiado'
not_run: boolean bool032 = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 
    2, FailureHandling.OPTIONAL)

'Valida que el input fecha se haya limpiado'
(mapBoolean['4']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), 
    1)

//boolean bool023 = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin'), 
//    2, FailureHandling.OPTIONAL)
'Valida que el input importe se haya limpiado'
(mapBoolean['5']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), 
    1)

//boolean bool033 = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Fecha de Prestacin'), 
//    2, FailureHandling.OPTIONAL)
'Valida que el input fecha se haya limpiado'
(mapBoolean['6']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 
    1)

//def mapBoolean
//mapBoolean3 = [('2') : bool01, ('3') : bool02, ('4') : bool03]
System.out.println('Valor maps: ' + mapBoolean)

ingreso = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert ingreso

