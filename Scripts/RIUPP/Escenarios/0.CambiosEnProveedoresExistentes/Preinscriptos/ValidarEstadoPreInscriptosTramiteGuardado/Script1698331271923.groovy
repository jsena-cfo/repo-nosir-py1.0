import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//Completar los indices y verificar el estado el trámite antes de confirmar
WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice1-Preinscripcion/InscripcionProveedorNacional'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice1-Preinscripcion/CompletarDatosProvNacional'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

println(GlobalVariable.nroTramite.toString())

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice2-InfoBasica/CompletarInfoBasica'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice3-PersonasLegales/CompletarPersonasLegales'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/CompletarDocYDDJJ'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

String EstadoTramite = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramiteRegistro'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('****Caso1****\nEstado Tramite=' + EstadoTramite)

assert EstadoTramite == 'Guardado' : 'El estado del tramite no es el esperado'
String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)
println (EstadoProveedor)

