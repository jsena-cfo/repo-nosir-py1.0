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
String email = getBinding().getAt('varEmail').toString()

String password = getBinding().getAt('varPassword').toString()

String cuit = getBinding().getAt('varCuit').toString()

String user = getBinding().getAt('varUser').toString()

String telefono = getBinding().getAt('varTelefono').toString()

String direccion = getBinding().getAt('varDireccion').toString()

String url = getBinding().getAt('varUrl').toString()

//WebUI.openBrowser(GlobalVariable.URL_OBSBA)
//WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'empleado'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nombre y apellido  Razon social_fullName'), 
    user)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_CUITCUIL_idInpCUIT'), cuit)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Correo electrnico_idInpEmail'), email)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita correo electrnico_idInpEmailRep'), email)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Telfono_idInpTelefono'), telefono)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Domicilio legal_idInpDomicilio'), direccion)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nueva contrasea_password'), password)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita contrasea_idInpRepeatPassword'), password)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

