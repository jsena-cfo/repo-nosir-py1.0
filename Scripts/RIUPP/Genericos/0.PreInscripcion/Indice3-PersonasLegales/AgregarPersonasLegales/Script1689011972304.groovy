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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.waitForElementPresent(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/btnAgregar personas legales'), 5)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/btnAgregar personas legales'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/btnAgregar persona legal'))

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

def cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

def usuario = 'qa' + dni

KeywordUtil.logInfo((((('CUIT: ' + cuit) + ' DNI: ') + dni) + ' Usuario creado: ') + usuario)

if(!esHumano) {
	WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/selectTipoPersonaLegal'), tipoPersonaLegal,
		false)
}
WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputNombrePersonasLegales'), 'Test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputtApellidoPersonasLegales'), 'QA')

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/selectSexoPersonasLegales'), 
    genero, false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalesFechaNacimiento'), 
    '05/05/1990')

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalesFechaNacimiento'))

if (esExtranjero) {
    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/select_PersonasLegalesTipoDoc'), 
        'Pasaporte', false)
} else {
    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/select_PersonasLegalesTipoDoc'), 
        'DNI', false)

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalesNumeroCUIT'), cuit)
}

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalestNumeroDocumento'))

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalestNumeroDocumento'), 
    dni)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalesNombreUsuario'), usuario)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/inputPersonasLegalesCorreoElectronico'), 
    usuario + '@test.com')

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar personas legales/btnAgregar'))

