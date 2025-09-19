import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_CompletarDatos'))

def profilename = RunConfiguration.getExecutionProfile()

/*** Valores usados en QA antes del cambio de UE
	WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Nicolas Maure']))
	
	WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Sabrini Mancini']))
	
	WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Pablo Iadone']))
	
***/	

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Natalia Mangas']))
	
WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Javier Estevez']))

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'EMILSE CARMEN FILIPPO']))
	
WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_Agregar'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador1'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador2'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador3'))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_GuardarYVolver'))

def subirDeclaracionJurada(TestObject btnAcciones) {
    def nroEval = btnAcciones.getObjectId().replaceAll('\\D', '')

    println(nroEval)

    WebUI.selectOptionByValue(findTestObject('BAO/Proceso de Contratacion/Evaluadores/selectTipoEvaluador', [('eval') : nroEval]), 
        nroEval, false)

    WebUI.click(btnAcciones)

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/li_SubirDeclaracion'))

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/select_TipoDocumento'), 
        tipoDoc, false)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_AnioDocumento'), anio)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_Numero'), numero)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_Reparticion'), reparticion)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/check_NumeroSADE'))

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_Ingresar'))
}