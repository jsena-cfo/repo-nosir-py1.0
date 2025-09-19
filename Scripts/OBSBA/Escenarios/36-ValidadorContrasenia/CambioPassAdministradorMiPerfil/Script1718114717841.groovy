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
/**Cambia el pass de un administrador desde Mi Perfil**/
/**El pass exige 8 caracteres entre numéricos, mayúsculas y minúsculas**/
boolean validar = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

'Se cambia la password'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'), 1)

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputNuevaContrasena'), passNew)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputRepitaContrasea'), passNew)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/p_Operacin exitosa'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Se cambio pass: ' + (mapBoolean['1']).toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

'Se ingresa con la nueva pass y se carga la pass anterior'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : passNew], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

System.out.println('Se logueo con el nuevo pass: ' + (mapBoolean['2']).toString())

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'), 1)

WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/CheckSwitchCambiodePass'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputNuevaContrasena'), pass)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/inputRepitaContrasea'), pass)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['3']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/p_Operacin exitosa'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Se modifico el pass con el valor anterior: ' + (mapBoolean['3']).toString())

System.out.println('Validaciones realizadas: ' + mapBoolean.toString())

validar = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

