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

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false]

String nombre = getBinding().getAt('varNombre')

String telefono = getBinding().getAt('varTelefono')

String domicilio = getBinding().getAt('varDomicilio')

String email = getBinding().getAt('varEmail')

String intentosFallidos = getBinding().getAt('varIntentosFallidos')

(mapBoolean['1'])= WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Apellido  Nombre  Razon Social_fullName'), 'value', nombre, 2)

(mapBoolean['2'])= WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_N Telfono_nTelefono'), 'value', telefono, 2)

(mapBoolean['3'])= WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Domicilio_domicilio'), 'value', domicilio, 2)

(mapBoolean['4'])= WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Email_email'), 'value', email, 2)

(mapBoolean['5'])= WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Login Fallidos_failedAttempts'), 'value', intentosFallidos, 2)

System.out.println('MapBoolean: ' + mapBoolean)

return mapBoolean.containsValue(true)


