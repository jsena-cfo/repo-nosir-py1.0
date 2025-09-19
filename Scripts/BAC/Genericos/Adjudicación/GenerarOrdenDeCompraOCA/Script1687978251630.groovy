import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPCDesdeHomePage'), [('nroPC') : GlobalVariable.nroPC
//        , ('user') : GlobalVariable.userGestor, ('pass') : GlobalVariable.passGestor], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userGestor
        , ('pass') : GlobalVariable.passGestor, ('accionPC') : 'Adjudicar Proceso'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btnGenerarOCA'))

WebUI.waitForElementPresent(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 15)

WebUI.selectOptionByLabel(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 'Emilse Carmen Filippo', 
    false)

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnAgregarAutorizador'))

def nroOrdenCompra = WebUI.getText(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/txtNumeroOrdenCompra'))

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGuardarAutorizador'))

def tabla = '//table[contains(@id,"OrdenesCompra") and @class="dxgvTable"]/tbody'

def rows = '//tr[contains(@id,"OrdenesDeCompra") and @class="dxgvDataRow"]'

int ordenesPorProveedor = CustomKeywords.'tool.utilities.getRowCounts'(tabla, rows)

println("Ordenes de compra por proveedor encontradas: $ordenesPorProveedor")

for (int i = 1; i <= ordenesPorProveedor; i++) {
    WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnAccionesEditar', [('ordenCompra') : i]))

    WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/btnCompletarDatosPeriodicidad'))

    WebUI.check(findTestObject('BAC/Page_BAC - Adjudicación/chkInmediato'))

    WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGuardarVolver'))

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

return nroOrdenCompra