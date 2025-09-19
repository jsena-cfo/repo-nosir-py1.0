import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAlt'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/NavegarAIngresoYMP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/CompletarCamposRequerimientoMPParametrizado'), [('varTipoAjuste') : findTestData(
            'modificacionPresupuestariaTD').getValue(1, 1), ('varActuacion') : findTestData('modificacionPresupuestariaTD').getValue(
            2, 1), ('varTipoActuacion') : findTestData('modificacionPresupuestariaTD').getValue(3, 1), ('varNorma') : findTestData(
            'modificacionPresupuestariaTD').getValue(4, 1), ('varMotivo') : findTestData('modificacionPresupuestariaTD').getValue(
            5, 1), ('varNumero1') : findTestData('modificacionPresupuestariaTD').getValue(6, 1), ('varNumero2') : findTestData(
            'modificacionPresupuestariaTD').getValue(7, 1), ('varNumero3') : findTestData('modificacionPresupuestariaTD').getValue(
            8, 1), ('varNumero4') : findTestData('modificacionPresupuestariaTD').getValue(9, 1), ('varNumero5') : findTestData(
            'modificacionPresupuestariaTD').getValue(10, 1), ('varNumero6') : findTestData('modificacionPresupuestariaTD').getValue(
            11, 1), ('varSector') : findTestData('modificacionPresupuestariaTD').getValue(12, 1), ('varObservaciones') : findTestData(
            'modificacionPresupuestariaTD').getValue(13, 1), ('varDescripcion') : findTestData('modificacionPresupuestariaTD').getValue(
            14, 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/CompletarCreditoParametrizado'), [('varActInt') : findTestData('modificacionPresupuestariaTD').getValue(
            'colActInt', 1), ('varJuris') : findTestData('modificacionPresupuestariaTD').getValue('colJuris', 1), ('varSubJuris') : findTestData(
            'modificacionPresupuestariaTD').getValue('colSubJuris', 1), ('varEntidad') : findTestData('modificacionPresupuestariaTD').getValue(
            'colEntidad', 1), ('varPrograma') : findTestData('modificacionPresupuestariaTD').getValue('colPrograma', 1), ('varSPrograma') : findTestData(
            'modificacionPresupuestariaTD').getValue('colSPrograma', 1), ('varProyecto') : findTestData('modificacionPresupuestariaTD').getValue(
            'colProyecto', 1), ('varActo') : findTestData('modificacionPresupuestariaTD').getValue('colActo', 1), ('varObra') : findTestData(
            'modificacionPresupuestariaTD').getValue('colObra', 1), ('varInciso') : findTestData('modificacionPresupuestariaTD').getValue(
            'colinciso', 1), ('varPPal') : findTestData('modificacionPresupuestariaTD').getValue('colPPal', 1), ('varPPar') : findTestData(
            'modificacionPresupuestariaTD').getValue('colPPar', 1), ('varPSPar') : findTestData('modificacionPresupuestariaTD').getValue(
            'colPSPar', 1), ('varFF') : findTestData('modificacionPresupuestariaTD').getValue('colFF', 1), ('varMon') : findTestData(
            'modificacionPresupuestariaTD').getValue('colMon', 1), ('varUG') : findTestData('modificacionPresupuestariaTD').getValue(
            'colUG', 1), ('varFinFun') : findTestData('modificacionPresupuestariaTD').getValue('colFinFun', 1), ('varImporte') : findTestData(
            'modificacionPresupuestariaTD').getValue('colImporte', 1)], FailureHandling.STOP_ON_FAILURE)

String nroReq = WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/ObtenerTextoPorRegion'), [('x') : 302, ('y') : 156, ('w') : 33
        , ('h') : 12], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

return nroReq

