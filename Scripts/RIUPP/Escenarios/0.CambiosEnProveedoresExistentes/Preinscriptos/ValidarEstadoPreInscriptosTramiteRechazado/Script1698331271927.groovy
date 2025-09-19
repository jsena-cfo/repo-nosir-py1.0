import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionCooperativa'), [('tipoProveedor') : 'Cooperativas'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionCAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionRIUPP/EvaluarIndice4'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'), 5)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'))

WebUI.verifyTextPresent('Al rechazar la evaluación, los datos en el estado registral actual no se veran modificados. El trámite pasará a estado \'Rechazado\' a fin de que el proveedor pueda visualizar las observaciones realizadas en la evaluación para corrección de datos.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnAceptarRechazo'))

WebUI.verifyTextPresent('Evaluación RIUPP finalizada', false)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.proveedorInscripto, ('password') : '12345678'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Información: Se le comunica que tiene un trámite en estado Rechazado. Puede visualizar el trámite desde el ítem de menú "MisTramites"', 
    false)

String EstadoTramiteEval = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoProveedor == 'Rechazado'

assert EstadoTramiteEval == 'Rechazada'

