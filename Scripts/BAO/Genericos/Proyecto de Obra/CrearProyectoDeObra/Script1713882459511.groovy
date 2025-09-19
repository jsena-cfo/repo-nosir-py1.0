import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/InsertarObraSIGAF'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/InsertarObraSIGAF - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.UE], FailureHandling.STOP_ON_FAILURE)

def nroObra = WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/ObtenerUltimaObra'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Home/menuProyectoDeObra'))

WebUI.click(findTestObject('BAO/Proyecto de Obra/btnNuevoProyecto'))

String fechaHoraString = LocalDateTime.now().format(DateTimeFormatter.ofPattern('yyyyMMddHHmmss')).replaceAll('\\D', '')

WebUI.setText(findTestObject('BAO/Proyecto de Obra/inputNombre'), 'Test Automation ' + fechaHoraString)

WebUI.setText(findTestObject('BAO/Proyecto de Obra/inputNumeroObraPublica'), nroObra)

WebUI.click(findTestObject('BAO/Proyecto de Obra/btnBusquedaAvanzada'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Proyecto de Obra/btnGuardar'))

WebUI.delay(3)

