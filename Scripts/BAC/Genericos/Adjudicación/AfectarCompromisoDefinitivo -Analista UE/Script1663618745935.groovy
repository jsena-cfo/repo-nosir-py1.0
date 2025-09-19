import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPCDesdeHomePage'), [('nroPC') : nroPC, ('user') : GlobalVariable.userAutorizador
//        , ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarAfectacionPC'), [('user') : GlobalVariable.userAnalista
	, ('pass') : GlobalVariable.passAnalista, ('nroPC') : GlobalVariable.nroPC], FailureHandling.STOP_ON_FAILURE)

def tabla = '//table[contains(@id,"CantidadesPorProveedor") and @class="dxgvTable"]/tbody'
def rows = '//tr[contains(@id,"CantidadesPorProveedor") and @class="dxgvDataRow"]'
int cantPorProveedor = CustomKeywords.'tool.utilities.getRowCounts'(tabla, rows)
println ("Cantidad por proveedor encontradas: ${cantPorProveedor}")

def fechaAnioActual = LocalDate.now().format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))
def fechaAnioSiguiente = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))


for (int i = 1;i<= cantPorProveedor; i++) {
	println i
	WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btn_EditarImputacion', [('renglon') : i]))
	
	def montoTotal = WebUI.getText(findTestObject('BAC/Page_BAC - Adjudicación/txtMontoTotal')).replaceAll('\\D+', '')
	
	WebUI.clearText(findTestObject('BAC/Page_BAC - Adjudicación/inp_Monto'))
	
	WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/inp_Monto'), montoTotal)
	
	WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btn_IngresarDetalle'))
	
	WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Agregar nueva imputacin'))
	
	WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/input_FechaImputacin'), fechaAnioActual)
	
	WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/inp_MontoImputacion'), montoTotal)
	
	WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Aceptar'))
	
	WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Guardar y Volver'))
	
}

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Enviar a aprobar presupuesto'))

WebUI.verifyElementClickable(findTestObject('BAC/Page_BAC - Adjudicación/div_Exito'))

