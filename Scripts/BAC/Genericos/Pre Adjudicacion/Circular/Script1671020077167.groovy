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
        , ('pass') : GlobalVariable.passAutorizador, ('accionPC') : 'Ingresar Circular'], FailureHandling.STOP_ON_FAILURE)

WebUI.check(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/radio_SinConsultaTipoCircular'))

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/input_Descripcion'), textoDescripcion)

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/option_EmilseCarmenFilippo'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/btn_Seleccionar'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/btn_SiguientePaso'))

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/input_DescripcionAclaratoria'), textoAclaratoria)

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Page_BAC - Circular Convenio Marco/btn_EnviaraAutorizar'))

