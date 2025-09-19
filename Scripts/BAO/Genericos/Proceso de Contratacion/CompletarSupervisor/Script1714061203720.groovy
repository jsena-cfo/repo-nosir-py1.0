import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAO/Proceso de Contratacion/Supervisor/btn_CompletarDatos'))

def profilename = RunConfiguration.getExecutionProfile()

WebUI.selectOptionByLabel(findTestObject('BAO/Proceso de Contratacion/Supervisor/selectSupervisor'), 'Javier Estevez', false)

WebUI.click(findTestObject('BAO/Proceso de Contratacion/Supervisor/btnAgregar'))

WebUI.click(findTestObject('BAO/Proceso de Contratacion/Supervisor/btnGuardaryVolver'))

WebUI.waitForElementPresent(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/btn_Enviar al Supervisor'), 10)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/btn_Enviar al Supervisor'))

if (WebUI.verifyTextPresent('El proceso fue enviado al supervisor. El supervisor será notificado para que continúe con el proceso de contratación.',
	false)) {
	WebUI.takeScreenshot()
}