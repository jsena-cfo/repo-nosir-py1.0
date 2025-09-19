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

/**Valida la existencia del campo titulo**/
/**Usa un parametro externo como numero de carpeta**/
/**La carepta debe estar creada previamente para el usuario**/
boolean existeTitulo = false

String numeroCarpeta

not_run: numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : usuario
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

if (reutilizacion) {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerNumeroCarpetaReutilizada'), [('varTipo') : 'intCarSimple'
            , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)
} else {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : usuario
            , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)
}

'Se loguea como usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 'Prueba titulo' + 
    valorRandom)

//def ExisteTitulo = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 
//    2)
existeTitulo = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 
    1, FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert existeTitulo

