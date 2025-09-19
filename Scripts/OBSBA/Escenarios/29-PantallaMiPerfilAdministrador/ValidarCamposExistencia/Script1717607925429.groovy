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
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false,
	('6') : false, ('7') : false, ('8') : false, ('9') : false, ('10') : false]

boolean validar = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Apellido  Nombre  Razon Social_fullName'), 
    1)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Tipo Perfil'), 1)

(mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Nombre de Usuario_userName'), 
    1)

(mapBoolean['4']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Tipo Documento_tipoDocumento'), 
    1)

(mapBoolean['5']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_CUITCUIL_nDocumento'), 
    1)

(mapBoolean['6']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'), 
    1)

(mapBoolean['7']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'), 1)

(mapBoolean['8']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Email_email'), 1)

(mapBoolean['9']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputNuevaContrasena'), 1)

(mapBoolean['10']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputRepitaContrasea'), 1)

validar = !(mapBoolean.containsValue(false))

System.out.println('Valida existe inputs: ' + mapBoolean.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

