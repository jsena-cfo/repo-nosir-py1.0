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

boolean modificado = false

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuOCA'), [('varOpcion') : 'AdministrarSolicitudes'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickNueva'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuNueva'), [('varOpcion') : 'Srd'], FailureHandling.STOP_ON_FAILURE)

String numOCASRD = WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ObtenerNumOCASRD'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EscribirLogStr'), [('varStr') : 'Numero OCA: ' + numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroOCA'), [('varNumOCA') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('SIGAF-WEB/Page_sigaf-redet-alta/button_Guardar'), 1)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickEditar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '100%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ModificarPorcentaje'), [('varPorcentaje') : '1'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ModificarFechasCalendarPlugin'), [('varFecha1') : '01/02/2025'
        , ('varFecha2') : '10/02/2025'], FailureHandling.STOP_ON_FAILURE)

'Usa el valor ingresado para ir x meses hacia atras en el tiempo para poder reutilizar la misma \r\nsolicitud luego de crearla y descartarla. La siguiente vez que se usa hay que modificar el valor \r\npor x-1 '
WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ModificarFechasCalendarUltimosDias'), [('varMesesAtras') : '15'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarDelegadoActuado'), [('varDelegacion') : 'AUTOMOVIL CLUB ARGENTINO'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarDelegadoUsuario'), [('varDelegacion') : 'AUTOMOVIL CLUB ARGENTINO'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroEjercicio'), [('varNumero') : '2051', ('varEjercicio') : '2024'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('SIGAF-WEB/Page_sigaf-redet-alta/button_Guardar'), 2)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickConfirmar'), [:], FailureHandling.STOP_ON_FAILURE)

modificado = WebUI.verifyElementPresent(findTestObject('SIGAF-WEB/Page_sigaf-redet-alta/div_Registro guardado'), 2)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert modificado

