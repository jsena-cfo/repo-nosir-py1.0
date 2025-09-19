import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 4/btnCompletarDatosAutorizadores'))

def profilename = RunConfiguration.getExecutionProfile()

if(profilename == 'BAO_QA'){
	WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 4/selectAutorizador'), 'Maximiliano Fernandez', false)
}
else if(profilename == 'BAO_PRE'){
	WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 4/selectAutorizador'), 'Maximiliano Fernandez', false)
}

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 4/btnSeleccionarAutorizador'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 4/btnGuardar y Volver'))



