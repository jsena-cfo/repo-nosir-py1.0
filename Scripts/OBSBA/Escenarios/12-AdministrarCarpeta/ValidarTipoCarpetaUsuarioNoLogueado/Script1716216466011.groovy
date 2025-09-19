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
/**Si no está logueado el usr que lo creó, no permite modificar el estado**/
String numeroCarpeta

boolean validar = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false]

if (reutilizacion) {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerNumeroCarpetaReutilizada'), [('varTipo') : 'internoCarDoc'
            , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)
} else {
    numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : usuario
            , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)
}

'Se loguea con un usuario diferentes'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdmin, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdministrarCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/label_Administrar Carpeta'), 1)

(mapBoolean['1']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Tipo de carpeta-n'))

(mapBoolean['2']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Estado-n'))

(mapBoolean['3']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_chkContiene Pago_n'))

(mapBoolean['4']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_chkAmparo-n'))

(mapBoolean['5']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'))

(mapBoolean['6']) = WebUI.verifyElementNotClickable(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Observaciones Obsba-n'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
validar = !(mapBoolean.containsValue(false))

assert validar

