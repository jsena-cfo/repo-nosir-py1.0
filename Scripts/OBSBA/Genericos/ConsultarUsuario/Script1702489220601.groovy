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
String razonSocial = getBinding().getAt('varRazonSocial').toString()

String tipoUsuario = getBinding().getAt('varTipoUsuario').toString()

String nombreUsuario = getBinding().getAt('varNombreUsuario').toString()

String intentosFallidos = getBinding().getAt('varIntentosFallidos').toString()

String cuil = getBinding().getAt('varCuil').toString()

String fechaDesde = getBinding().getAt('varFechaDesde').toString()

String fechaHasta = getBinding().getAt('varFechaHasta').toString()

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Apellido  Nombre  Razon Social_fullName'),
	razonSocial)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/svg_Tipo usuario_MuiSvgIcon-root'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoUsuario'), [('varOpcion') : tipoUsuario], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Nombre de Usuario_userName'), nombreUsuario)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Intentos Fallidos_failedAttempts'),
	intentosFallidos)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_CUITCUIL_nDocumento'), cuil)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha desde_dateFrom'), fechaDesde)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/input_Fecha hasta_dateTo'), fechaHasta)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/button_Buscar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickBuscarConsulta'), [:], FailureHandling.STOP_ON_FAILURE)

