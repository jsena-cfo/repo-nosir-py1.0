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

boolean validar= false 

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false]

(mapBoolean['1']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Apellido  Nombre  Razon Social_fullName'), 
    'value')

(mapBoolean['2']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Tipo Documento_tipoDocumento'), 
    'value')

(mapBoolean['3']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_CUITCUIL_nDocumento'), 'value')

(mapBoolean['4']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'), 'value')

(mapBoolean['5']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'), 'value')

(mapBoolean['6']) = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Email_email'), 'value')

validar = !(mapBoolean.containsValue(false))

return validar

