import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


/*
WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

String numeroInterno = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '103'
        , ('varY') : '124', ('varW') : '79', ('varH') : '14'], FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero interno OCR: ' + numeroInterno)

*/

def pathEjecucion = System.getProperty('user.dir')
def pathExcel = pathEjecucion + '\\Xls\\obsba\\IngresoFondoCompensador.xlsx'
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
ExcelKeywords.setValueToCellByIndex(sheet, rowActual, 11, 'Ingresado')

ExcelKeywords.saveWorkbook(pathExcel, workbook)


