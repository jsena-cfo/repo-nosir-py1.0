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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

//String excelFilePath = getBinding().getAt('varPathXls').toString()

//String sheetName = getBinding().getAt('varHoja').toString()

//Map datos = this.getBinding().getAt('varDatos')
//workbook = ExcelKeywords.getWorkbook(excelFilePath)

//sheet = ExcelKeywords.getExcelSheet(workbook, sheetName)

//ExcelKeywords.getExcelSheet(workbook, sheetName).getRow(arg0)
//int filaSiguiente = ExcelKeywords.getExcelSheet(workbook, sheetName).getLastRowNum() + 1

//TestData data = findTestData('prueba01')

//TestData data = findTestData('Data Files/prueba01')
TestData data = findTestData('Data Files/inputFCdeudasFlotantes')

int cantidadFilasXls = data.getRowNumbers()

System.out.println("Cantidad filas xls: " + cantidadFilasXls)

def mapGlobal= [:]

String valIndex

for (int index in 1..cantidadFilasXls) {
	def mapFilas= [:]
	
	mapFilas = ['1' : data.getValue(1, index), '2' : data.getValue(2, index), 
		        '3' : data.getValue(3, index), '4' : data.getValue(4, index), 
				'5' : data.getValue(5, index), '6' : data.getValue(6, index), 
				'7' : data.getValue(7, index), '8' : data.getValue(8, index),
				'9' : data.getValue(9, index), '10' : data.getValue(10, index),
				'11' : data.getValue(11, index), '12' : data.getValue(12, index),
				'13' : data.getValue(13, index), '14' : data.getValue(14, index),
				'15' : data.getValue(15, index)]

	valIndex = index.toString().trim()
	
	System.out.println("Indice: " + valIndex)

	//mapGlobal = [index: valIndex, filas: mapFilas]
	
	mapGlobal[valIndex]= mapFilas
	
	

}

return mapGlobal

