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
String nombre = getBinding().getAt('varNombre')

String telefono = getBinding().getAt('varTelefono')

String domicilio = getBinding().getAt('varDomicilio')

String email = getBinding().getAt('varEmail')

String intentosFallidos = getBinding().getAt('varIntentosFallidos')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/KeyLimpiarCampo'), [('varInput') : 'ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Apellido  Nombre  Razon Social_fullName'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/KeyLimpiarCampo'), [('varInput') : 'ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_N Telfono_nTelefono'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/KeyLimpiarCampo'), [('varInput') : 'ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Domicilio_domicilio'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/KeyLimpiarCampo'), [('varInput') : 'ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Email_email'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/KeyLimpiarCampo'), [('varInput') : 'ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Login Fallidos_failedAttempts'],
	FailureHandling.STOP_ON_FAILURE)

/**
WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Apellido  Nombre  Razon Social_fullName'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_N Telfono_nTelefono'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Domicilio_domicilio'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Email_email'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Login Fallidos_failedAttempts'), FailureHandling.STOP_ON_FAILURE)
**/
WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Apellido  Nombre  Razon Social_fullName'),
	nombre)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_N Telfono_nTelefono'), telefono)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Domicilio_domicilio'), domicilio)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Email_email'), email)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/input_Login Fallidos_failedAttempts'), intentosFallidos)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/button_Guardar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)
