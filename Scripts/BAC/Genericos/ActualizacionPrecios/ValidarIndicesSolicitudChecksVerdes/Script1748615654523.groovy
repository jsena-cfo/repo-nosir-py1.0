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

boolean validados= false

def mapBoolean = [informacionBasica:false, items: false, detalle: false, autoridades:false]
//mapBoolean = [('1') : false, ('2') : false]
//(mapBoolean['1']) = 

mapBoolean["informacionBasica"]= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/img_checkValidoInformacionBasica'), 
    1)

mapBoolean["items"]= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/img_checkValidoItems'), 
    1)

mapBoolean["detalle"]= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/img_checkValidoDetalleEntrega'), 
    1)

mapBoolean["autoridades"]= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/img_checkValidoAutoridades'), 
    1)

System.out.println('MapBoolean: ' + mapBoolean)

validados = !(mapBoolean.containsValue(false))

return validados

