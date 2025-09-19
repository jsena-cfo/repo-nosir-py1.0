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

/**Carga todos los campos y valida que al presionar el coton Limpiar se limpian todos**/
/**Usa un parametro externo como numero de carpeta**/
/**La carepta debe estar creada previamente para el usuario**/
boolean present = false

String numeroCarpeta

if (reutilizacion) {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerNumeroCarpetaReutilizada'), [('varTipo') : 'intCarSimple'
            , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)
} else {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : usuario
            , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)
}

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

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

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/chk_Visible_documento'), 
    1)

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/chk_Visible_documento'))

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoDocumento'), [('varTipoDocumento') : 'receta'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 'Prueba titulo' + 
    valorRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), 'Prueba Descripcion' + 
    valorRandom)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_LimpiarDocumento2'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/textarea_Observaciones_fileDescription'), 
    '', FailureHandling.CONTINUE_ON_FAILURE)

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 
    '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
present = !(mapBoolean.containsValue(false))

assert present

