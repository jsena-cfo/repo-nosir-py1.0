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

def fechaVencimiento = CustomKeywords.'tool.DateGenerator.addWorkingDays'(GlobalVariable.fechaActual, 20)

WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbAprobadoPrimerClase'))

WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbAprobadoSegundaClase'))

WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbConstanciaIIBBAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputConstanciaIIBBFechaVencimiento'), fechaVencimiento)

WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbCertificado_SaludAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/inputCertificado_SaludFechaVencimiento'), fechaVencimiento)

WebUI.check(findTestObject('RIUPP/Evaluacion RIUPP/rbConstanciaAFIPRechazado'))

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('Todas las secciones rechazadas deben tener una observación de al menos cinco caracteres.', false)

WebUI.setText(findTestObject('RIUPP/Evaluacion RIUPP/textareaObservacionesConstanciaAFIP'), 'test qa automation test')

WebUI.click(findTestObject('RIUPP/Evaluacion RIUPP/btnFinalizarEvaluacion'))