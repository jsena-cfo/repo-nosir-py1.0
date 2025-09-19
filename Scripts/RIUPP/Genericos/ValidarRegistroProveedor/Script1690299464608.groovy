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

if (tipoProveedor == 'JuridicoExtranjero') {
    WebUI.scrollToElement(findTestObject('RIUPP/Page_BAC - Indice 6/btnConfirmar'), 5)

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6/btnConfirmar'))

    WebUI.verifyTextPresent(('Le enviamos el correo electrónico con el remitente "Notificaciones BAC" a: ' + email) + ' para continuar con el proceso de registro. Si no lo ubica en la bandeja de entrada, por favor verifique en la carpeta SPAM.', 
        false)
} else {
    WebUI.scrollToElement(findTestObject('RIUPP/Page_BAC - Indice 6/btnConfirmar'), 5)

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 6/btnConfirmar'))

    WebUI.verifyTextPresent(('Le enviamos el correo electrónico con el remitente "Notificaciones BAC" a: ' + email) + ' para continuar con el proceso de inscripción. Si no lo ubica en la bandeja de entrada, por favor verifique en la carpeta SPAM.', 
        false)
}

def enlace = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEnlanceRegistro'), [:], FailureHandling.STOP_ON_FAILURE)

assert (enlace != null) && !(enlace.isEmpty()) : 'Enlace de registro no encontrado.'

WebUI.openBrowser(enlace)

def msjFelicitaciones = WebUI.verifyTextPresent('Felicitaciones', false, FailureHandling.OPTIONAL)

if(msjFelicitaciones == false) {
	WebUI.openBrowser(enlace)
	WebUI.verifyTextPresent('Felicitaciones', false)
}

