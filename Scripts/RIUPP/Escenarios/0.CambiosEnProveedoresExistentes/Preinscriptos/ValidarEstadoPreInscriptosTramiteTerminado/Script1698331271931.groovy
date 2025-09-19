import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice5-RubrosLicitatorios/CompletarRubrosLicitatorios'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/ValidarRegistroProveedor'), [('email') : GlobalVariable.emailAdminLeg],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/LoginProveedorNuevo'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.closeBrowser()

EstadoTramite = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramiteRegistro'), [:], FailureHandling.STOP_ON_FAILURE)
String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('****Caso2****\n\nEstado Tramite esperado = Terminado\nEstado Tramite Obtenido=' + EstadoTramite + "\nEstado Proveedor esperado = 'Preinscripto'\nEstado Proveedor Obtenido= " + EstadoProveedor)
assert EstadoTramite == 'Terminado' : 'El estado del tramite no es el esperado'
assert EstadoProveedor == 'PreInscripto': 'El estado del proveedor no es el esperado'
