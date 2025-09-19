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

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userAutorizador
        , ('pass') : GlobalVariable.pass, ('accion') : 'Aprobar o Rechazar Documentos', ('UE') : GlobalVariable.UOC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicacion/AprobarOrdenDeCompra/input_AutorizarActoAdministrativoClave'), 
    GlobalVariable.pass)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicacion/AprobarOrdenDeCompra/btn_Autorizar'))

try {
    WebUI.click(findTestObject('BAC/Page_BAC - Adjudicacion/AprobarOrdenDeCompra/btn_EnviarDocumentoContractual'))
	
	WebUI.verifyTextPresent('Se ha realizado la autorización y el pase de los documentos correctamente.', false)
}
catch (Exception ex) {
    println(ex)
} 



