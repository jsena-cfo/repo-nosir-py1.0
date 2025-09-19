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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionCooperativa'), [('tipoProveedor') : 'Cooperativas'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionCAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)


String EstadoTramiteEval =WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)
assert EstadoTramiteEval =='En evaluaci?n RIUPP'

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionRIUPP/EvaluarIndice4'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'), 5)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'))

WebUI.verifyTextPresent('Al rechazar la evaluación, los datos en el estado registral actual no se veran modificados. El trámite pasará a estado \'Rechazado\' a fin de que el proveedor pueda visualizar las observaciones realizadas en la evaluación para corrección de datos.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnAceptarRechazo'))

WebUI.verifyTextPresent('Evaluación RIUPP finalizada', false)


EstadoTramiteEval =WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerSubEstado'), [:], FailureHandling.STOP_ON_FAILURE)
String EstadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)
assert EstadoTramiteEval =='Rechazada'
assert EstadoProveedor =='PreInscripto'

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.proveedorInscripto, ('password') : '12345678'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Información: Se le comunica que tiene un trámite en estado Rechazado. Puede visualizar el trámite desde el ítem de menú "MisTramites"', 
    false)

