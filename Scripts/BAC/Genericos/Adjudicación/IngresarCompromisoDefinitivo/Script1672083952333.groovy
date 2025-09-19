import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnEditarImputacion'))

def objetoGasto = WebUI.getText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/txtObjectoGasto'))

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/selectObjetoGasto'), objetoGasto, false)

def anioProximo = CustomKeywords.'tool.DateGenerator.nextYear'()

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/selectEjercicio'), anioProximo, 
    false)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnBuscarPartida'))

WebUI.waitForElementClickable(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnBuscarPartidaPresupuestal'), 5)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnBuscarPartidaPresupuestal'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnSeleccionarPartida'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpImporte'), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnIngresarPartida'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnIngresarDetalle'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnNuevaImputacion'))

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
LocalDate futureDate = LocalDate.now().plusYears(1)
String fechaFutura = futureDate.format(formatter)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpFechaImputacion'), fechaFutura)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpImporteImputacion'), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnAceptar'))

WebUI.scrollToElement(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnCerrar'), 5)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnCerrar'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnGuardarVolver'))

//APARECIO UN BOTON DE ENVIAR INFO PRESUPUESTARIA EN VEZ DE ESTO
not_run: WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpClave'), pass)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnAutorizar'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/btnEnviarAAprobar'))

WebUI.verifyTextPresent('La Solicitud fue Enviada Satisfactoriamente. Se ha notificado al Analista OGESE Convenio Marco.', 
    false)

