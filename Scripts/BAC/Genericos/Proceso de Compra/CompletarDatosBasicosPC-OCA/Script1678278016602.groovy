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
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAC/Home/menuCrear'))

WebUI.click(findTestObject('BAC/Home/li_CrearPC'))

def popUpEstaPresente = WebUI.waitForElementVisible(findTestObject('BAC/Home/popup_Advertencia'), 10)

if (popUpEstaPresente) {
    WebUI.click(findTestObject('BAC/Home/popup_Advertencia'))
}

def fechaActual = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/inp_NombreProcesodeCompra'), 
    nombrePC + fechaActual)

WebUI.check(findTestObject('BAC/OCA/Page_BAC - CompletarDatosBasicosOCA/check_ProcedimientoDelSeleccionOCA'))

WebUI.check(findTestObject('BAC/OCA/Page_BAC - CompletarDatosBasicosOCA/check_TipoDeModalidadOCA'))

WebUI.click(findTestObject('BAC/OCA/Page_BAC - CompletarDatosBasicosOCA/option_EncuadreLegalOCA'))

WebUI.click(findTestObject('BAC/OCA/Page_BAC - CompletarDatosBasicosOCA/input_EncuadresLegalesSeleccionadosOCA'))

WebUI.click(findTestObject('BAC/OCA/Page_BAC - CompletarDatosBasicosOCA/btn_SiguientePasoOCA'))

def numeroPC = WebUI.getText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/spanNroProcesoCompra'),
	FailureHandling.STOP_ON_FAILURE)

return numeroPC