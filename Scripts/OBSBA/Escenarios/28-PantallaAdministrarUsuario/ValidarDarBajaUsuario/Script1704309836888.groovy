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
/**Da de baja un usuario interno**/
/**si existe una fecha de baja y se borra dicha información en el campo
 * “FH Baja” de Administrar Usuario, el campo FH_BAJA de la tabla BUSUARIO_PORTAL
 * debe quedar en NULL**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

boolean validar = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'interno'
		, ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : usuarioInt, ('varFechaDesde') : '', ('varFechaHasta') : ''],
	FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/DarBajaUsuario'), [('varUsuarioBloqueo') : usuarioInt],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['2']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/ReactivarUsuario'),
	[('varUsuarioBloqueo') : usuarioInt, ('varTipoPerfil') : 'Interno'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

assert validar