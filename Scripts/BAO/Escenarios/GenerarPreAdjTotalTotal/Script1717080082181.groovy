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

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Acelerador'), [('accion') : 'Publicar', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/Ofertar'), [('proveedor') : GlobalVariable.userProveedor, ('pass') : GlobalVariable.pass
        , ('cantidad') : '', ('precio') : '337004.04', ('pliego') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/Ofertar'), [('proveedor') : GlobalVariable.userProveedor2, ('pass') : GlobalVariable.pass
        , ('cantidad') : '', ('precio') : '337004.04', ('pliego') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a En Apertura', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/RealizarEvaluaciones'), [('nroPC') : GlobalVariable.nroPC
        , ('procedimiento') : 'Licitación Pública'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/EvaluarOfertasTotalTotal'), [('cantPrimerOferta') : '6', ('cantSegundaOferta') : '4'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/GenerarDictamenDePreAdj'), [('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.evaluador1
        , ('pass') : GlobalVariable.pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.evaluador2
        , ('pass') : GlobalVariable.pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.evaluador3
        , ('pass') : GlobalVariable.pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Pre Adjudicacion/PublicarDictamen'), [('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a Preadjudicado', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a Disponible para Adj', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

