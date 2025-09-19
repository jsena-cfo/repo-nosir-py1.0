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

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnRecomendarOferta'))

//Aceptar primer oferta
WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnEvalEconomica'))

def tabla = '//table[contains(@id,"Renglones") and @class="dxgvTable"]/tbody'

def rows = '//tr[contains(@id,"Renglones") and contains(@class,"dxgvDataRow")]'

int cantRenglones = CustomKeywords.'tool.utilities.getRowCounts'(tabla, rows)

println("Cantidad de renglones encontrados: $cantRenglones")

for (int i = 1; i <= cantRenglones; i++) {
    WebUI.check(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/chkSeleccionar', [('variable') : i]))
}

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnGuardar y Volver'))

//Rechazar segunda oferta
WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnEvalEconomica2'))

for (int i = 1; i <= cantRenglones; i++) {
    WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/inpMotivoDescarte', [('variable') : i]), 'test')
}

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnGuardar y Volver'))


WebUI.check(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/chkRecomendar'))

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/txtJustAprobacion'), 'test')

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnSiguientePaso'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnFinalizar'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnIrAlEscritorio'))

