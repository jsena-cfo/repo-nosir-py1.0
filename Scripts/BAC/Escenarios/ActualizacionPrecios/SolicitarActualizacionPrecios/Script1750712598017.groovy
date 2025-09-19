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
/**Script solicita actualizacion de precios
 * Modifica el cronograma de tal forma que la fecha desde sea menor que hoy y la fecha hasta 3 dias mayor a hoy
 * Los rangos del cronograma no deben superponerse (donde termina uno empieza el otro)**/
boolean actualizacionSolicitada = false

mapBoolean = [('validarFlujosHechos') : false, ('validarEnvioAnalista') : false, ('validarFechaBloqueada') : false]

String numeroOCA

String numeroSPR

numeroOCA = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'OCA'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

'Se ejecuta en ValidarVolverSoliciarActualizacion'
not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/UpdateCronograma'), [('varUrlVar') : urlVar
        , ('varNumeroOca') : numeroOCA], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarNumeroOca'), [('varNumeroOca') : numeroOCA], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickSolicitarActualizacionPrecios'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/textarea_Justificacin'), 
    2)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/textarea_Justificacin'), 
    'Esta es al justificacion de solicitar actualizacion  de precios')

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickGuardarActualizacion'), [:], FailureHandling.STOP_ON_FAILURE)

'Decrementa el monto del item 1'
WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CambiarValorPrecioItem1'), [('varMonto') : precioDecrementoVar], 
    FailureHandling.STOP_ON_FAILURE)

'Incrementa el monto del item 2'
WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CambiarValorPrecioItem2'), [('varMonto') : precioIncrementoVar], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEnviarSolicitud'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAceptarEnviar'), [:], FailureHandling.STOP_ON_FAILURE)

actualizacionSolicitada = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/span_msjSolicitudEnviada'), 
    2)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'tool.Logger.log'('Numero OCA: ' + numeroOCA)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

assert actualizacionSolicitada

