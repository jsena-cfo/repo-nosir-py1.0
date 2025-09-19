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

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.UOC], 
    FailureHandling.STOP_ON_FAILURE)

def nroContratacion = WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarDatosBasicos'), [('nombrePC') : 'QA Test'
        , ('procedimiento') : 'Licitación Pública'], FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Proceso de contratacion: ' + nroContratacion)

GlobalVariable.nroPC = nroContratacion

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarInfoBasicaPC'), [('cantDias') : '20', ('tipoDeDias') : 'Días corridos'
        , ('direccion') : 'Otra dirección', ('procedimiento') : 'Licitación Pública', ('adjCantidad') : 'Total', ('adjRenglones') : 'Total'
        , ('cotizCantidad') : 'Total', ('cotizRenglones') : 'Total', ('tipoEnvio') : 'General', ('tipoRedet') : 'Acepta redeterminación total'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarSG'), [('NumeroSG') : GlobalVariable.nroSG], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarDetalleFinanciero'), [('porcFinanciero') : '20'
        , ('porcMateriales') : '20'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarPliegoBasesYCond'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarRequisitosMinimosPC'), [('RequisitosEconomicoYFinaciero') : 'Test QA'
        , ('RequisitosTecnicos') : 'Test QA', ('RequisitosAdministrativos') : 'Test QA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarGarantias'), [('porcGarantiaImpugnacion') : '1'
        , ('porcPreAdjudicacion') : '1', ('garMantOferta') : 'No', ('garantiaCumplimientoContrato') : 'No', ('contraGarantia') : 'No'
        , ('procedimiento') : 'Licitación Pública', ('porcFondoGarantiasYReparos') : '5'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarIndiceEvaluadoresPC'), [('tipoDoc') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
        , ('anio') : '2015', ('numero') : '3572206', ('reparticion') : 'MGEYA'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarSupervisor'), [('supervisor') : 'Javier Estevez'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarActoAdminAutorizacion'), [('documento') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
        , ('anio') : '2015', ('reparticion') : 'MGEYA', ('numero') : '3572206', ('nroProcesoCompra') : GlobalVariable.nroPC
        , ('user') : GlobalVariable.userAutorizador, ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarCronograma'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/CompletarActoAdminLlamado'), [:], FailureHandling.STOP_ON_FAILURE)

return nroContratacion

