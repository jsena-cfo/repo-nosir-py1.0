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

boolean permisoNoVisible = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/label_Nuevo Documento'), 1)

(mapBoolean['1']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/label_Nuevo Documento'), 
    1, FailureHandling.OPTIONAL)

(mapBoolean['2']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'), 
    1, FailureHandling.OPTIONAL)

(mapBoolean['3']) = WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_SubirDocumento'), 
    1, FailureHandling.OPTIONAL)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
permisoNoVisible = !(mapBoolean.containsValue(false))

return permisoNoVisible

