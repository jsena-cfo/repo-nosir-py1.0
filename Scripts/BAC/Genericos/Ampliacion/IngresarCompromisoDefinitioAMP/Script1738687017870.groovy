import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/BuscarAfectacion'), [('nroSolicitudCompra') : nroAmpliacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnEditarImputacion'))

def objetoGasto = WebUI.getText(findTestObject('BAC/Ampliacion/txtObjectoGasto'))

WebUI.selectOptionByLabel(findTestObject('BAC/Ampliacion/selectObjetoGasto'), objetoGasto, false)

def anioProximo = CustomKeywords.'tool.DateGenerator.nextYear'()

WebUI.selectOptionByLabel(findTestObject('BAC/Ampliacion/selectEjercicio'), anioProximo, false)

WebUI.click(findTestObject('BAC/Ampliacion/btnBuscarPartida'))

WebUI.click(findTestObject('BAC/Ampliacion/btnSeleccionarPartida'))

WebUI.click(findTestObject('BAC/Ampliacion/btnIngresarImputacion'))

WebUI.clearText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporte', [('n') : '1']))

def monto = WebUI.getText(findTestObject('BAC/Ampliacion/txtSaldoImputar'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporte', [('n') : '1']), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnIngresarDetalle', [('n') : '1']))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnNuevaImputacion'))

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd/MM/yyyy')

LocalDate futureDate = LocalDate.now().plusYears(1)

String fechaFutura = futureDate.format(formatter)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpFechaImputacion'), fechaFutura)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporteImputacion'), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnAceptar'))

WebUI.click(findTestObject('BAC/Ampliacion/btnGuardarYVolver'))

WebUI.click(findTestObject('BAC/Ampliacion/btnEnviarAAprobarPresupuesto'))

WebUI.verifyTextPresent('La Solicitud fue Enviada Satisfactoriamente. Se ha notificado al Analista OGESE.', false)

