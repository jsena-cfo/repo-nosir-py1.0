import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.clearText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporte', [('n') : n]))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporte', [('n') : n]), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnIngresarDetalle', [('n') : n]))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnNuevaImputacion'))

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd/MM/yyyy')

LocalDate futureDate = LocalDate.now().plusYears(1)

String fechaFutura = futureDate.format(formatter)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpFechaImputacion'), fechaFutura)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/inpImporteImputacion'), monto)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/Compra Unificada/btnAceptar'))

