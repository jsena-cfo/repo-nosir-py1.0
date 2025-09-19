import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.UE], FailureHandling.STOP_ON_FAILURE)

def nroSolicitud = WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/CompletarDatosBasicos'), [('nombreSG') : 'Test QA'
        , ('expEjercicio') : '2016', ('expNumero') : '12382332', ('expTipoReparticion') : 'MGEYA', ('expCodigo') : 'DGTALMMIYT'], 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Solicitud de Gasto: ' + nroSolicitud)

GlobalVariable.nroSG = nroSolicitud

WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/CompletarIndice1InfoBasica'), [('UOC') : GlobalVariable.UOC
        , ('unidadSolicitante') : 'QA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/CompletarIndice2ObraPublica'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/CompletarIndice3TablaVNR'), [('tabla') : 'Tabla test automation'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/CompletarIndice4Autorizadores'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Datos Basicos/btnSiguiente'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/btnEnviarAAutorizar'))

WebUI.verifyTextPresent('La solicitud de gasto fue enviada a autorización.', false)

WebUI.callTestCase(findTestCase('BAO/Genericos/Solicitud de Gasto/BuscarSG'), [('nroSG') : GlobalVariable.nroSG, ('user') : GlobalVariable.userSolicitante
        , ('pass') : GlobalVariable.pass, ('accionSG') : 'Autorizar o rechazar solicitud'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Autorizar/textareaJustificacion'), 'test autorizacion')

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Autorizar/btnAutorizar'))

WebUI.verifyTextPresent('La solicitud de gasto fue autorizada con éxito.', false)

