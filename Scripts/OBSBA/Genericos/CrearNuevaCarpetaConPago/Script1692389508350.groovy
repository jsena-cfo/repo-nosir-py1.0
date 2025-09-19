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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String cuil = getBinding().getAt('varCuil').toString()

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

not_run: String fecha = '06-06/2023'

String fecha2 = '06-2023'

String importe2 = '100,11'

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : 'BienSalud'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

boolean check = WebUI.verifyElementChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 1, FailureHandling.OPTIONAL)

if (check == false) {
    System.out.println('Check desmarcado')

    WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'))

(mapBoolean['1']) = WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 
    'value', 'MM-YYYY', 2, FailureHandling.OPTIONAL)

not_run: WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 
    'value', 'DD/MM/YYYY', 2, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), 'value', cuil, 
//    2, FailureHandling.OPTIONAL)
String cuitBeneficiario = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), 
    'value')

String cuitBeneficiarioSinComillas = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuitBeneficiario)

TestObject to = new TestObject()

to.addProperty('text', ConditionType.EQUALS, cuitBeneficiarioSinComillas)

(mapBoolean['2']) = WebUI.verifyElementText(to, cuil, FailureHandling.OPTIONAL)

WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), 'type', 
    'number', 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), fecha2)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), importe2)

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_TituloCarpetaMod'), 'titulo' + valorRandom)

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_DescripcionCarpetaMod'), 'descripcion' + 
    valorRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_TituloCarpetaMod'), 'titulo' + valorRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_DescripcionCarpetaMod'), 'descripcion' + valorRandom)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Guardar'), 2)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Guardar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.delay(2)
WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

return mapBoolean

