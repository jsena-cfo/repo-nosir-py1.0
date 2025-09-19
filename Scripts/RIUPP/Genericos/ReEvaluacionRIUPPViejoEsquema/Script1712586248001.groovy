import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarRazonSocialMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarCUITMisTramites'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
			, ('accion') : 'Evaluar']))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))


def fechaVencimiento = CustomKeywords.'tool.DateGenerator.addWorkingDays'(GlobalVariable.fechaActual, 20)


if(tipoProveedor == 'Persona jurídica extranjera sin sucursal') {
	WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbCertificado_SaludAprobado'))
	
	WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputCertificado_SaludFechaVencimiento'), fechaVencimiento)
}else {

	WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbConstanciaIIBBAprobado'))
	
	WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputConstanciaIIBBFechaVencimiento'), fechaVencimiento)
	
	try {
		WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbCertificado_SaludAprobado'))
		
		WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputCertificado_SaludFechaVencimiento'), fechaVencimiento)
	}
	catch (Exception e)
	{
		println("No posee clases de Salud")
	}
	
	WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbConstanciaAFIPAprobado'))
	
	WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputConstanciaAFIPFechaVencimiento'), fechaVencimiento)
}

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnFinalizarEvaluacion'))



WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.EvaluacionRIUPP/EvaluarIndice5'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Evaluación RIUPP finalizada', false)