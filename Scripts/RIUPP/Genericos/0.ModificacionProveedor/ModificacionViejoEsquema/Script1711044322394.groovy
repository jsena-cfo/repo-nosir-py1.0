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

def ProveedorInscripto = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorInscriptoViejoEsquema'), 
    [('TipoProveedor') : tipoProveedor], FailureHandling.STOP_ON_FAILURE)

def User = ProveedorInscripto[0]

GlobalVariable.razonSocial = (ProveedorInscripto[1])

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : User, ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuAdministrar'))

WebUI.click(findTestObject('BAC/Home/liModificarDatosProveedor'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice2'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice2-InfoBasica/EditarInfoBasica'), [('tipoProveedor') : tipoProveedor
        , ('provincia') : 'Ciudad Autonoma de Bs.As.', ('partido') : 'Ciudad Autónoma de BsAs', ('localidad') : 'Ciudad Autónoma de BsAs'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice3'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice3-PersonasLegales/AgregarPersonasLegales'), [('tipoPersonaLegal') : 'Representante legal'
        , ('esExtranjero') : false, ('esHumano') : false], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice4'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/EditarDocYDDJJ'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEnviarModificacion'))

WebUI.verifyTextPresent('Si confirma la solicitud de trámite será enviada al CAP/ RIUPP para su evaluación en virtud de la documentación de su legajo. Mientras el trámite se encuentre pendiente no podrá ser pre adjudicado ni adjudicado.', 
    false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnConfirmarMod'))

WebUI.verifyTextPresent('Felicitaciones', false)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(20)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionCAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/ReEvaluacionRIUPPViejoEsquema'), [:], FailureHandling.STOP_ON_FAILURE)

def estadoRegistral = WebUI.callTestCase(findTestCase('RIUPP/Genericos/ConsultarEstadoRegistralProveedor'), [('proveedor') : User], 
    FailureHandling.STOP_ON_FAILURE)

assert estadoRegistral == 'Inscripto'

