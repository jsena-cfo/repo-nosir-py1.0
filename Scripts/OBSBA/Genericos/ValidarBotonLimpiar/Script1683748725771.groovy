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

boolean present = false

//boolean valCheckContiene
//boolean valInpTitulo
//boolean valInpDesc
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'), 2)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : 'BienSalud'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: boolean check = WebUI.verifyElementChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 
    2, FailureHandling.OPTIONAL)

not_run: if (check == false) {
    not_run: System.out.println('Check desmarcado')

    not_run: WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarCheckActivadoDeschequear'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.uncheck(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'), 'prueba tipo carpeta')

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion de Carpeta'), 'Prueba Descripcion carpeta')

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Limpiar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementNotChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_contienePago'), 
    1)

(mapBoolean['2']) = WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'), 
    'value', '', 1)

(mapBoolean['3']) = WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion de Carpeta'), 
    'value', '', 1)

/**
System.out.println('Validacion check: ' + valCheckContiene.toString())

System.out.println('Validacion titulo: ' + valInpTitulo.toString())

System.out.println('Validacion descripcion: ' + valInpDesc.toString())

if (((valCheckContiene == true) && (valInpTitulo == true)) && (valInpDesc == true)) {
    present = true
} else if (((valCheckContiene == false) || (valInpTitulo == false)) || (valInpDesc == false)) {
    present = false
}
**/
System.out.println('Valor maps: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

//assert present
return present

