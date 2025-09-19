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

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/btnOpciones'))

WebUI.delay(3)

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/liAccion', [('variable') : 'Evaluación Técnica']))

WebUI.check(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/rdoEvalTecCumpleReqMinimos'))


WebUI.check(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/rdoEvalTecCumpleCriterios'))


try {
    WebUI.check(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/rdoEvalTecCumpleCriterios2'))
}
catch (Exception ex) {
    println('Solo hay un item')
} 



/*
def codigosDeItem = ['33.09.003.0010.1', '33.09.003.0018.3', '33.09.003.0000.44', '33.09.003.0001.1', '33.09.003.0002.1'
    , '33.09.003.0002.2', '33.09.003.0003.1', '33.09.003.0003.2', '33.09.003.0005.1', '33.09.003.0006.1', '33.09.003.0007.1'
    , '33.09.003.0007.2', '33.09.003.0008.1', '33.09.003.0009.1', '33.09.003.0010.10', '33.09.003.0010.11', '33.09.003.0010.12'
    , '33.09.003.0010.2', '33.09.003.0010.3', '33.09.003.0010.4', '33.09.003.0010.5', '33.09.003.0010.6', '33.09.003.0010.7'
    , '33.09.003.0010.8', '33.09.003.0011.1', '33.09.003.0012.1', '33.09.003.0012.10', '33.09.003.0012.11', '33.09.003.0012.12'
    , '33.09.003.0012.13', '33.09.003.0012.14', '33.09.003.0012.2', '33.09.003.0012.3', '33.09.003.0012.4', '33.09.003.0012.5'
    , '33.09.003.0012.6', '33.09.003.0012.7', '33.09.003.0012.8', '33.09.003.0012.9', '33.09.003.0013.1', '33.09.003.0013.2'
    , '33.09.003.0013.3', '33.09.003.0013.4', '33.09.003.0013.5', '33.09.003.0014.1', '33.09.003.0014.2', '33.09.003.0014.3'
    , '33.09.003.0014.4']

for (int i = 1; i <= codigosDeItem.size(); ++i) {
    WebUI.check(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/rdoEvalTecCumpleCriterios - Copy', [('nroItem') : i]))
}
*/
WebUI.click(findTestObject('BAC/Pre Adjudicacion/Evaluacion de Ofertas/btnFinalizarEvaluacion'))

