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

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/RechazarClase'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.proveedorInscripto, ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuAdministrar'))

WebUI.click(findTestObject('BAC/Home/liModificarDatosProveedor'))

String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

/*Se cambia Indice 5*/
WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice5'))

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 5/chkDecJurada'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice5-RubrosLicitatorios/IngresarItemRubroYGrupo'), 
    [('rubro') : 'Muebles', ('grupo') : 'Muebles'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))

WebUI.refresh()

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerUltimoTramiteporRazonSocial'), [:], FailureHandling.STOP_ON_FAILURE)

String EstadoTramiteEval = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoTramiteEval == 'Guardado'

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEnviarModificacion'))

WebUI.verifyTextPresent('Si confirma la solicitud de trámite será enviada al CAP/ RIUPP para su evaluación en virtud de la documentación de su legajo. Mientras el trámite se encuentre pendiente no podrá ser pre adjudicado ni adjudicado.', 
    false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnConfirmarMod'))

WebUI.verifyTextPresent('Felicitaciones', false)

EstadoTramiteEval = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoTramiteEval == 'Enviado'

assert EstadoProveedor == 'Inscripto'

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

EstadoTramiteEval = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoTramiteEval == 'En evaluaci?n RIUPP'

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionRIUPP'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoProveedor == 'Inscripto'

EstadoTramiteEval = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerSubEstado'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoTramiteEval == 'Aprobada'

WebUI.closeBrowser()

