package tool

import com.kms.katalon.core.annotation.Keyword
import java.io.File;
import org.apache.poi.ss.usermodel.*;


public class Excel {
	@Keyword
	def getFirstEmptyCell(String filePath, String sheetName, int columnIndex) {

		FileInputStream fis = new FileInputStream(filePath)
		Workbook workbook = WorkbookFactory.create(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		int rowNumber = 0
		Row row = sheet.getRow(rowNumber)
		Cell cell = row.getCell(columnIndex)

		while (cell != null) {
			rowNumber++
			row = sheet.getRow(rowNumber)
			if (row != null) {
				cell = row.getCell(columnIndex)
			} else {
				cell = null
			}
		}
		//println("La primera columna vacia en columna " + columnIndex + " es en la fila " + rowNumber);
		workbook.close()
		fis.close()
		return rowNumber
	}

	@Keyword
	def SetValueInCell(String filePath,String sheetName, int columnIndex , int rowIndex, String value) {
		FileInputStream fis = new FileInputStream(filePath)
		Workbook workbook = WorkbookFactory.create(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		Row row = sheet.getRow(rowIndex)
		Cell cell = row.getCell(columnIndex)
		if (cell == null) {
			cell = row.createCell(columnIndex);
		}

		cell.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(filePath)
		workbook.write(fos)
		fos.close()
		workbook.close()
	}
}
