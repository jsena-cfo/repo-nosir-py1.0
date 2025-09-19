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

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

def cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/btnAgregarSocio'))

if (!(esExtranjero)) {
    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectTipoPersona'), 'Física', false)

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputCUIT'), cuit)
}

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputNombre'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputApellido'), 'automation')

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectSexo'), genero, false)

if (esExtranjero) {
    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectTipoDocumento'), 'Pasaporte', 
        false)
} else {
    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectTipoDocumento'), 'DNI', false)
}

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputNumeroDocumento'), dni)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputCorreoElectronico'), ('qa' + dni) + '@test.com')

not_run:def cantCargos = WebUI.getNumberOfTotalOption(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectCargo'))

not_run:def cargoAleatorio = new Random().nextInt(cantCargos) - 1

not_run:println(cargoAleatorio.toString())

WebUI.selectOptionByIndex(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectCargo'), '11')

not_run: if (cargoAleatorio.toString() == '17') {
    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/inputDetalleCargo'), 'test')
}

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/selectEstadoCivil'), 'Viudo/a', false)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Agregar socio/btn_Agregar'))

