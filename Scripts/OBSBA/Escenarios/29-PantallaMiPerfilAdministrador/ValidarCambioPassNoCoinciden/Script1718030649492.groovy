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
boolean validar = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'), 1)

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputNuevaContrasena'), 'Automation2020')

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputRepitaContrasea'), 'Auto20')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

validar = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/p_msjContraseasNoCoinciden'), 1)

System.out.println('Mensaje pass no coincide: ' + validar.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

