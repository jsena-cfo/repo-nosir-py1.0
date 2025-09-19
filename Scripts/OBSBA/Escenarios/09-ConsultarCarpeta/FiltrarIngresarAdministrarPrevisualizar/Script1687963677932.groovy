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

/**Author: JER**/
/**Script que prueba Ingresar, ver descripcion, administrar y previsualizar carpeta**/
/**Error: Problema scroll horizontal**/
String numCarpetaDoc = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : userVar
        , ('varPass') : passVar], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

String numeroCarpeta = numCarpetaDoc

String nombreArchivo = 'carta_onu.pdf'

boolean validacion = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false]

'Login con usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userVar, ('Contrasena') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : userVar, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

//valida la presencia del boton detalle de carpeta
(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_detalleCarpeta'), 
    1)

WebUI.focus(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_detalleCarpeta'), FailureHandling.OPTIONAL)

not_run: WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_previsualizacionCarpeta'), 
    1)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_previsualizacionCarpeta'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/a_buttonPrevisualizar'), 1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/a_buttonPrevisualizar'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

//valida previsualizacion de boton download documento
(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_downloadDoc'), 
    1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/VolverPagina'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : userVar, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

//valida presencia de boton administrar carpeta
not_run: (mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_a_administrarCarpeta'), 
    1)

(mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/a_buttonAdmnistrarCarpeta'), 
    1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/p_numeroCarpeta'), 1)

String val = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/p_numeroCarpeta'), FailureHandling.STOP_ON_FAILURE)

//String val = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/p_numeroCarpeta'), 'value', FailureHandling.OPTIONAL)
String val2 = CustomKeywords.'tool.StringCK.quitarBlancos'(val)

String val3 = (anio + '-') + numeroCarpeta

System.out.println('Value2: ' + val2)

System.out.println('Value3: ' + val3)

//valida que haya ingresado a la carpeta
(mapBoolean['4']) = (val2 == val3)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolverCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : userVar, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

TestObject firstRowFirstColumn = findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_Acciones_MuiGrid-root')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validacion = !(mapBoolean.containsValue(false))

assert validacion

