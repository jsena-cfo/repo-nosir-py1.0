import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.unidadEjecutora], 
    FailureHandling.STOP_ON_FAILURE)

def nroSolicitud = WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarDatosBasicosSG'), [('nombreSG') : 'QA Test '
        , ('objetoSG') : 'Prueba automatizada'], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Solicitud: ' + nroSolicitud)

GlobalVariable.nroSG = nroSolicitud

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarInfoBasica'), [('unidadSolicitante') : 'QA', ('urgencia') : 'UrgenciaNormal'
        , ('UOA') : '401 - MINISTERIO DE SALUD'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarItems'), [('codigoItem') : item1, ('acondicionamiento') : 'test'
        , ('cantidad') : '10', ('empaquetamiento') : 'Caja x 12 U', ('cantEmpaquetamiento') : '1', ('precioUnitario') : '1'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarItems'), [('codigoItem') : item2, ('acondicionamiento') : 'test'
        , ('cantidad') : '10', ('empaquetamiento') : 'Caja x 12 U', ('cantEmpaquetamiento') : '1', ('precioUnitario') : '1'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarDetallesEntrega'), [('codigoItem') : item1, ('plazoEntrega') : '15'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarDetallesEntrega'), [('codigoItem') : item2, ('plazoEntrega') : '15'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/btn_Guardar y Volver'))

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/EnviarAlAnalista'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarInfoPresupuestaria'), [('solicitudGasto') : nroSolicitud
        , ('comuna') : 'Comuna 1'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarInfoPresFuturo'), [('solicitudGasto') : nroSolicitud
        , ('comuna') : 'Comuna 1'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/CompletarListaAutorizadores'), [('nombreAutorizador') : 'Emilse Carmen Filippo'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/AutorizarSG'), [('solicitudGasto') : nroSolicitud, ('user') : GlobalVariable.userAutorizador
        , ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

return nroSolicitud

