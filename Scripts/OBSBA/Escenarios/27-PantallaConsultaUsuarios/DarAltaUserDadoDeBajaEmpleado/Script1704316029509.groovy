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
/**Script que dar de alta mediante un administrador un User dado de baja
 * por intentos fallidos**/
'Bloquea a un usuario empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/BloquearUsuarioIntentosFalllidos'), [('varUsuario') : usuarioBloqueo, ('varPassInvalido') : passInvalido],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdministrador, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'empleado'
		, ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : usuarioBloqueo, ('varFechaDesde') : '', ('varFechaHasta') : ''],
	FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_CantidadIntentosFallidos'),
	1)

WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_CantidadIntentosFallidos'),
	'5')

WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/ReactivarUsuario'), [('varUsuarioBloqueo') : usuarioBloqueo
		, ('varTipoPerfil') : 'Empleado'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'empleado'
		, ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : usuarioBloqueo, ('varFechaDesde') : '', ('varFechaHasta') : ''],
	FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_CantidadIntentosFallidos'),
	1)

WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/div_CantidadIntentosFallidos'),
	'0')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
