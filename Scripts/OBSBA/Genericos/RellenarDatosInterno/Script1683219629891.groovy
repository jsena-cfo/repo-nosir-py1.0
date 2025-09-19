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
String cuil = getBinding().getAt('varCuil').toString()

String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPassword').toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'interno'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Usuario SIGAF_internal_sigafUser3'), 
    1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Usuario SIGAF_internal_sigafUser3'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Usuario SIGAF_internal_sigafUser3'), usuario)

WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_CUITCUIL_internal_cuitcuil3'), 
    1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_CUITCUIL_internal_cuitcuil3'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_CUITCUIL_internal_cuitcuil3'), cuil)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_Registrar'), 1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Nueva contrasea_internal_password3'))

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Nueva contrasea_internal_password3'), password)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarInterno/input_Repita contrasea_internal_repeatPassword3'), 
    password)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

