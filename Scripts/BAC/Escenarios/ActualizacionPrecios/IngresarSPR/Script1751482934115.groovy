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
/**Script crea SPR, realiza: 
 * Obtiene numero OCA almacenado en XLS temporal por el script OCATotalTotal
 * OCA contiene parametrizacion:  redeterminacion:false, prorroga:true, actualizacionPrecios:true, periodicidad:30, duracion:5
 * Modifica el la fecha creacion e inicio debido a: 'La fecha de prestacion debe ser mayor a la fecha de creacion de la OCA'
 * Completa items, 
 * Completa detalle de entrega, 
 * Completar autoridades
 * La envia a analista
 * Valida envio con msj "Envio a analista exitoso"
 * Nota: Se debe considerar si el dia de carga de SPR es feriado. Si es feriado falla por un tema de fechas**/

boolean flujoValido = false

mapBoolean = [('validarFlujosHechos') : false, ('validarEnvioAnalista') : false, ('validarFechaBloqueada') : false]

String numeroOCA

String numeroSPR

numeroOCA = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'OCA'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/UpdateFechaCreacionInicio'), [('varUrlVar') : urlVar
        , ('varNumeroOca') : numeroOCA], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarNumeroOca'), [('varNumeroOca') : numeroOCA], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickIniciarCompras'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndiceSolicitud/span_ndice de Solicitud de Provision'), 
    2)

numeroSPR = WebUI.getText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/span_solicitudProvision'))

(mapBoolean['validarFechaBloqueada']) = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CompletarInformacionBasica'), 
    [('varNombreText') : 'Nombre prueba', ('varObjetoText') : 'Objeto prueba'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CompletarItems'), [('varCantidad') : cantidadVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CompletarDetalleEntrega'), [('varCantidad') : cantidadVar
        , ('varDomicilio') : 'Calle Test 1234', ('varObservaciones') : 'Observacion prueba'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/CompletarAutoridades'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['validarFlujosHechos']) = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ValidarIndicesSolicitudChecksVerdes'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEnviarAnalista'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/span_msjEnvioAnalistaExitoso'), 
    2)

(mapBoolean['validarEnvioAnalista']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - ActualizacionPreciosIniciarCompra/span_msjEnvioAnalistaExitoso'), 
    2)

System.out.println('MapBoolean: ' + mapBoolean)

flujoValido = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero SPR: ' + numeroSPR)

CustomKeywords.'tool.Logger.log'('Numero OCA: ' + numeroOCA)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/RegistroTmpGuardarSPR'), [('varTipo') : 'SPR', ('varNumero') : numeroSPR
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

assert flujoValido

