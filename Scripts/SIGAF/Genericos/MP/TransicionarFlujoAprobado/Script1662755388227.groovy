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
import org.openqa.selenium.Keys as Keys

//toma los parametros recibidos
String usuarioVar= this.getBinding().getVariables().getAt('varUsuario').toString()
String passwordVar= this.getBinding().getVariables().getAt('varPassword').toString()
String numeroVar= this.getBinding().getVariables().getAt('varNumero').toString()
String ejercicioVar= this.getBinding().getVariables().getAt('varEjercicio').toString()

System.out.println('Se buscara numero: ' + numeroVar)

//se loguea, ingresa al menu, busca la mp por numero, aprueba y sale
WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAlt'), [('varUsuario') : usuarioVar, ('varPassword') : passwordVar
		, ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/BuscarEjercicioNumero'), [('varNumero') : numeroVar, ('varEjercicio') : ejercicioVar],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/TransicionarAprobado'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

//volver a ingresar para validar estado final modificado

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAlt'), [('varUsuario') : usuarioVar, ('varPassword') : passwordVar
		, ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/BuscarEjercicioNumero'), [('varNumero') : numeroVar, ('varEjercicio') : ejercicioVar],
	FailureHandling.STOP_ON_FAILURE)

String estadoActualizado = WebUI.callTestCase(findTestCase('SIGAF/Genericos/MP/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println("Estado actualizado: " + estadoActualizado)

String estadoActualizadoAux= estadoActualizado.trim()

System.out.println("Estado actualizado aux: " + estadoActualizadoAux)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

if (estadoActualizadoAux == "APROBADO") {
	System.out.println('El estado cambio a APROBADO')
	assert true
} else {
	System.out.println('El estado no cambio a APROBADO')
	assert false
}