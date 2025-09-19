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

/**Author: JER**/
String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPassword').toString()

String cuil = getBinding().getAt('varCuil').toString()

//WebUI.openBrowser(GlobalVariable.URL_OBSBA)
//WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : GlobalVariable.URL_OBSBA], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_REGISTRATE'))

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_Tipo de perfil_profileType'))

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_Tipo de perfil_profileType'), Keys.chord(
        Keys.BACK_SPACE))

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_Tipo de perfil_profileType'), 'Interno')

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/input_Tipo de perfil_profileType'), Keys.chord(
        Keys.DOWN + Keys.ENTER))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'interno'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Usuario SIGAF_internal_sigafUser3'), usuario)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_CUITCUIL_internal_cuitcuil3'), cuil)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Nueva contrasea_internal_password3'), password)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Repita contrasea_internal_repeatPassword3'), 
    password)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_Registrar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrar'), [:], FailureHandling.STOP_ON_FAILURE)

def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
    false, FailureHandling.OPTIONAL)

return registroSatisfactorio

