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
/**Valida que el boton Adjuntar si no se cargan documentos este desactivado**/
/**Valida que el boton Subir Archivo este presente**/
boolean adjuntarDesactivado = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

String nuevaCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : varUser
        , ('varPass') : varPass], FailureHandling.STOP_ON_FAILURE)

'Comentario: Login usuario Interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varUser, ('Contrasena') : varPass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : nuevaCarpeta
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : varUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/button_Adjuntar'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/button_Adjuntar'), 1)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo'), 
    1)

(mapBoolean['2']) = WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/button_Adjuntar'), 
    'disabled', 'true', 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Boton adjuntar desactivado: ' + adjuntarDesactivado)

System.out.println('Valor maps: ' + mapBoolean)

adjuntarDesactivado = !(mapBoolean.containsValue(false))

assert adjuntarDesactivado

