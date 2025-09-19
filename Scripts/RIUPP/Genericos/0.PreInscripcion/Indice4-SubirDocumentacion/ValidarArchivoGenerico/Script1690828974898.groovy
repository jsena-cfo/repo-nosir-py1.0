import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordUtil.logInfo('Validacion archivo no valido (distinto a pdf)')

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : nombreDoc
		, ('nombreArchivo') : 'test.docx'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('El formato del archivo debe corresponder a las extensiones: pdf', false)

KeywordUtil.logInfo('Validacion archivo .pdf de 100 mb')

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : nombreDoc
		, ('nombreArchivo') : '100mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('El archivo no debe superar los 100 MB', false)

KeywordUtil.logInfo('Validacion "N" archivos .pdf')

for(file=1;file<fileMax;file++) {
	WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : nombreDoc
		, ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

}
