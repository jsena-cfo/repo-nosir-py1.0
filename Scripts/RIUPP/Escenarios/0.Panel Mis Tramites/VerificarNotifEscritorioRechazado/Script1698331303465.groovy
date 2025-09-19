import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def userLogin = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorConTramiteTerminado'), [('tramiteEval') : 'Rechazada'],
	FailureHandling.STOP_ON_FAILURE)

if(userLogin[0] != null) {
	WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userLogin[0], ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyTextPresent('Información: Se le comunica que tiene un trámite en estado Rechazado. Puede visualizar el trámite desde el ítem de menú "MisTramites"',
		false)
}
else {
	KeywordUtil.markFailed('No se encontro usuario con tipo tramite Rechazado')
}

