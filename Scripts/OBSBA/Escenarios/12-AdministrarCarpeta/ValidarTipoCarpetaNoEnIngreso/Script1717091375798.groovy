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

/**Author: Jer**/
/**Si el Estado es diferente a 'En ingreso' no es posible modificar
 * los campos: Tipo de carpeta, estado, contiene pago, contiene amparo,
 *  titulo y observaciones**/
String numeroCarpeta

boolean validar = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false]

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

'crea carpeta como prestador'
numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : usuario, ('varPass') : pass], 
    FailureHandling.STOP_ON_FAILURE)

'Envia la carpeta'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

enviado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

'Se loguea con un el usuario prestador que puede acceder a la carpeta'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdministrarCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/label_Administrar Carpeta'), 1)

(mapBoolean['1']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Tipo de carpeta-n'), 
    FailureHandling.OPTIONAL)

(mapBoolean['2']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Estado-n'), 
    FailureHandling.OPTIONAL)

(mapBoolean['3']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_chkContiene Pago_n'), 
    FailureHandling.OPTIONAL)

(mapBoolean['4']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_chkAmparo-n'), 
    FailureHandling.OPTIONAL)

(mapBoolean['5']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), 
    FailureHandling.OPTIONAL)

(mapBoolean['6']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Observaciones Obsba-n'), 
    FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
validar = !(mapBoolean.containsValue(false))

assert validar

