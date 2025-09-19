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
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook

/**Author: Jer**/
String tipo = getBinding().getAt('varTipo').toString()

String strUrl = getBinding().getAt('varUrl').toString()

String numero

String dirName = CustomKeywords.'tool.UploadFile.pathRelativeProject'()

//String path2 = "C:\\Devs\\Projects\\Katalon\\NOSIR\\Xls\\obsba\\usersSigafXls\\usuariosTmpPre.xlsx"
String path

String pathXls

//pathXls= WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerPathXlsTmpEntornoSPR'), [('varUrl') : strUrl, ('varTipo') : 'SPR'], FailureHandling.STOP_ON_FAILURE)

pathXls= WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerPathXlsTmpEntornoSPR'), [('varUrl') : strUrl, ('varTipoXls') : 'numeros'],
	FailureHandling.STOP_ON_FAILURE)

path = (dirName + pathXls)

System.out.println('Path leido: ' + dirName)

FileInputStream fis = new FileInputStream(path)

XSSFWorkbook workbook = new XSSFWorkbook(fis)

XSSFSheet sheet = workbook.getSheet(tipo)

// cell A2
Row row = sheet.getRow(1)

Cell cell = row.getCell(0)

numero = cell.getStringCellValue()

fis.close()

return numero

