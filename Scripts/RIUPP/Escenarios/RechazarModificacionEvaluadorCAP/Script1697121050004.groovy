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

not_run: WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionSociedadDeHecho'), 
    [('tipoProveedor') : 'SociedadHecho'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionSociedadAnonima'), [('tipoProveedor') : 'SociedadAnonima'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/EvaluarIndice1'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/EvaluarIndice2'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionCAP/RechazarIndice3'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Al finalizar la evaluación, se notificará a los usuario con perfil \'Administrador RIUPP\' a fin de que continuen con la evaluación la instancia de Rubros Licitatorios.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/btnAceptarEvaluacion'))

WebUI.verifyTextPresent('La evaluación CAP ha finalizado con éxito.', false)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionRIUPP'), [:], FailureHandling.STOP_ON_FAILURE)

def estadoProveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

assert estadoProveedor == 'Aprobado con Observaciones' : 'Estado incorrecto'

WebUI.callTestCase(findTestCase('RIUPP/Genericos/IrAModificarDatosProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.ModificacionProveedor/CambiarIndice3'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Si se ha modificado el indice 3 se debe modificar el indice 4 o viceversa', false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice4'))

def pathArchivo = System.getProperty('user.dir') + '\\test.pdf'

WebUI.uploadFile(findTestObject('RIUPP/Page_BAC - Indice 4/inpFilePyme'), pathArchivo)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/btnSubirPyme'))

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptoDDJJ'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEnviarModificacion'))

WebUI.verifyTextPresent('Si confirma la solicitud de trámite será enviada al CAP/ RIUPP para su evaluación en virtud de la documentación de su legajo. Mientras el trámite se encuentre pendiente no podrá ser pre adjudicado ni adjudicado.', 
    false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnConfirmarMod'))

WebUI.verifyTextPresent('Felicitaciones', false)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/btnSiguiente'))

WebUI.waitForPageLoad(5)

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice2/rbAprobado'))

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice2/btnSiguiente'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/GenerarNroGEDO'), [:], FailureHandling.OPTIONAL)

'Indice 3'
def fechaVencimiento = CustomKeywords.'tool.DateGenerator.addWorkingDays'(GlobalVariable.fechaActual, 20)

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbTamanoEmpresaAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputTamanoEmpresaFecha'), fechaVencimiento)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/GenerarNroGEDO'), [:], FailureHandling.OPTIONAL)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice3/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('Al finalizar la evaluación, se notificará a los usuario con perfil \'Administrador RIUPP\' a fin de que continuen con la evaluación la instancia de Rubros Licitatorios.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/btnAceptarEvaluacion'))

WebUI.verifyTextPresent('La evaluación CAP ha finalizado con éxito.', false)

//EVAL RIUPP
WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnFinalizarEvaluacion'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionRIUPP/EvaluarIndice5'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Evaluación RIUPP finalizada', false)

def estadoRegistral = WebUI.callTestCase(findTestCase('RIUPP/Genericos/ConsultarEstadoRegistralProveedor'), [('proveedor') : GlobalVariable.proveedorInscripto], 
    FailureHandling.STOP_ON_FAILURE)

assert estadoRegistral == 'Inscripto'

