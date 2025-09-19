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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/**Author: JER**/
/**Script que descarga un documento**/
/**Verifica boton Previsualizar, la imagen de doc previsualizado, el icono de carga y**/
/**la descarga de documento**/
/**Usa un parametro externo como numero de carpeta**/
/**La carepta debe estar creada previamente para el usuario**/
/**La carpeta debe contener el doc indicado en nameFile**/
String ext = '.pdf'

String nameFile = 'carta_onu'

boolean cargoPrevisualizacion = false

boolean validar = false

String numeroCarpeta

String anio

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false]

anio = CustomKeywords.'tool.DateGenerator.currentYear'()

numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : usuario, ('varPass') : pass], 
    FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero carpeta generada: ' + numeroCarpeta)

'Login con usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

'Verifica boton Previsualizar'
not_run: cargoPrevisualizacion = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/a_previsualizacion'), 
    2, FailureHandling.OPTIONAL)

not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/a_MESA DE ENTRADAS CENTRAL'), 
    1)

'Verifica boton Previsualizar'
not_run: (mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/a_MESA DE ENTRADAS CENTRAL'), 
    1, FailureHandling.OPTIONAL)

not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_previsualizacionCarpeta'), 
    1)

'Verifica boton Previsualizar'
not_run: (mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_previsualizacionCarpeta'), 
    1, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/a_buttonPrevisualizar'), 
    1)

'Verifica boton Previsualizar'
(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/a_buttonPrevisualizar'), 
    1, FailureHandling.OPTIONAL)

if ((mapBoolean['1']) == false) {
    KeywordUtil.markFailedAndStop((('No se cargo la funcion de previsualizacion, puede que no se haya encontrado carpeta: ' + 
        numeroCarpeta) + ' para usuario: ') + usuario)
}

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/a_previsualizacion'))

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/a_MESA DE ENTRADAS CENTRAL'))

'Verifica boton Previsualizar'
WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_previsualizacionCarpeta'))

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/span_docCargado'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/span_docCargado'), 1)

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/span_docCargado'), nameFile + 
    ext)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/span_verImagenPrevisualizacion'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

'Verifica imagen de doc previsualizado'
(mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/canvas_imagenPrevisualizacionPageCanvas'), 
    2)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickDescargar'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_DescargarDocumento/svg_simboloEspera'), 2, FailureHandling.OPTIONAL)
'Valida icono de carga'
(mapBoolean['4']) = true

WebUI.callTestCase(findTestCase('OBSBA/Genericos/VolverPagina'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String home = System.getProperty('user.home')

String userDownloads = new File(home + '/Downloads/')

'Valida descarga de documento'
(mapBoolean['5']) = CustomKeywords.'tool.DownloadFile.isFileDownloaded'(userDownloads, nameFile + ext)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
validar = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

if (validar) {
	System.out.println('Prueba OK')
    assert validar
} else {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirMarkFailed'), [('varTexto') : 'Error prueba'], FailureHandling.STOP_ON_FAILURE)
}

