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

def caracteres = ('abcdefghijklmnopqrstuvwxyz').toCharArray()
 
// Generar el string aleatorio
def apellidoAleatorio = (1..15).collect { caracteres[new Random().nextInt(caracteres.size())] }.join()


WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputNombre'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputApellido'), apellidoAleatorio)

GlobalVariable.razonSocial = 'test '+ apellidoAleatorio

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/selectSexo'), 'Femenino', false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputFechaNacimiento'), '01/01/1990')

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/selectNacionalidad'), 'Argentina', false)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/selectEstadoCivil'), 'Viudo/a', false)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 2/selectTipoDoc'), 'DNI', false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputNumeroDocumento'), GlobalVariable.dniProveedor)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputNumeroCUIT'), GlobalVariable.cuitProveedor)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 2/inputCorreoElectronico'), GlobalVariable.emailProveedor )

WebUI.setText(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/inputNumero de IIBB'), '12345678')


WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice2-InfoBasica/CompletarDomicilioLegal'), [('provincia') : provincia
	, ('partido') : partido, ('localidad') : localidad], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/chkUsarMismoDomicilio'))

WebUI.click(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/rbFiguraEstatal'))

WebUI.click(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/btnSiguiente'))

