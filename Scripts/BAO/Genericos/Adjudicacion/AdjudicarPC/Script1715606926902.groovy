import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userSolicitante
        , ('pass') : GlobalVariable.pass, ('accion') : 'Adjudicar Proceso'], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 5)

WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/txt_Observaciones'), 'test')

def profilename = RunConfiguration.getExecutionProfile()

if(profilename == 'BAO_QA'){
	WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/select_AnalistaOGESE'), 'Javier Estevez',
		true)
}
else if (profilename == 'BAO_PRE'){
	WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/select_AnalistaOGESE'), 'Javier Estevez',
		true)
}

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btnAGREGARAnalistasOGESE'))

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Adjudicación/btn_SolicitarAfectacionDefinitiva'))

WebUI.verifyTextPresent('La Solicitud fue Enviada Satisfactoriamente. Se ha notificado al Analista OGESE.', false)

