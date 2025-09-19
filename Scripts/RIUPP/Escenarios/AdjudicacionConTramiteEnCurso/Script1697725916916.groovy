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

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionSociedadAnonima'), [('tipoProveedor') : 'SociedadAnonima'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionCAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionRIUPP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarSolicitudDeGasto'), [('urgencia') : 'UrgenciaNormal'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Escenarios/Licitación Pública/GenerarPCParcialParcial'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.userProveedor = GlobalVariable.proveedorInscripto

WebUI.callTestCase(findTestCase('BAC/Escenarios/Licitación Pública/GenerarPreAdjParcialParcial'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/IrAModificarDatosProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.ModificacionProveedor/CambiarIndice2'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEnviarModificacion'))

WebUI.verifyTextPresent('Si confirma la solicitud de trámite será enviada al CAP/ RIUPP para su evaluación en virtud de la documentación de su legajo. Mientras el trámite se encuentre pendiente no podrá ser pre adjudicado ni adjudicado.', 
    false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnConfirmarMod'))

WebUI.verifyTextPresent('Felicitaciones', false)

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userAdministrador
        , ('pass') : GlobalVariable.passAdministrador, ('accionPC') : 'Adjudicar Proceso'], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 5)

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 'Observaciones')

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/ddlAnalistasSG_ddlUnidadEjecutora'), '401 - MINISTERIO DE SALUD', 
    false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/select_AnalistaSG'), 'Emilse Carmen Filippo', 
    true)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_AgregarAnalistaSG'))

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Adjudicación/ddlUCAnalistasOGESE_ddlUnidadEjecutora'), '401 - MINISTERIO DE SALUD', 
    true)

WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/select_AnalistaOGESE'), 'Emilse Carmen Filippo', 
    true)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btnAGREGARAnalistasOGESE'))

not_run: WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/select_Supervisor'), 'Emilse Carmen Filippo', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_AgregarSupervisor'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_SolicitarAfectacionDefinitiva'))

WebUI.verifyTextPresent('Proveedor con trámite en curso, pendiente de evaluación CAP/RIUPP', false)

