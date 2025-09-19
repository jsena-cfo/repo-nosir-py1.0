import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userAutorizador
        , ('pass') : GlobalVariable.passAutorizador, ('accionPC') : 'Generar Convenio Marco'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/Convenio Marco/btnSiguientePaso'))

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/IngresarActoAdministrativo'), [('tipoDocumento') : 'Disposición'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/BuscarConvenioMarco'), [('nroPliego') : GlobalVariable.nroPC
        , ('user') : GlobalVariable.userProveedor, ('pass') : GlobalVariable.passProveedor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/RecibirConvenioMarco'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/BuscarConvenioMarco'), [('nroPliego') : GlobalVariable.nroPC
        , ('user') : GlobalVariable.userAutorizador, ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

def solicitudCompra = WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/CompraPorConvenioMarco'), [('autorizador') : 'Emilse Carmen Filippo'], 
    FailureHandling.STOP_ON_FAILURE)

GlobalVariable.nroSC = solicitudCompra

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/BuscarAfectacion'), [('nroSolicitudCompra') : GlobalVariable.nroSC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarCompromisoDefinitivo'), [('pass') : GlobalVariable.passAutorizador], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/BuscarAfectacion'), [('nroSolicitudCompra') : GlobalVariable.nroSC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarComprimisoDefinitivoOGESE'), [('pass') : '12345678'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Analista OGEPU CVM'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Autorizador OGEPU CVM'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/GenerarOrdenDeCompraCVM'), [:], FailureHandling.STOP_ON_FAILURE)

