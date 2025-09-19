import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
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

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : GlobalVariable.userSupervisor, ('password') : GlobalVariable.pass], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.UOC], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/ddMenu_Buscar'))

WebUI.click(findTestObject('BAO/Home/liOpcionMenu', [('opcion') : 'Buscar Proceso']))

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page BAC - Busqueda PC/inpNroCompra'), 
    GlobalVariable.nroPC)

WebUI.click(findTestObject('BAO/Proceso de Contratacion/Busqueda Proceso/btnBuscarPC'))

WebUI.refresh()

try {
    WebUI.click(findTestObject('BAO/Proceso de Contratacion/Busqueda Proceso/btnEditar', [('accion') : 'Autorizar Planilla']))
	
	WebUI.click(findTestObject('BAO/Adjudicacion/btnVolver'))
	
	WebUI.delay(60)
	
	WebUI.refresh()

	WebUI.click(findTestObject('BAO/Proceso de Contratacion/Busqueda Proceso/btnEditar', [('accion') : 'Generar Documentos Contractuales']))
}
catch (Exception ex) {
    WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/BuscarPC'), [('nroPC') : GlobalVariable.nroPC
            , ('user') : GlobalVariable.userSupervisor, ('pass') : GlobalVariable.pass, ('accion') : 'Generar Documentos Contractuales'
            , ('UE') : GlobalVariable.UOC], FailureHandling.STOP_ON_FAILURE)
} 

WebUI.click(findTestObject('BAO/Adjudicacion/btnGenerarDocContractual'))

WebUI.waitForElementPresent(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 15)

WebUI.selectOptionByLabel(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/selectAutorizador'), 'Javier Estevez', 
    false)

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnAgregarAutorizador'))

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnGuardarAutorizador'))

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/CompletarDatosContrato'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Adjudicacion/Page_BAC - Generar Orden Compra/btnEnviarAAutorizar'))

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/IngresarActoAdministrativo'), [('tipoDocumento') : 'Informe'
        , ('anio') : '2015', ('reparticion') : 'MGEYA', ('numero') : '3572206'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('El Acto Administrativo y las Documentos contractuales fueron enviados a Autorizar por la autoridad competente.', 
    false)



