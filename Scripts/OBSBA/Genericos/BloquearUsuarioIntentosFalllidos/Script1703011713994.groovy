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

boolean validar = false

String usuario = getBinding().getAt('varUsuario').toString()

String passInvalido = getBinding().getAt('varPassInvalido').toString()

'Se intenta loguear con contrasenia invalida'
for (int i : (1..6)) {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : passInvalido], FailureHandling.STOP_ON_FAILURE)
    WebUI.delay(1)
}

//validar = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_Login/p_msjUsuarioBloqueadoIntentosFallidos'), 
//    'Usuario bloqueado por superar intentos fallidos', FailureHandling.STOP_ON_FAILURE)

validar= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Usuario bloqueado por superar intentos fallidos'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

