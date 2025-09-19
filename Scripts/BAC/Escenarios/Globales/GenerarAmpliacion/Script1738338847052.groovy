import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAC/Escenarios/Contratación Directa/GenerarSolicitudDeGastoCD'), [('urgencia') : 'UrgenciaContratacionDirecta'
        , ('unidadSolicitante') : 'qa'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Contratación Directa/GenerarPCParcialParcial'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Contratación Directa/GenerarPreAdjParcialParcial'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarAdjudicación'), [('nroPC') : GlobalVariable.nroPC, ('renglones') : 1], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/CompletarIndice1Justificacion'), [('accion') : 'Ingresar Solicitud de Ampliación'], 
    FailureHandling.STOP_ON_FAILURE)

def nroAmpliacion = WebUI.getText(findTestObject('BAC/Ampliacion/txtNroAmpliacion'))

KeywordUtil.logInfo(nroAmpliacion)

def nroDocContractual = WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/CompletarIndice2Items'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/CompletarIndice3DetalleYDuracion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Ampliacion/btnSolicitarAfectacion'))

WebUI.verifyTextPresent('La solicitud fue enviada satisfactoriamente. Se ha notificado al Analista de la Unidad Solicitante.', 
    false)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/IngresarCompromisoDefinitioAMP'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/AfectarCompromisoDefinitivo - Analista OGESE AMP'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/AfectarCompromisoDefinitivo - Analista OGEPU AMP'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/AfectarCompromisoDefinitivo - Autorizador OGEPU AMP'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(15)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/EnviarASupervisionUOA'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/CompletarIndice6ProyectoDeActoAdmin'), [('nroAmpliacion') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Ampliacion/RecepcionarConProveedor'), [('user') : 'dettano', ('pass') : '12345678'
        , ('nroDocContractual') : nroDocContractual], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/VerificarEstadoPerfeccionado'), [:], FailureHandling.STOP_ON_FAILURE)

