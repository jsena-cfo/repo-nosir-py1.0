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
/**Valida que es posible modificar los datos de un usuario,
 * guarda los cambios en BUSUARIO_PORTAL**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false]

boolean validar = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'interno'
		, ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : usuarioInt, ('varFechaDesde') : '', ('varFechaHasta') : ''],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdministrarUsuario'), [:], FailureHandling.STOP_ON_FAILURE)

//String nombre = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Nombre de Usuario_userName'))
String nombre = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Nombre de Usuario_userName'),
	'value', FailureHandling.STOP_ON_FAILURE)

System.out.println('Valor Nombre: ' + nombre)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarDatosAdministrarUsuario'), [('varNombre') : nombre + 'modificado'
		, ('varTelefono') : '1110011001', ('varDomicilio') : 'Calle Modificada 555', ('varEmail') : 'klonautomation@gmail.com'
		, ('varIntentosFallidos') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/h2_msjOperacionRealizadaExitosamente'),
	1)

(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/h2_msjOperacionRealizadaExitosamente'),
	'Operación realizada exitosamente')

(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/p_msjOperacionModificadoExitosamente'),
	'El usuario ha sido modificado exitosamente.')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['3']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarDatosUsuarios'), [('varNombre') : nombre + 'modificado'
		, ('varTelefono') : '1110011001', ('varDomicilio') : 'Calle Modificada 555', ('varEmail') : 'klonautomation@gmail.com'
		, ('varIntentosFallidos') : '1'], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['4']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/ValidarCambiosAdministrarUsuarioBD'),
	[('varNombre') : nombre + 'modificado', ('varTelefono') : '1110011001', ('varDomicilio') : 'Calle Modificada 555', ('varEmail') : 'klonautomation@gmail.com'
		, ('varIntentosFallidos') : '1', ('varCuil') : usuarioInt], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarDatosAdministrarUsuario'), [('varNombre') : nombre, ('varTelefono') : 'x'
		, ('varDomicilio') : 'x', ('varEmail') : 'KLONAUTOMATION@HOTMAIL.COM', ('varIntentosFallidos') : '0'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar