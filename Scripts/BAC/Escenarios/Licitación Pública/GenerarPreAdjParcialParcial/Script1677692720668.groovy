import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import internal.GlobalVariable as GlobalVariable
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
import org.openqa.selenium.Keys as Keys

/*
CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

def query = "UPDATE [SEAC_CORE_ETAPA2_SADE].[PLI].[PliegoCronograma] SET FechaEstimadaPublicacion = GETDATE() WHERE IdCronograma IN (SELECT pc.IdCronograma FROM [SEAC_CORE_ETAPA2_SADE].[PLI].[PliegoCronograma] pc LEFT JOIN [SEAC_CORE_ETAPA2_SADE].[PLI].[Pliego] p ON  p.IdPliego = pc.IdPliego WHERE p.NumeroPliego = '$GlobalVariable.nroPC');"

CustomKeywords.'tool.sqlServerDB.ejecutarUpdate'(query)

WebUI.delay(60)

*/
WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Acelerador'), [('accion') : 'Publicar', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Proveedor/OfertarParcialParcial'), [('proveedor') : GlobalVariable.userProveedor
        , ('pass') : '12345678', ('cantidad') : '10', ('precio') : '1', ('pliego') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Proveedor/OfertarParcialParcial'), [('proveedor') : GlobalVariable.userProveedor2
        , ('pass') : '12345678', ('cantidad') : '10', ('precio') : '1', ('pliego') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

/*
CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

def query2 = "UPDATE [SEAC_CORE_ETAPA2_SADE].[PLI].[PliegoCronograma] SET FechaActoApertura =  GETDATE() WHERE IdCronograma IN (SELECT pc.IdCronograma FROM [SEAC_CORE_ETAPA2_SADE].[PLI].[PliegoCronograma] pc LEFT JOIN [SEAC_CORE_ETAPA2_SADE].[PLI].[Pliego] p ON  p.IdPliego = pc.IdPliego WHERE p.NumeroPliego = '$GlobalVariable.nroPC');"

CustomKeywords.'tool.sqlServerDB.ejecutarUpdate'(query2)

WebUI.delay(60)
*/
WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a En Apertura', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/RealizarEvaluaciones'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/EvaluarOfertas'), [('cantPrimerOferta') : '10', ('cantSegundaOferta') : '10'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/GenerarDictamenDePreAdjudicacion'), [('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.userEvaluador1
        , ('pass') : GlobalVariable.passEvaluador], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.userEvaluador2
        , ('pass') : GlobalVariable.passEvaluador], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/AutorizarOferta'), [('justificacion') : 'test', ('user') : GlobalVariable.userEvaluador3
        , ('pass') : GlobalVariable.passEvaluador], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Pre Adjudicacion/PublicarDictamen'), [('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a Preadjudicado', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Acelerador'), [('accion') : 'Pasar a Disponible para Adj', ('pliego') : GlobalVariable.nroPC], 
    FailureHandling.STOP_ON_FAILURE)

