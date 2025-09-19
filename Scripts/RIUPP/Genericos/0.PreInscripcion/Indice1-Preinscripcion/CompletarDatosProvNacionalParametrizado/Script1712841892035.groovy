import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

def cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('empresa', dni)

GlobalVariable.cuitProveedor = cuit
GlobalVariable.emailProveedor = (cuit + '@test.com')
GlobalVariable.razonSocial = ('Test ' + cuit)
KeywordUtil.logInfo('CUIT proveedor: ' + cuit)

WebUI.check(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/rbTipoProveedor', [('tipo') : tipoProveedor]))

def razonSocial = (razonSocial == '') ? GlobalVariable.razonSocial : razonSocial
WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputRazonSocial'), razonSocial)

def nroCuit = (CUIT == '') ? cuit : CUIT
WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputCUIT'), nroCuit)

def email = (correo == '') ? cuit + '@test.com' : correo
WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputCorreo'), email)

def web = (sitioWeb == '') ? 'www.test.com.ar' : sitioWeb
WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputSitioWeb'), web)

def captchaEstaPresente = WebUI.verifyElementPresent(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inpCodValidacion'), 
    5, FailureHandling.OPTIONAL)

if (captchaEstaPresente) {
    WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inpCodValidacion'), '11111')
}

WebUI.click(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/btnSiguiente'))