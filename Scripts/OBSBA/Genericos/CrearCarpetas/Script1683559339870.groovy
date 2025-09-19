import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def carpetas = ['Bien Salud', 'Direccion Accion Soc', 'Fondo Compensador', 'Fondos Permanentes', 'F Con Cargos A Rend.', 'Nota/otros'
	, 'Prestador Común', 'Reintegro', 'Subsidio']

for (def tipoCarpeta : carpetas) {
	KeywordUtil.logInfo('Creacion carpeta: ' + tipoCarpeta)

	def idTitulo = CustomKeywords.'tool.DateGenerator.dateAndTime'()

	WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosCarpeta'), [('tipoCarpeta') : tipoCarpeta, ('contienePago') : false
			, ('titulo') : 'Test ' + idTitulo.toString(), ('descripcion') : 'Prueba automatizada'], FailureHandling.STOP_ON_FAILURE)

	def carpetaActual = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerIDCarpeta'), [('titulo') : idTitulo], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.takeScreenshot()

	KeywordUtil.logInfo((('Se ha creado tipo de carpeta "' + tipoCarpeta) + '" con numero carpeta: ') + carpetaActual)
}

