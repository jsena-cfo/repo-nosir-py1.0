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

boolean validados = false

mapBoolean = [('validaciones') : false, ('solicitudEnviada') : false]

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/EsperarTransicionEstado'), [('varTiempo') : 5], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/IrMiEscritorio'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/IrOrdenCompraAbierta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/IrSolicitudActualizacionPrecios'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['validaciones']) = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ValidarSeccionSolicitudActualizacion'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEjecutar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/textarea_Justificacin'), 
    2)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/textarea_Justificacin'), 
    'Esta es al justificacion')

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarActualizacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/input_PrecioSolicitadoItem1'), 
    '2')

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEnviarSolicitud'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAceptarEnviar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['solicitudEnviada']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/span_msjSolicitudEnviada'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validados = !(mapBoolean.containsValue(false))

assert validados

