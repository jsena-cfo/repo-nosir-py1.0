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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

String excelFilePath = this.getBinding().getAt('varPathXls').toString()
String sheetName= this.getBinding().getAt('varHoja').toString()

Map datos = this.getBinding().getAt('varDatos')

workbook= ExcelKeywords.getWorkbook(excelFilePath)
sheet= ExcelKeywords.getExcelSheet(workbook, sheetName)

int filaSiguiente= (ExcelKeywords.getExcelSheet(workbook, sheetName).getLastRowNum()) + 1

System.out.println("***Hoja: " + sheetName)
System.out.println("***Fila siguiente xls: " + filaSiguiente.toString())

switch(sheetName) {
	case "Hoja1SG":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  String diaDosSemanasDesdeHoy= CustomKeywords.'tool.DateGenerator.dateNWeeksLaterToday'(2)	
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroSolicitud'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, diaHoy)
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 2, diaDosSemanasDesdeHoy)
	  break
	case "Hoja2PC":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
      ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroSolicitud'))
      ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, datos.getAt('numeroContratacion'))
      ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 2, diaHoy)
	  break
	case "Hoja3AC":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroContratacion'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, datos.getAt('numeroActa'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 2, diaHoy)
	  break
	case "Hoja4DE":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroContratacion'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, datos.getAt('numeroActa'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 2, datos.getAt('numeroDictamen'))
 	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 3, diaHoy)
	  break
	case "Hoja5FC35":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroContratacion'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, datos.getAt('numeroFormC35'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 2, diaHoy)
	  break
	case "Hoja6OCEN":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroOrden'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, diaHoy)
	  break
	case "Hoja7OCRE":
	  String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 0, datos.getAt('numeroOrden'))
	  ExcelKeywords.setValueToCellByIndex(sheet, filaSiguiente, 1, diaHoy)
	  break
  }
ExcelKeywords.saveWorkbook(excelFilePath, workbook)
