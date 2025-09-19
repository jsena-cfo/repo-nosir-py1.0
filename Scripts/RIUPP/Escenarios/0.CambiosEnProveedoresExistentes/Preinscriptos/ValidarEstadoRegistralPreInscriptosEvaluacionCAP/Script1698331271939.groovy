import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

String EstadoTramiteEval =WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)
assert EstadoTramiteEval =='En evaluaci?n CAP'
String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)
KeywordUtil.logInfo('Estado Proveedor='+ EstadoProveedor)
KeywordUtil.logInfo('Estado Tramite='+ EstadoTramiteEval)


WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
			, ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/EvaluarIndice1'), [('tipoProveedor') : tipoProveedor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/EvaluarIndice2'), [('tipoProveedor') : tipoProveedor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/EvaluarIndice3'), [('tipoProveedor') : tipoProveedor], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice3/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('Al finalizar la evaluación, se notificará a los usuario con perfil \'Administrador RIUPP\' a fin de que continuen con la evaluación la instancia de Rubros Licitatorios.',
	false)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/btnAceptarEvaluacion'))

WebUI.verifyTextPresent('La evaluación CAP ha finalizado con éxito.', false)


EstadoTramiteEval =WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)
assert EstadoTramiteEval =='En evaluaci?n RIUPP'
EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)
KeywordUtil.logInfo('Estado Tramite Obtenido= ' + EstadoTramiteEval)
KeywordUtil.logInfo('Estado Proveedor Obtenido= ' + EstadoProveedor)