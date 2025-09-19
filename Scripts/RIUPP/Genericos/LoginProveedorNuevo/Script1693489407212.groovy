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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

def credenciales = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerUserYPassProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

assert (credenciales != null) && !(credenciales.isEmpty()) : 'Credenciales no encontradas'

GlobalVariable.proveedorInscripto = (credenciales[0])

WebUI.openBrowser(GlobalVariable.url_BAC)

WebUI.waitForPageLoad(20)

WebUI.maximizeWindow()

//Ingresar con user y pass
WebUI.click(findTestObject('BAC/Home/btn_Ingresar'))

WebUI.sendKeys(findTestObject('BAC/Home/input_User'), credenciales[0])

WebUI.sendKeys(findTestObject('BAC/Home/input_Password'), credenciales[1])

WebUI.click(findTestObject('BAC/Home/btnIngresarPopUp'))

WebUI.setText(findTestObject('BAC/Home/inpClaveActual'), credenciales[1])

WebUI.setText(findTestObject('BAC/Home/inpNuevaClave'), '12345678')

WebUI.setText(findTestObject('BAC/Home/inpReingresoClave'), '12345678')

try {
    WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inpCodValidacion'), '11111')
}
catch (Exception ex) {
    println('Captcha desactivado')
} 

WebUI.click(findTestObject('BAC/Home/btnCambiarClave'))

not_run: WebUI.verifyTextPresent('La clave fue cambiada satisfactoriamente', false)

