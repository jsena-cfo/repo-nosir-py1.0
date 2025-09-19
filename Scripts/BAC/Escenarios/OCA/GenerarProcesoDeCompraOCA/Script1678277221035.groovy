import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : UE], 
    FailureHandling.STOP_ON_FAILURE)

def nroCompra = WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarDatosBasicosPC-OCA'), [('nombrePC') : 'QA Test'], 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Proceso de compra: ' + nroCompra)

GlobalVariable.nroPC = nroCompra

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarInfoBasicaPC'), [('procedimiento') : procedimiento
        , ('modalidad') : modalidad, ('etapa') : etapa, ('adjCantidad') : adjCantidad, ('adjRenglones') : adjRenglones, ('cotizCantidad') : cotizCantidad
        , ('cotizRenglones') : cotizRenglones, ('redeterminacion') : redeterminacion, ('prorroga') : prorroga, ('actualizacionPrecios') : actualizacionPrecios], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/DetalleDeProductosOServicios'), [('codigoDeItem') : GlobalVariable.item1
        , ('embalaje') : '15', ('cantidad') : '10'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/DetalleDeProductosOServicios'), [('codigoDeItem') : GlobalVariable.item2
        , ('embalaje') : '15', ('cantidad') : '10'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarRequisitosMinimosPC'), [('RequisitosEconomicoYFinaciero') : 'Test QA'
        , ('RequisitosTecnicos') : 'Test QA', ('RequisitosAdministrativos') : 'Test QA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarClausulasPC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarGarantias'), [('porcGarantiaImpugnacion') : '1'
        , ('porcPreAdjudicacion') : '4', ('garMantOferta') : 'No', ('garantiaCumplimientoContrato') : 'No', ('contraGarantia') : 'No'
        , ('procedimiento') : 'Licitación Pública'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/MontoyDuracionDeContratoPC-OCA'), [('monto') : '12', ('duracion') : '12'
        , ('tiempo') : 'Meses'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarIndiceEvaluadoresPC'), [('tipoDoc') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
        , ('anio') : '2018', ('numero') : '00248635', ('reparticion') : 'MGEYA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/AlcanceYPeriocidadSPR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarSustentabilidad'), [('requisitoSustentabilidad') : 'No'
        , ('tipoRecomendaciones') : 'Ambientales', ('logisticaInversaOMinima') : 'No', ('embalajeReciclable') : 'No'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/EnviarASupervisor'), [('nombreSupervisor') : 'Emilse Carmen Filippo'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminAutorizacion'), [('documento') : 'Disposición'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688', ('nroProcesoCompra') : nroCompra, ('user') : GlobalVariable.userAutorizador
        , ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminLlamado'), [:], FailureHandling.STOP_ON_FAILURE)

return nroCompra

