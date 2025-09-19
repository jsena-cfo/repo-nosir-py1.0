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

SnumeroOCA = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerNumeroTMPXLS'), [('varTipo') : 'OCA'
        , ('varUrl') : urlVar], FailureHandling.STOP_ON_FAILURE)

not_run: def numeroOca = '401-0219-OCA25'

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userVar, ('password') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/FiltrarNumeroOca'), [('varNumeroOca') : SnumeroOCA], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/input_SolicitudDeProrroga'), 2)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/input_SolicitudDeProrroga'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/IngresarSolictudProrroga'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ProrrogaIndiceUno'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ProrrogaIndiceDos'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Btn_Enviar a supervisin UOA'), 
    1)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/Btn_Enviar a supervisin UOA'))

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/btn_ConfirmarEnviarUOA'))

WebUI.delay(5)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : 'jestevez', ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Prorroga/BuscarProrroga'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Prorroga/AlcanceYPeriodicidadSPR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/ActualizacionPrecios/Page_BAC - Prorroga/span_iconoIndiceActoAdministrativo'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ProrrogaActoAdministrativo'), [('TipoDocumento') : 'Declaración Jurada Incompatibilidad C. Evaluadora\r\n'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : 'dettano', ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/ddMenu_Buscar'))

WebUI.click(findTestObject('BAC/Home/liBuscarOrdenDeCompraAbierta'))

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/RecibirOCAProrroga'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.closeBrowser()

