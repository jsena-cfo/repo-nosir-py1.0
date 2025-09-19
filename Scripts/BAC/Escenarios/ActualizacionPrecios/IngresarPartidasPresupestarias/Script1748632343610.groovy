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
/**ingresar partidas presupuestarias hace: 
 * Edita SPR: ClickEditarSPR 
 * Completa Partidas 
 * Realiza afectacion definitiva: ClickAfectacionDefinitiva 
 * Valida msj exitoso de afectacion de partidas**/
boolean validados = false

def mapBoolean = [('indices') : false, ('partidas') : false, ('afectacionDefinitiva') : false]

String numeroSPR = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'SPR'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

'Se logea como analista de compra'
WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/EsperarTransicionEstado'), [('varTiempo') : 5], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarSolicitudProvision'), [('varNumeroSPR') : numeroSPR], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEditarSPR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CompletarPartidas'), [('varMonto') : cantidadImpuitadaVar], 
    FailureHandling.STOP_ON_FAILURE)

(mapBoolean['indices']) = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ValidarIndicesSolicitudChecksVerdes'), 
    [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['partidas']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/img_validacion4Lugar y fecha de entrega'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAfectacionDefinitiva'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['afectacionDefinitiva']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IngresoPartidas/span_msjExitosoPartidas'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

System.out.println('Numero SPR: ' + numeroSPR)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

validados = !(mapBoolean.containsValue(false))

assert validados

