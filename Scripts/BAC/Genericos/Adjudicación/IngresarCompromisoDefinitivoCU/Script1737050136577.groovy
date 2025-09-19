import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnEditarImputacion'))

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarDetalle'), [('n') : '1', ('monto') : '6'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarDetalle'), [('n') : '2', ('monto') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarDetalle'), [('n') : '3', ('monto') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/IngresarDetalle'), [('n') : '4', ('monto') : '1'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.scrollToElement(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnCerrar'), 5)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnCerrar'))

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnGuardarVolver'))

not_run: def objetoGasto = WebUI.getText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/txtObjectoGasto'))

not_run: WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/selectObjetoGasto'), objetoGasto, 
    false)

not_run: def anioProximo = CustomKeywords.'tool.DateGenerator.nextYear'()

not_run: WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/selectEjercicio'), anioProximo, 
    false)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnBuscarPartida'))

not_run: WebUI.waitForElementClickable(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnBuscarPartidaPresupuestal'), 
    5)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnBuscarPartidaPresupuestal'))

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnSeleccionarPartida'))

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnIngresarImputacion'))

//APARECIO UN BOTON DE ENVIAR INFO PRESUPUESTARIA EN VEZ DE ESTO
not_run: WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpClave'), pass)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnAutorizar'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnGuardarVolver'))

not_run: WebUI.verifyTextPresent('La Solicitud fue Enviada Satisfactoriamente. Se ha notificado al Analista OGESE.', false)

