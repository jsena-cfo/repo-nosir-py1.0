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

/**Script que valida al ingresas cuil invalido se muestre el mensaje 'Cuit/Cuil Inválido'**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

boolean validacion = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_Login/inputCUIL'), Usuario)

(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_Login/p_msjCUITCUIL Invlido'), 'CUIT/CUIL Inválido', 
    FailureHandling.OPTIONAL)

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_Login/p_msjCUITCUIL Invlido'), 'CUIT/CUIL inválido', 
    FailureHandling.OPTIONAL)

System.out.println('Valor maps: ' + mapBoolean)

if (((mapBoolean['1']) == true) || ((mapBoolean['2']) == true)) {
    validacion = true
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validacion

