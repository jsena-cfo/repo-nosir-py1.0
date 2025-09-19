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

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/AdjudicarPC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/AfectarCompromisoDefinitivo - Analista OGESE'), [('nroPC') : GlobalVariable.nroPC
        , ('monto') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/CompletarPlanilla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/ModificarPlanilla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/ModificarPlanillaTotalTotal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/AutorizarPlanilla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/GenerarDocContractual'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/AprobarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/RecepcionarConProveedor'), [('user') : 'dettano', ('pass') : '12345678'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/IngresarFechaInicioContrato'), [:], FailureHandling.STOP_ON_FAILURE)

