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
/**Script genera una nueva SPR y valida que se cree con los valores de precios que se impactaron con la 
 * ultima actualziacion de precios**/

boolean validarItems = false

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
    [('varNombreText') : 'nombre prueba', ('varObjetoText') : 'objeto prueba'], FailureHandling.STOP_ON_FAILURE)

validarItems= WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ValidarValorItemsModificados'), [('varValorItem1') : varItem1
        , ('varValorItem2') : varItem2, ('varMoneda') : varMoneda], FailureHandling.STOP_ON_FAILURE)

assert validarItems