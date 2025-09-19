import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAlt'), [('varUsuario') : usuario, ('varPassword') : password
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/NavegarAIngresoYMP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/CompletarCamposRequerimientoMP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/CompletarCredito'), [:], FailureHandling.STOP_ON_FAILURE)

String nroReq = WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/ObtenerTextoPorRegion'), [('x') : 302, ('y') : 156, ('w') : 33
        , ('h') : 12], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

return nroReq
