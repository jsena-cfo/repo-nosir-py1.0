import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.*


/*
WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

String numeroInterno = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '103'
        , ('varY') : '124', ('varW') : '79', ('varH') : '14'], FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero interno OCR: ' + numeroInterno)

*/

def pathEjecucion = System.getProperty('user.dir')
def pathExcel = pathEjecucion + '\\Xls\\Datos de ingreso Deuda Flotante.xlsx'
def pathRelativo = pathExcel.replace('\\', '\\\\')

workbook = ExcelKeywords.getWorkbook(pathExcel)

sheet = ExcelKeywords.getExcelSheet(workbook, 'Hoja1')

def rowActual = row.toInteger()
/*
Screen screen = new Screen()

def encontroError = CustomKeywords.'tool.sikuli.existeImg'(screen, 'errorSemaforo.png', 'ObsbaCarga', 1)

if (encontroError) {
	
	ExcelKeywords.setValueToCellByIndex(sheet, rowActual, 6, 'Error')

	throw new com.kms.katalon.core.exception.StepFailedException()
	
}
else {
	ExcelKeywords.setValueToCellByIndex(sheet, rowActual, 6, 'Ingresado')		
}
*/
ExcelKeywords.setValueToCellByIndex(sheet, rowActual, 6, 'Ingresado')

ExcelKeywords.saveWorkbook(pathExcel, workbook)


