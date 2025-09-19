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
import org.openqa.selenium.Keys as Keys

String varUsuario = getBinding().getAt('varUsuario').toString()

String varPassword = getBinding().getAt('varPassword').toString()

String varNumeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

String varNumeroActa = getBinding().getAt('varNumeroActa').toString()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAltRol'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/IngresarMenuCompras'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/IngresarMenuEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/IngresarDictamenEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/IngresarIngresoDictamenEvaluacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/SeleccionarActaDictamen'), [('varNumeroContratacion') : varNumeroContratacion
        , ('varNumeroActa') : varNumeroActa], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GuardarDictamen'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GenerarOrdenDeMerito'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/RealizarIngresoCompletoDictamen'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/AutorizarActaInterna'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/AutorizarAutCompras'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/AutorizarFuncionario'), [:], FailureHandling.STOP_ON_FAILURE)

String estadoOCR = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '471', ('varY') : '162'
        , ('varW') : '197', ('varH') : '13'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/VerificarEstados'), [('varEstadoObtenido') : estadoOCR.trim(), ('varEstadoIngresado') : 'AUTORIZADO'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '471', ('varY') : '162', ('varW') : '197'
        , ('varH') : '13'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/PresionarTab'), [:], FailureHandling.STOP_ON_FAILURE)

String numeroDictamen = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '328'
        , ('varY') : '162', ('varW') : '51', ('varH') : '15'], FailureHandling.STOP_ON_FAILURE)

String numeroDictamenNormalizado = numeroDictamen.trim()

System.out.println('Numero de dictamen: ' + numeroDictamenNormalizado)

def mapDatos = [('numeroActa') : varNumeroActa, ('numeroContratacion') : varNumeroContratacion, ('numeroDictamen') : numeroDictamenNormalizado]

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/GuardarDatosXlsUnico'), [('varPathXls') : 'Xls/datosXls.xlsx', ('varHoja') : 'Hoja4DE'
        , ('varDatos') : mapDatos], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GenerarImpugnaciones'), [('varNumeroDictamen') : numeroDictamenNormalizado], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

