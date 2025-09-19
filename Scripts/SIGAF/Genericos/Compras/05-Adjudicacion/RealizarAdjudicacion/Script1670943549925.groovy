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

String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPassword').toString()

String numeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAltRol'), [('varUsuario') : usuario, ('varPassword') : password
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/DesplazarseMenu'), [('varOpcion') : 'adjudicacion'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/SeleccionarHabilitados'), [('varNumeroContratacion') : numeroContratacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/GuardarAdjudicacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/IngresoCompleto'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/Autorizar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/CompletarFormC35Asoc'), [:], FailureHandling.STOP_ON_FAILURE)

String numeroFormC35 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '210'
        , ('varY') : '264', ('varW') : '111', ('varH') : '15'], FailureHandling.STOP_ON_FAILURE)

String numeroFormC35SinSimbolos= numeroFormC35.replaceAll('£', ' ')

String numeroFormC35Norm = numeroFormC35SinSimbolos.toString().trim()

System.out.println('Numero de formC35: ' + numeroFormC35Norm)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/CompletarProyOC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/05-Adjudicacion/IngresarSolicitudGasto'), [:], FailureHandling.STOP_ON_FAILURE)

def mapDatos = [('numeroContratacion') : numeroContratacion, ('numeroFormC35') : numeroFormC35Norm]

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/GuardarDatosXlsUnico'), [('varPathXls') : 'Xls/datosXls.xlsx', ('varHoja') : 'Hoja5FC35'
        , ('varDatos') : mapDatos], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

