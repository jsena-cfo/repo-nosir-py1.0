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

String mesDesde = getBinding().getAt('varMesDesde').toString()

String anioDesde = getBinding().getAt('varAnioDesde').toString()

String mesHasta = getBinding().getAt('varMesHasta').toString()

String anioHasta = getBinding().getAt('varAnioHasta').toString()

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/p_Consulta de Recibos'), 1)

//WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/input_Fecha Desde'), fechaDesde)
//not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/input_Fecha Hasta'), fechaHasta)
WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_Fecha Desde'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_calendarioAnio', [('anio') : anioDesde]))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_calendarioMes', [('mes') : mesDesde]))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_Fecha Hasta'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_calendarioAnio', [('anio') : anioHasta]))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_calendarioMes', [('mes') : mesHasta]))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickConsultar'), [:], FailureHandling.STOP_ON_FAILURE)

