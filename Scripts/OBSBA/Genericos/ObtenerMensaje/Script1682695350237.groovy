import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ErrorUsuarioMensaje'), 3)

def msj = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ErrorUsuarioMensaje'))

KeywordUtil.logInfo('Mensaje en pantalla: ' + msj)

return msj