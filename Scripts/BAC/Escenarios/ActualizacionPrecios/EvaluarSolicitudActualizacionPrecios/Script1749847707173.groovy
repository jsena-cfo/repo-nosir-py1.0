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
/**Script realiza evaluacion de solicitud de actualizacion de precios y confirma**/
boolean solicitudActualizacionPreciosEvaluada = false

mapBoolean = [('actualizacionPreciosEvaluada') : false, ('actualizacionPreciosConfirmada') : false]

String numeroOCA

String numeroSPR

numeroOCA = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'OCA'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarNumeroOca'), [('varNumeroOca') : numeroOCA], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEvaluarActualizacionPrecios'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - EvaluarSolicitudActualizacionPrecios/h2_Evaluacin de Actualizacin de Precios'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/BuscarDocumentoGedo'), [('varTipoDocumento') : varTipoDocumento
        , ('varAnio') : varAnio, ('varReparticion') : varReparticion, ('varNumero') : varNumero, ('varSade') : varSade], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/PrevisualizarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Vincular'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['actualizacionPreciosEvaluada']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - EvaluarSolicitudActualizacionPrecios/label_msjVinculadoDocumentoExitoso'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ConfirmarActualizacionPrecios'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['actualizacionPreciosConfirmada']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - EvaluarSolicitudActualizacionPrecios/span_msjOcaActualizadaSatisfactoriamente'), 
    2)

System.out.println('MapBoolean: ' + mapBoolean)

solicitudActualizacionPreciosEvaluada = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'tool.Logger.log'('Numero OCA: ' + numeroOCA)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

assert solicitudActualizacionPreciosEvaluada

