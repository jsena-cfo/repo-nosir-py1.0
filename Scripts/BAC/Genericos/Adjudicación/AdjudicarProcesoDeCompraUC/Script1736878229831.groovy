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

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPCDesdeHomePage'), [('nroPC') : nroPC, ('user') : GlobalVariable.userAdministrador
//        , ('pass') : GlobalVariable.passAdministrador], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : nroPC, ('user') : GlobalVariable.userAdministrador
        , ('pass') : GlobalVariable.passAdministrador, ('accionPC') : 'Adjudicar Proceso'], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 5)

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 'Observaciones')

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/selectUEAnalistaOGESE'), '401 - MINISTERIO DE SALUD', 
    false)

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/select_AnalistaOGESE'), 'Emilse Carmen Filippo', true)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btnAGREGARAnalistasOGESE'))

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/DistribuirCantidades'), [:], FailureHandling.STOP_ON_FAILURE)

try {
    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/selectUEAnalistaOGESE'), '401 - MINISTERIO DE SALUD', 
        false)

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/select_AnalistaOGESE'), 'Emilse Carmen Filippo', 
        true)

    WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btnAGREGARAnalistasOGESE'))
}
catch (Exception ex) {
    println(ex)
} 

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_SolicitarAfectacionDefinitiva'))

WebUI.delay(100)

WebUI.verifyElementClickable(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/span_SolicitudEnviadaExitosamente'))

