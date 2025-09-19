import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/0.PreInscripcionProveedores/PreInscripcionCooperativa'), [('tipoProveedor') : 'Cooperativas'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerNroTramiteEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionCAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/EvaluacionRIUPP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.proveedorInscripto, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuAdministrar'))

WebUI.click(findTestObject('BAC/Home/liModificarDatosProveedor'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.ModificacionProveedor/CambiarIndice2'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerUltimoTramiteporRazonSocial'), [:], FailureHandling.STOP_ON_FAILURE)

EstadoTramiteEval('Guardado')

EstadoRegistralProveedor('Inscripto')

/*Se cambia Indice 5*/
WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice5'))

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 5/chkItemParametrizado', [('clase') : '06.06.001']))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 5/btnEliminarClase'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))

/*Se envia la modificació*/
WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEnviarModificacion'))

WebUI.verifyTextPresent('Si confirma la solicitud de trámite será enviada al CAP/ RIUPP para su evaluación en virtud de la documentación de su legajo. Mientras el trámite se encuentre pendiente no podrá ser pre adjudicado ni adjudicado.', 
    false)

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnConfirmarMod'))

WebUI.verifyTextPresent('Felicitaciones', false)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerUltimoTramiteporRazonSocial'), [:], FailureHandling.STOP_ON_FAILURE)

EstadoTramiteEval('Enviado')

EstadoRegistralProveedor('Inscripto')

WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

EstadoRegistralProveedor('Inscripto')

EstadoTramiteEval('En evaluaci?n CAP')

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor' /***Funciones Aux***/ ))

/**Evaluacion CAP**/
WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbIngresoBrutoAprobado'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbConstitucionAprobado'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbOrgPublicoInscriptoAprobado'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/btnSiguiente'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/btnSiguiente'))

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice3/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('Al finalizar la evaluación, se notificará a los usuario con perfil \'Administrador RIUPP\' a fin de que continuen con la evaluación la instancia de Rubros Licitatorios.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/btnAceptarEvaluacion'))

WebUI.verifyTextPresent('La evaluación CAP ha finalizado con éxito.', false)

/**Evaluación RIUPP**/
WebUI.callTestCase(findTestCase('RIUPP/Genericos/AsignarTramite'), [('userEvaluador') : 'Francisco Ciorciari'], FailureHandling.STOP_ON_FAILURE)

EstadoRegistralProveedor('Inscripto')

EstadoTramiteEval('En evaluaci?n RIUPP')

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarCUITMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Evaluar']))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionRIUPP/EvaluarIndice4'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'), 5)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnRechazar'))

WebUI.verifyTextPresent('Al rechazar la evaluación, los datos en el estado registral actual no se veran modificados. El trámite pasará a estado \'Rechazado\' a fin de que el proveedor pueda visualizar las observaciones realizadas en la evaluación para corrección de datos.', 
    false)

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnAceptarRechazo'))

WebUI.verifyTextPresent('Evaluación RIUPP finalizada', false)

EstadoRegistralProveedor('Inscripto')

String EstadoObtenido = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerSubEstado'), [:], FailureHandling.STOP_ON_FAILURE)

assert EstadoObtenido == 'Rechazada'

void EstadoTramiteEval(String estadoEsperado) {
    String EstadoObtenido = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoTramite'), [:], FailureHandling.STOP_ON_FAILURE)

    KeywordUtil.logInfo("Estado esperado: $estadoEsperado")

    KeywordUtil.logInfo("Estado obtenido: $EstadoObtenido")

    assert EstadoObtenido == estadoEsperado
}

void EstadoRegistralProveedor(String estadoEsperado) {
    String EstadoObtenido = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

    KeywordUtil.logInfo("Estado esperado: $estadoEsperado")

    KeywordUtil.logInfo("Estado obtenido: $EstadoObtenido")

    assert EstadoObtenido == estadoEsperado
}

