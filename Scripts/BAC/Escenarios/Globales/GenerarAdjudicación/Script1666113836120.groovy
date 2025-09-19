import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AdjudicarProcesoDeCompra'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo -Analista UE'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Analista OGESE'), [('nroPC') : nroPC], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Analista OGEPU'), [('nroPC') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AfectarCompromisoDefinitivo - Autorizador OGEPU'), 
    [('nroPC') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

//Los renglones son la cant de items a adjudicar.
WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/GenerarOrdenDeCompra'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/AprobarORechazarDocumento'), [('nroPC') : nroPC, ('user') : GlobalVariable.userGestor
        , ('pass') : GlobalVariable.passGestor], FailureHandling.STOP_ON_FAILURE)

def tipoCotizacion = GlobalVariable.testSuiteActual

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/RecepcionarConProveedor'), [('user') : GlobalVariable.userProveedor
        , ('pass') : GlobalVariable.passProveedor], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/VerificarEstadoPerfeccionado'), [:], FailureHandling.STOP_ON_FAILURE)

