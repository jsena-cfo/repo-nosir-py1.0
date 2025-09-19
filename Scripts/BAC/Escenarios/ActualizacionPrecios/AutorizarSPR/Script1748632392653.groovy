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
/**Script autoriza SPR
 * Nota: Primero se pera 6 minutos (300 seg) antes de proseguir debido a que los estados de la SPR 
 * no cambian imediatamente. El estado afectar compromiso definitvo no cambia inmediatamente
 * Se autoriza la SPR: clickAutorizarSPR 
 * Se valida msj de autorizacion exitosa SPRAutorizacionExitosa**/
boolean autorizacionSPR = false

String numeroSPR = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'SPR'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/EsperarTransicionEstado'), [('varTiempo') : 360], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarSolicitudProvision'), [('varNumeroSPR') : numeroSPR], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickEditarAutorizarSPR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Autorizar SPR/input_Clave'), 10)

WebUI.scrollToElement(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Autorizar SPR/input_Clave'), 2)

WebUI.setText(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Autorizar SPR/input_Clave'), passVar)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAutorizarSPR'), [:], FailureHandling.STOP_ON_FAILURE)

autorizacionSPR = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Autorizar SPR/strong_msjSprAutorizacionExitosa'), 
    2)

System.out.println('Numero SPR: ' + numeroSPR)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert autorizacionSPR

