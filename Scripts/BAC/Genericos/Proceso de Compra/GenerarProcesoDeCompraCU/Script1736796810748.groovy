import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.userGestor, ('password') : GlobalVariable.passGestor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : UE], FailureHandling.STOP_ON_FAILURE)

def nroCompra = WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarDatosBasicosPC'), [('nombrePC') : 'QA Test '
        , ('procedimiento') : procedimiento, ('modalidad') : modalidad], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Proceso de compra: ' + nroCompra)

GlobalVariable.nroPC = nroCompra

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarInfoBasicaPC'), [('procedimiento') : procedimiento
        , ('modalidad') : modalidad, ('etapa') : etapa, ('adjCantidad') : adjCantidad, ('adjRenglones') : adjRenglones, ('cotizCantidad') : cotizCantidad
        , ('cotizRenglones') : cotizRenglones, ('redeterminacion') : redeterminacion, ('prorroga') : prorroga, ('actualizacionPrecios') : actualizacionPrecios], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarSGCompraUnificada'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarRequisitosMinimosPC'), [('RequisitosEconomicoYFinaciero') : 'Test QA'
        , ('RequisitosTecnicos') : 'Test QA', ('RequisitosAdministrativos') : 'Test QA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarClausulasPC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarGarantias'), [('porcGarantiaImpugnacion') : '1'
        , ('porcPreAdjudicacion') : '4', ('garMantOferta') : 'No', ('garantiaCumplimientoContrato') : 'No', ('contraGarantia') : 'No'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarIndiceEvaluadoresPC'), [('tipoDoc') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
        , ('anio') : '2018', ('numero') : '00248635', ('reparticion') : 'MGEYA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/MontoyDuracionContratoPC'), [('semanal') : 'Semanal', ('duracion') : '12'
        , ('tiempo') : 'Meses'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarSustentabilidad'), [('requisitoSustentabilidad') : 'No'
        , ('tipoRecomendaciones') : 'Ambientales', ('logisticaInversaOMinima') : 'No', ('embalajeReciclable') : 'No'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/EnviarASupervisor'), [('nombreSupervisor') : 'Emilse Carmen Filippo'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminAutorizacion'), [('documento') : 'Disposición'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688', ('nroProcesoCompra') : nroCompra, ('user') : GlobalVariable.userAutorizador
        , ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminLlamado'), [:], FailureHandling.STOP_ON_FAILURE)

return nroCompra

