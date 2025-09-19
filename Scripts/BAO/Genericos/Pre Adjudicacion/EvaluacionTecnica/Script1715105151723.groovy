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

WebUI.click(findTestObject('BAO/Pre Adjudicacion/btnOpcionesEvalTecnica'))

WebUI.check(findTestObject('BAO/Pre Adjudicacion/rdEvalTecCumpleCritPorRenglon'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('La Evaluación Técnica ha sido finalizada. Todos los puntos evaluados fueron marcados como "Cumple", por tal motivo la oferta de la obra física fue aceptada.', 
    false)

WebUI.click(findTestObject('BAO/Pre Adjudicacion/btnVolver'))

WebUI.click(findTestObject('BAO/Pre Adjudicacion/btnOpcionesEvalTecnica2'))

WebUI.check(findTestObject('BAO/Pre Adjudicacion/rdEvalTecCumpleCritPorRenglon'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/btnFinalizarEvaluacion'))

WebUI.verifyTextPresent('La Evaluación Técnica ha sido finalizada. Todos los puntos evaluados fueron marcados como "Cumple", por tal motivo la oferta de la obra física fue aceptada.', 
    false)

WebUI.click(findTestObject('BAO/Pre Adjudicacion/btnVolver'))

