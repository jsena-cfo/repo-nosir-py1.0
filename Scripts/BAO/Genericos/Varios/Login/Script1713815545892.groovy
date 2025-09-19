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

WebUI.openBrowser(GlobalVariable.url_BAO)

WebUI.waitForPageLoad(20)

WebUI.maximizeWindow()

//Ingresar con user y pass
WebUI.click(findTestObject('BAC/Home/btn_Ingresar'))

WebUI.sendKeys(findTestObject('BAC/Home/input_User'), user)

WebUI.sendKeys(findTestObject('BAC/Home/input_Password'), password)

WebUI.click(findTestObject('BAC/Home/btnIngresarPopUp'))

def tienePassVencida = WebUI.verifyTextPresent('Cambiar clave', false, FailureHandling.OPTIONAL)

if (tienePassVencida == true) {
    WebUI.setText(findTestObject('BAC/Home/inpClaveActual'), password)

    WebUI.setText(findTestObject('BAC/Home/inpNuevaClave'), '12345678')

    try {
        WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inpCodValidacion'), '11111')
    }
    catch (Exception ex) {
        println('Captcha desactivado')
    } 
    
    WebUI.setText(findTestObject('BAC/Home/inpReingresoClave'), '12345678')

    WebUI.click(findTestObject('BAC/Home/btnCambiarClave'))
}

def tieneNotificaciones = WebUI.verifyTextPresent('Tiene comunicaciones oficiales pendientes, debe darse por notificado para continuar.', 
    false, FailureHandling.OPTIONAL)

if (tieneNotificaciones == true) {
    WebUI.click(findTestObject('BAC/Home/btnNotificarme'))
}

def msjAcuerdoConfindencialidad = WebUI.verifyTextPresent('ACUERDO DE CONFIDENCIALIDAD', false, FailureHandling.OPTIONAL)

if (msjAcuerdoConfindencialidad == true) {
    WebUI.click(findTestObject('BAO/Home/btnAceptarAcuerdo'))
}

