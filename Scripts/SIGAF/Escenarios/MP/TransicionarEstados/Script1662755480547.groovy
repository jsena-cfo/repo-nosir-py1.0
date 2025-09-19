import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'().toString()

String numeroObtenidoOcr = WebUI.callTestCase(findTestCase('SIGAF/Escenarios/MP/GenerarIngresoDeMPParametrizado'), [('usuario') : usuarioVar, ('password') : passwordVar], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/TransicionarFlujoPendienteFisica'), [('varUsuario') : usuarioVar, ('varPassword') : passwordVar
        , ('varRol') : 'ejecucion', ('varNumero') : numeroObtenidoOcr, ('varEjercicio') : anioActual], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/TransicionarFlujoPendiente'), [('varUsuario') : usuarioVar, ('varPassword') : passwordVar
        , ('varRol') : 'ejecucion', ('varNumero') : numeroObtenidoOcr, ('varEjercicio') : anioActual], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/TransicionarFlujoAprobado'), [('varUsuario') : usuarioVar, ('varPassword') : passwordVar
        , ('varRol') : 'ejecucion', ('varNumero') : numeroObtenidoOcr, ('varEjercicio') : anioActual], FailureHandling.STOP_ON_FAILURE)


