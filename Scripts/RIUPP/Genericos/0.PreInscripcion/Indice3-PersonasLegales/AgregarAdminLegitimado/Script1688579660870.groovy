import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btn_Agregar administrador legitimado'))

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

def cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

def usuario = 'qa' + dni

KeywordUtil.logInfo((((('CUIT: ' + cuit) + ' DNI: ') + dni) + ' Usuario creado: ') + usuario)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/select_TipoAdministrador'), tipoAdministrador, false)	

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNombre'), 'Test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputApellido'), 'QA')

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/selectSexo'), genero, false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputFechaNacimiento'), '06/06/1990')

if(esExtranjero) {
	WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/select_SeleccionarCIDNILCLEPasaporte'), 'Pasaporte', false)
	
}
else {
	WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/select_SeleccionarCIDNILCLEPasaporte'), 'DNI', false)
}


WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNumeroDocumento'), dni)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCUIT'), cuit)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputUsuario'), usuario)

def email = usuario + '@test.com'

KeywordUtil.logInfo(email)

GlobalVariable.emailAdminLeg = email

//WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCorreoElectronico'), usuario + '@test.com')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCorreoElectronico'), email)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/selectPais'), 'Argentina', false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCalle'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNumero'), '1234')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputPiso'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputDepartamento'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCodigoPostal'), '1234')

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputMontoLimiteOfertar'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btn_Agregar'))
