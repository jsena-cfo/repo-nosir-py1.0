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

String tipoCarpeta = getBinding().getAt('varTipoCarpeta').toString()

String tipoPerfil = getBinding().getAt('varTipoPerfil').toString()

boolean validar = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : tipoCarpeta], FailureHandling.STOP_ON_FAILURE)

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarCheckPerfilYCopago'), [('varTipoPerfil') : tipoPerfil], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'), 'Prueba titulo' + valorRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion de Carpeta'), 'Prueba Descripcion' + 
    valorRandom)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/div_CarpetaCreadaExito'), 1)

//validar = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/p_CarpetaCreadaExito'), 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!')

validar= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

return validar

