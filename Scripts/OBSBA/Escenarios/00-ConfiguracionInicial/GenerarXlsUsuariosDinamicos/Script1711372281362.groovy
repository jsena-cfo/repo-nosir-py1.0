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

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook


int desdeCuit = getBinding().getAt('varGenerarDesde')

int hastaCuit = getBinding().getAt('varGenerarHasta')

String home= CustomKeywords.'tool.UploadFile.pathHome'()

String dirName= CustomKeywords.'tool.UploadFile.pathRelativeProject'()

//String path = 'C:\\Devs\\Projects\\Katalon\\NOSIR\\Xls\\obsba\\usersSigafXls\\usuariosTmpPre.xlsx'

String path= dirName + '/Xls/obsba/usersSigafXls/usuariosDinamicos.xlsx'

System.out.println("Home: " + home)

System.out.println("Relative path: " + dirName)

System.out.println("Relative path conformado: " + path)

/* open connection to MS Excel, save surname to sheet 1, cell A2, close connection */
FileInputStream fis = new FileInputStream(path)

XSSFWorkbook workbook = new XSSFWorkbook(fis)

XSSFSheet sheet = workbook.getSheet('dinamicos')

for(int i in 1..15) {
	// cell A2
	Row row = sheet.createRow(i)
	
	'Columna UserSigaf'
	
	Cell cell = row.createCell(0)
	
	cell.setCellType(cell.CELL_TYPE_STRING)
	
	String nombreUsuario= CustomKeywords.'adicionales.NombresRandomGenerator.generarNombreDesdeCuit'(desdeCuit.toString())
	
	System.out.println("Valor UserSigaf: " + nombreUsuario)
	
	cell.setCellValue(nombreUsuario)
	
	'Columna Dni'
	
	Cell cell = row.createCell(1)
	
	String dni= CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(desdeCuit.toString())
	
	System.out.println("Valor Dni: " + dni)
	
	cell.setCellType(cell.CELL_TYPE_STRING)
	
	cell.setCellValue(dni)
	
	'Columna CUIT'
	
	Cell cell = row.createCell(2)
	
	String cuitConGuiones= CustomKeywords.'adicionales.CuilRandomGenerator.agregarGuionesCuil'(desdeCuit.toString())
	
	System.out.println("Valor Cuit: " + cuitConGuiones)
	
	cell.setCellType(cell.CELL_TYPE_STRING)
	
	cell.setCellValue(cuitConGuiones)
	
	desdeCuit= desdeCuit + 1
	
	/**
	// cell A2
	Row row = sheet.createRow(1);
	Cell cell = row.createCell(0)
	
	// cell A6
	row = sheet.createRow(5);
	cell = row.createCell(0)
	
	// cell A10
	row = sheet.createRow(9);
	cell = row.createCell(0)
	**/
 }
 
FileOutputStream fos = new FileOutputStream(path)

workbook.write(fos)

fos.close()

fis.close()