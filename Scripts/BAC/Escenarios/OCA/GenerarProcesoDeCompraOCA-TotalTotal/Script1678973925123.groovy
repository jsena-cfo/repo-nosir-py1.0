import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : UE], FailureHandling.STOP_ON_FAILURE)

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

/*
def codigosDeItem = ['33.09.003.0010.1', '33.09.003.0018.3', '33.09.003.0000.44', '33.09.003.0001.1', '33.09.003.0002.1'
    , '33.09.003.0002.2', '33.09.003.0003.1', '33.09.003.0003.2', '33.09.003.0005.1', '33.09.003.0006.1', '33.09.003.0007.1'
    , '33.09.003.0007.2', '33.09.003.0008.1', '33.09.003.0009.1', '33.09.003.0010.10', '33.09.003.0010.11', '33.09.003.0010.12'
    , '33.09.003.0010.2', '33.09.003.0010.3', '33.09.003.0010.4', '33.09.003.0010.5', '33.09.003.0010.6', '33.09.003.0010.7'
    , '33.09.003.0010.8', '33.09.003.0011.1', '33.09.003.0012.1', '33.09.003.0012.10', '33.09.003.0012.11', '33.09.003.0012.12'
    , '33.09.003.0012.13', '33.09.003.0012.14', '33.09.003.0012.2', '33.09.003.0012.3', '33.09.003.0012.4', '33.09.003.0012.5'
    , '33.09.003.0012.6', '33.09.003.0012.7', '33.09.003.0012.8', '33.09.003.0012.9', '33.09.003.0013.1', '33.09.003.0013.2'
    , '33.09.003.0013.3', '33.09.003.0013.4', '33.09.003.0013.5', '33.09.003.0014.1', '33.09.003.0014.2', '33.09.003.0014.3'
    , '33.09.003.0014.4']

for (def codigo : codigosDeItem) {
    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/DetalleDeProductosOServicios'), [('codigoDeItem') : codigo
            , ('embalaje') : '15', ('cantidad') : '10'], FailureHandling.STOP_ON_FAILURE)
}
*/
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

