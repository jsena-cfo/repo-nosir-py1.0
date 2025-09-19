import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('BAC/Home/btn_CompletarDatosInfoBasica'))

def profilename = RunConfiguration.getExecutionProfile()

if(profilename == 'BAO_QA') {
	WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 1/selectUOC'), '401 - DIRECCI?N GENERAL ADMINISTRATIVA, CONTABLE Y PRESUPUESTO', false)
}
else if(profilename == 'BAO_PRE'){
	WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 1/selectUOC'), '401 - MINISTERIO DE SALUD', false)
}

WebUI.setText(findTestObject('BAC/Home/input_Unidad solicitante'), unidadSolicitante)

WebUI.click(findTestObject('BAC/Home/btn_Guardar y Volver'))



