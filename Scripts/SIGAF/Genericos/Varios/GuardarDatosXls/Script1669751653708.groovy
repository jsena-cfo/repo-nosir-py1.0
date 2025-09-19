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
String sheetName = 'Hoja1'
Map datos = this.getBinding().getAt('varDatos')

workbook01 = ExcelKeywords.getWorkbook(excelFilePath)
sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)

int filaSiguiente= (ExcelKeywords.getExcelSheet(workbook01, sheetName).getLastRowNum()) + 1

System.out.println("***Fila siguiente xls: " + filaSiguiente.toString())

String diaHoy= CustomKeywords.'tool.DateGenerator.today'().toString()
//String diaDosSemanasDesdeHoy= CustomKeywords.'tool.DateGenerator.dateNWeeksLaterToday'(2)

ExcelKeywords.setValueToCellByIndex(sheet01, filaSiguiente, 0, datos.getAt('numeroContratacion'))
ExcelKeywords.setValueToCellByIndex(sheet01, filaSiguiente, 1, datos.getAt('numeroActa'))
ExcelKeywords.setValueToCellByIndex(sheet01, filaSiguiente, 2, diaHoy)
//ExcelKeywords.setValueToCellByIndex(sheet01, filaSiguiente, 2, diaDosSemanasDesdeHoy)
ExcelKeywords.saveWorkbook(excelFilePath, workbook01)
