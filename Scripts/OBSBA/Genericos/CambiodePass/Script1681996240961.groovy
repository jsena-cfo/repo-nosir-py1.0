import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//Abril 2023 la validación permite volver a poner la misma contrasena
WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/SelectInfoUser'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/BtnMiPerfil'))

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'))

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputNuevaContrasena'), NuevaContrasena)

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputRepitaContrasea'), NuevaContrasena)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/button_Guardar'))

def msjError = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerMensaje'), [:], FailureHandling.STOP_ON_FAILURE)

assert msjError == 'Operación exitosa'

WebUI.closeBrowser()

