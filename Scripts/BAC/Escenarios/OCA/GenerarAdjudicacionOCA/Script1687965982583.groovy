import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AdjudicarProcesoDeCompraOCA'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Analista OGEPU OCA'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Autorizador OGEPU OCA'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

def nroOrdenCompra = WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/GenerarOrdenDeCompraOCA'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AprobarORechazarDocumento'), [('nroPC') : GlobalVariable.nroPC
        , ('user') : GlobalVariable.userGestor, ('pass') : GlobalVariable.passGestor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/OCA/RecepcionarConProveedorOCA'), [('nroOCA') : nroOrdenCompra], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/VerificarEstadoPerfeccionado'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo((('Proceso de compra: ' + GlobalVariable.nroPC) + '\n Orden de compra: ') + nroOrdenCompra)

'Guarda el numero de oca en el xls temporario'
WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/RegistroTmpGuardarSPR'), [('varTipo') : 'OCA', ('varNumero') : nroOrdenCompra.toString()
        , ('varUrl') : GlobalVariable.url_BAC], FailureHandling.STOP_ON_FAILURE)

return nroOrdenCompra

