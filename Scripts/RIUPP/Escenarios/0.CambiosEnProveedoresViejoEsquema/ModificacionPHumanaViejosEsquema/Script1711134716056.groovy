import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

def ProveedorInscripto = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorInscriptoViejoEsquema'), 
    [('TipoProveedor') : tipoProveedor], FailureHandling.STOP_ON_FAILURE)

def User = ProveedorInscripto[0]

GlobalVariable.razonSocial = (ProveedorInscripto[1])

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : User, ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuAdministrar'))

WebUI.click(findTestObject('BAC/Home/liModificarDatosProveedor'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice2'))

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/inputNumero de IIBB'), '12345678')
WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputCorreoElectronico'), GlobalVariable.emailProveedor )

WebUI.click(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/btnSiguiente'))


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

