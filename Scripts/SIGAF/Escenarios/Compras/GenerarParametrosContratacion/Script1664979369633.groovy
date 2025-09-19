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
import internal.GlobalVariable as GlobalVariable

String numeroLegajo = getBinding().getAt('varNumero').toString()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAltRol'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/RellenarParametrosContratacion'), [('varNumero') : numeroLegajo
        , ('varTipoProcedimiento') : findTestData('comprasParametrosTD').getValue(1, 1), ('varRubro') : findTestData('comprasParametrosTD').getValue(
            2, 1), ('varClase') : findTestData('comprasParametrosTD').getValue(3, 1), ('varModalidad') : findTestData('comprasParametrosTD').getValue(
            4, 1)], FailureHandling.STOP_ON_FAILURE)

String resultadoNumero = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/ObtenerNumeroOCR'), [:], 
    FailureHandling.STOP_ON_FAILURE)

String resultadoEstado = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/ObtenerEstadoOCR'), [:], 
    FailureHandling.STOP_ON_FAILURE)

String numeroContratacion = resultadoNumero.toString().trim()

String estadoObtenido = resultadoEstado.toString().trim()

System.out.println('Numero contratacion obtenido: ' + numeroContratacion)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/VerificarEstado'), [('varEstadoObtenido') : estadoObtenido
        , ('varEstadoIngresado') : 'INGRESADO'], FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/GuardarNumeroParametrosXls'), [('varNumeroLegajo') : numeroLegajo
        , ('varNumeroContratacion') : numeroContratacion], FailureHandling.STOP_ON_FAILURE)

def mapDatos = [('numeroContratacion') : numeroContratacion, ('numeroSolicitud') : numeroLegajo]

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/GuardarDatosXlsUnico'), [('varPathXls') : 'Xls/datosXls.xlsx', ('varHoja') : 'Hoja2PC'
        , ('varDatos') : mapDatos], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

return numeroContratacion

