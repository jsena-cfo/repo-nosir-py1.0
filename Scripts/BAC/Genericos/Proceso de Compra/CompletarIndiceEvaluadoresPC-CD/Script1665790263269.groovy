import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_CompletarDatos'))

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/select_Seleccionar'), '401 - MINISTERIO DE SALUD',
	false)

//ssimonetta - Silvana Simonetta
//cservente - Carlos Servente
//aluna - Adolfo Luna
WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Carlos Servente']))
WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_Agregar'))
WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_GuardarYVolver'))

	