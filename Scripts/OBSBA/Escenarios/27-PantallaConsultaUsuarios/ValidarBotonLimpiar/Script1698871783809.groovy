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
/**Script valida que se encuentra el boton Buscar,
 * carga todos los filtros presiona el boton y valida que los campos
 * se hayan vaciado**/
boolean validar = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Apellido  Nombre  Razon Social_fullName'),
	'prueba')

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/svg_Tipo usuario_MuiSvgIcon-root'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoUsuario'), [('varOpcion') : 'interno'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Nombre de Usuario_userName'), 'prueba')

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Intentos Fallidos_failedAttempts'),
	'11')

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_CUITCUIL_nDocumento'), usuario)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha desde_dateFrom'), '01/01/2024')

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha hasta_dateTo'), '01/01/2024')

not_run: (mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/span_Limpiar'),
	1, FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/button_Limpiar'),
	1, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/span_Limpiar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

/**
not_run: (mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Apellido  Nombre  Razon Social_fullName'),
	'')

not_run: (mapBoolean['3']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_Tipo usuario'),
	'')

not_run: (mapBoolean['4']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Nombre de Usuario_userName'),
	'')

not_run: (mapBoolean['5']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Intentos Fallidos_failedAttempts'),
	'')

not_run: (mapBoolean['6']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_CUITCUIL_nDocumento'),
	'')

not_run: (mapBoolean['7']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha desde_dateFrom'),
	'')

not_run: (mapBoolean['8']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha hasta_dateTo'),
	'')
**/

(mapBoolean['2'])= WebUI.callTestCase(findTestCase('OBSBA/Escenarios/27-PantallaConsultaUsuarios/ValidarTodosCamposVacios'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validar = !mapBoolean.containsValue(false)

assert validar

