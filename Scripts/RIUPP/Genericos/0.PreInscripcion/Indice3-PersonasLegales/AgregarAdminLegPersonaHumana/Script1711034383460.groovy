import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btn_Agregar administrador legitimado'))

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/chkUsarDatosPersonaHumana'))

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

def cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

def usuario = 'qa' + dni

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputUsuario'), usuario)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/selectPais'), 'Argentina', 
    false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCalle'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNumero'), '1234')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputPiso'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputDepartamento'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCodigoPostal'), '1234')

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputMontoLimiteOfertar'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btnAgregarPersonaHumana'))

