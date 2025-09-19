import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPCDesdeHomePage'), [('nroPC') : GlobalVariable.nroPC
//        , ('user') : GlobalVariable.userGestor, ('pass') : GlobalVariable.passGestor], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userGestor
        , ('pass') : GlobalVariable.passGestor, ('accionPC') : 'Adjudicar Proceso'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGenerarDocContractual'))

WebUI.waitForElementPresent(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 15)

WebUI.selectOptionByLabel(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 'Emilse Carmen Filippo', 
    false)

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnAgregarAutorizador'))

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGuardarAutorizador'))

def tabla = '//table[contains(@id,"OrdenesCompra") and @class="dxgvTable"]/tbody'

def rows = '//tr[contains(@id,"OrdenesDeCompra") and @class="dxgvDataRow"]'

int ordenesPorProveedor = CustomKeywords.'tool.utilities.getRowCounts'(tabla, rows)

println("Ordenes de compra por proveedor encontradas: $ordenesPorProveedor")

for (int i = 1; i <= ordenesPorProveedor; i++) {
    WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnAccionesEditar', [('ordenCompra') : i]))

    WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnCompletarDatosEntrega'))
	
	def renglones = DriverFactory.getWebDriver().findElements(By.xpath('//table/tbody/tr[contains(@class,"fila")]')).size()
	
	println renglones

	for (int j = 1; j <= renglones; j++) {
		WebUI.callTestCase(findTestCase('BAC/Genericos/Adjudicación/CompletarDetalleEntrega'), [('renglon') : j], FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGuardarYVolver'))
	
	WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnVolver'))
	
}

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnEnviarAAutorizar'))

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/IngresarActoAdministrativo'), [('tipoDocumento') : 'Disposición'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/Home/span_Proceso de compra'), 30)

if (WebUI.verifyTextPresent('El Acto Administrativo y los Documentos contractuales fueron enviados a Autorizar por la autoridad competente', 
    false)) {
    WebUI.takeScreenshot()
}

