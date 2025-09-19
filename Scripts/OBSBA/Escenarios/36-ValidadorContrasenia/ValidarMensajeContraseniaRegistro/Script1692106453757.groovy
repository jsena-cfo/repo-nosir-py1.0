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
/**El script valida que en el momento del registro se cargue una contraseña valida**/
WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/span_REGISTRATE'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrate'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/svg_Tipo de perfil_MuiSvgIcon-root'))

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/li_Afiliado'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'afiliado'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_CUITCUIL_external_cuitcuil'), '20-30886565-8')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Nombre y apellido  Razon social_external_fullName'), 
    'UsuarioTestPrueba')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Correo electrnico_external_email'), 
    'klonautomation@gmail.com')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Correo electrnico_external_email_confirmation'), 
    'klonautomation@gmail.com')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Telfono_external_phone'), '1145546089')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Domicilio legal_external_street'), 
    'Calle Guemes 555')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Nueva contrasea_external_password'), 
    'auto')

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/input_Repita contrasea_external_repeatPassword'), 
    'auto')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nombre y apellido  Razon social_fullName'), 
    'UsuarioTestPrueba')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_CUITCUIL_idInpCUIT'), '20-30886565-8')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Correo electrnico_idInpEmail'), 'klonautomation@gmail.com')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita correo electrnico_idInpEmailRep'), 'klonautomation@gmail.com')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Telfono_idInpTelefono'), '1145546089')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Domicilio legal_idInpDomicilio'), 'Calle Guemes 555')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nueva contrasea_password'), 'auto')

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita contrasea_idInpRepeatPassword'), 'auto')

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/p_mensajeContraseaErrorRegistro'), 
    2)

WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/p_mensajeContraseaErrorRegistro'), 'La contraseña debe ser alfanumérica y tener al menos 8 dígitos y una mayúscula')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

