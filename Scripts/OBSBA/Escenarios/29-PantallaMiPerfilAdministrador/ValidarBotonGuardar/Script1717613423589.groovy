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
/**Hay problemas con el cambio de cuit-cuil
 * Se resuelve en RM 107916 y 107917**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false]

boolean validar = false

String numeroRandom= CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'().toString()

System.out.println('Numero Ransom: ' + numeroRandom)

String telefono = '15111' + numeroRandom

String domicilio = 'Calle Nueva ' + numeroRandom

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'), telefono)

WebUI.clearText(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'), domicilio)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/h2_Datos de usuario actualizados'), 
    1)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/p_Operacin exitosa'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

String telefonoMod

String domicilioMod

telefonoMod= WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'), 'value')

domicilioMod= WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'), 'value')

System.out.println('Telefono Mod: ' + telefonoMod)

System.out.println('Domicilio Mod: ' + domicilioMod)

(mapBoolean['3'])= (telefono== telefonoMod)

(mapBoolean['4'])= (domicilio== domicilioMod)

validar = !(mapBoolean.containsValue(false))

System.out.println('Valida guardar: ' + mapBoolean.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

