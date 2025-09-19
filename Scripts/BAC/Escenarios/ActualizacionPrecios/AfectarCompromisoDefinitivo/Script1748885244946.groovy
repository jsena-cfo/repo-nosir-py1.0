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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/**Author: Jer**/
/**NOTA: Durante el flujo debe presionarse un modal alert el cual es dificil capturar, por ende a veces
 * falla, no por error sino por no poderse presionar dicho alert
 * Script afecta compromiso definitivo: 
 * Hace click sobre pendeinte afectacion definitiva: clickPendienteAfectacionDefinitiva 
 * Selecciona todas las partidas 
 * Autoriza afectacion 
 * Valida msj partidas presupuestarias enviadas**/


boolean compromisoAfectado = false

String numeroSPR

numeroSPR = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'SPR'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

'Se logea como analista de compra'
WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/EsperarTransicionEstado'), [('varTiempo') : 5], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarSolicitudProvision'), [('varNumeroSPR') : numeroSPR], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickPendienteAfectacionDefinitiva'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/SeleccionarTodasPartidasPresupuestarias'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAutorizarAfectacion'), [:], FailureHandling.STOP_ON_FAILURE)

int intentos = 0

//alertPresent= WebUI.verifyAlertNotPresent(2, FailureHandling.CONTINUE_ON_FAILURE)
while ((compromisoAfectado == false) && (intentos < 10)) {
    WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ClickAutorizarAfectacion'), [:], FailureHandling.OPTIONAL)

    WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/PressModalOk'), [:], FailureHandling.OPTIONAL)

    compromisoAfectado = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - AfectacionDefinitiva/strong_msjPartidasPresupuestariasEnviadas'), 
        2, FailureHandling.OPTIONAL)

    intentos = (intentos + 1)

    if (compromisoAfectado == true) {
        break
    }
}

System.out.println('Compromiso afectado: ' + compromisoAfectado)

System.out.println('Numero SPR: ' + numeroSPR)

CustomKeywords.'tool.Logger.log'('Numero SPR: ' + numeroSPR)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

if (compromisoAfectado== true) {
	KeywordUtil.markPassed("Se afecto")
	assert true
	WebUI.verifyNotMatch('2', '1', false, FailureHandling.OPTIONAL)
}
else {
	KeywordUtil.markError("No se afecto")
	assert false
	WebUI.verifyNotMatch('2', '1', true, FailureHandling.OPTIONAL)
}

