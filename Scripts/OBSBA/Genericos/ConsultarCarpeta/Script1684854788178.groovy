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

String year = getBinding().getAt('varAnio').toString()

String numeroCarpeta = getBinding().getAt('varNumeroCarpeta').toString()

String fechaDesde = getBinding().getAt('varFechaDesde').toString()

String fechaHasta = getBinding().getAt('varFechaHasta').toString()

String cuil = getBinding().getAt('varCuil').toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Tipo de carpeta_consulta'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Bien Salud_consulta'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Year_consulta'), year)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Estado de carpeta_consulta'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_En Ingreso_consulta'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_folderNumber_consulta'), numeroCarpeta)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Fecha desde_consulta'), fechaDesde)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Fecha hasta_consulta'), fechaHasta)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITCUIL_consulta'), cuil)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_BuscarConsulta'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickBuscarConsulta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaConsulta'), 2, FailureHandling.STOP_ON_FAILURE)

