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

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/DesplazarseMenu'), [('varOpcion') : 'ordenCompra'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/SeleccionarOrdenCompra'), [('varNumeroContratacion') : numeroContratacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/GuardarOC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/RealizarIngresoCompleto'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/06-OrdenCompra/RealizarAutorizacion'), [:], FailureHandling.STOP_ON_FAILURE)

String estadoOCR = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '619', ('varY') : '154'
        , ('varW') : '128', ('varH') : '14'], FailureHandling.STOP_ON_FAILURE)

String estadoOCRNormalizado = estadoOCR.trim().toString()

System.out.println('Estado OCR: ' + estadoOCRNormalizado)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/VerificarEstados'), [('varEstadoObtenido') : estadoOCRNormalizado
        , ('varEstadoIngresado') : 'AUTORIZADO'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

