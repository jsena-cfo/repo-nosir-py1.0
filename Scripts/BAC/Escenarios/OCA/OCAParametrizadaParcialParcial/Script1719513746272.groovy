@Grab(module = 'poi-ooxml', version = '5.2.3', group = 'org.apache.poi')
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.ss.usermodel.DateUtil as DateUtil
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.Cell as Cell
import java.io.FileInputStream as FileInputStream
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def pathHome = System.getProperty('user.home')

def pathEjecucion = pathHome + '\\Documents\\OCA\\inputOCA.xlsx'

def profilename = RunConfiguration.getExecutionProfile()

def cuerpoMail

if(profilename == 'BAC_TEST') {
	cuerpoMail = '\n<html>\n<body>\n<p>Estimados</b>.</p>\n<p>Se ha generado la siguiente data de ejecución en el ambiente de Test:</p>\n'

}
else if(profilename == 'BAC_QA'){
	cuerpoMail = '\n<html>\n<body>\n<p>Estimados</b>.</p>\n<p>Se ha generado la siguiente data de ejecución en el ambiente de QA:</p>\n'
}

else if(profilename == 'BAC_PRE'){
	cuerpoMail = '\n<html>\n<body>\n<p>Estimados</b>.</p>\n<p>Se ha generado la siguiente data de ejecución en el ambiente de Preprod:</p>\n'
}


def rowCount = countRowsWithContent(pathEjecucion)

for (int i = 1; i < rowCount; i++) {
    WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.userSolicitante, ('password') : GlobalVariable.passSolicitante], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], 
        FailureHandling.STOP_ON_FAILURE)

    String nroCompra = WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarDatosBasicosPC-OCA'), [
            ('nombrePC') : 'QA Test'], FailureHandling.STOP_ON_FAILURE)

    KeywordUtil.logInfo('Proceso de compra: ' + nroCompra)

    GlobalVariable.nroPC = nroCompra

    def esRedeterminable = getCellValue(pathEjecucion, 'Redeterminable', i)

    println(esRedeterminable)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarInfoBasicaPC'), [('cantDias') : '20', ('tipoDeDias') : 'Días corridos'
            , ('direccion') : 'Otra dirección', ('procedimiento') : 'Licitación Pública', ('adjCantidad') : 'Parcial', ('adjRenglones') : 'Parcial'
            , ('cotizCantidad') : 'Parcial', ('cotizRenglones') : 'Parcial', ('redeterminable') : esRedeterminable], FailureHandling.STOP_ON_FAILURE)

    def item1 = getCellValue(pathEjecucion, 'Item1', i)

    def item2 = getCellValue(pathEjecucion, 'Item2', i)

    def cant1 = ((getCellValue(pathEjecucion, 'Cantidad1', i)) as int)

    def cant2 = ((getCellValue(pathEjecucion, 'Cantidad2', i)) as int)

    def precio1 = ((getCellValue(pathEjecucion, 'Precio1', i)) as int)

    def precio2 = ((getCellValue(pathEjecucion, 'Precio2', i)) as int)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/DetalleDeProductosOServicios'), [('codigoDeItem') : item1
            , ('embalaje') : '15', ('cantidad') : cant1.toString(), ('precio') : precio1.toString()], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/DetalleDeProductosOServicios'), [('codigoDeItem') : item2
            , ('embalaje') : '15', ('cantidad') : cant2.toString(), ('precio') : precio2.toString()], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarRequisitosMinimosPC'), [('RequisitosEconomicoYFinaciero') : 'Test QA'
            , ('RequisitosTecnicos') : 'Test QA', ('RequisitosAdministrativos') : 'Test QA'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarClausulasPC'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarGarantias'), [('porcGarantiaImpugnacion') : '1'
            , ('porcPreAdjudicacion') : '4', ('garMantOferta') : 'No', ('garantiaCumplimientoContrato') : 'No', ('contraGarantia') : 'No'
            , ('procedimiento') : 'Licitación Pública'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/MontoyDuracionDeContratoPC-OCA'), [('monto') : '12'
            , ('duracion') : '12', ('tiempo') : 'Meses'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarIndiceEvaluadoresPC'), [('tipoDoc') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
            , ('anio') : '2015', ('numero') : '3572206', ('reparticion') : 'MGEYA'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/AlcanceYPeriocidadSPR'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarSustentabilidad'), [('requisitoSustentabilidad') : 'No'
            , ('tipoRecomendaciones') : 'Ambientales', ('logisticaInversaOMinima') : 'No', ('embalajeReciclable') : 'No'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/EnviarASupervisor'), [('nombreSupervisor') : 'Emilse Carmen Filippo'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminAutorizacion'), [('documento') : 'Declaración Jurada Incompatibilidad C. Evaluadora'
            , ('anio') : '2015', ('reparticion') : 'MGEYA', ('numero') : '3572206', ('nroProcesoCompra') : GlobalVariable.nroPC
            , ('user') : GlobalVariable.userAutorizador, ('pass') : GlobalVariable.passAutorizador], FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarCronograma - Copy'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/CompletarActoAdminLlamado'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Escenarios/OCA/GenerarPreAdjParcialParcialOCA'), [('cantidad') : cant1.toString()], FailureHandling.STOP_ON_FAILURE)

    String nroOrdenCompra = WebUI.callTestCase(findTestCase('BAC/Escenarios/OCA/GenerarAdjudicacionOCA'), [:], FailureHandling.STOP_ON_FAILURE)

    writeExcelCell(pathEjecucion, 'Numero OCA', i, nroCompra)

    writeExcelCell(pathEjecucion, 'Numero PC', i, nroOrdenCompra)

    cuerpoMail = (cuerpoMail + "<p>$i. Número de proceso de compra: <b>$nroCompra</b> - Número orden de compra: <b>$nroOrdenCompra</b></p>")
}

cuerpoMail = (cuerpoMail + '</p>Saludos.<br></br></body></html>')

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/EnvioMail'), [('destinatario') : ["jsiebenberg@cfotechlatam.com", "qaautomation@dguiaf-gcba.gov.ar"], ('asunto') : 'Ejecución remota'
        , ('cuerpoMail') : cuerpoMail], FailureHandling.STOP_ON_FAILURE )


def countRowsWithContent(String filePath) {
    FileInputStream fis = new FileInputStream(filePath)

    XSSFWorkbook workbook = new XSSFWorkbook(fis)

    def sheet = workbook.getSheetAt(0)

    int rowCount = 0

    for (Row row : sheet) {
        boolean hasContent = row.cellIterator().any({ def cell ->
                cell.toString().trim()
            })

        if (hasContent) {
            rowCount++
        }
    }
    
    workbook.close()

    fis.close()

    return rowCount
}

def getCellValue(String excelFilePath, String columnName, int rowIndex) {
    def inputStream = new FileInputStream(excelFilePath)

    def workbook = new XSSFWorkbook(inputStream)

    def sheet = workbook.getSheetAt(0)

    int columnIndex = -1

    def headerRow = sheet.getRow(0)

    headerRow.eachWithIndex({ def cell, def index ->
            if (cell.getStringCellValue() == columnName) {
                columnIndex = index
            }
        })

    if (columnIndex == -1) {
        throw new IllegalArgumentException("No se encontró la columna con el nombre: $columnName")
    }
    
    def row = sheet.getRow(rowIndex)

    def cell = row.getCell(columnIndex)

    def cellValue = null

    if (cell != null) {
        try {
            cellValue = cell.getStringCellValue()
        }
        catch (Exception e1) {
            try {
                cellValue = cell.getNumericCellValue()

                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue()
                }
            }
            catch (Exception e2) {
                try {
                    cellValue = cell.getBooleanCellValue()
                }
                catch (Exception e3) {
                    cellValue = cell.getCellFormula()
                } 
            } 
        } 
    }
    
    inputStream.close()

    workbook.close()

    return cellValue
}

def writeExcelCell(String filePath, String columnName, int rowIndex, def value) {
    FileInputStream fileInputStream = new FileInputStream(new File(filePath))

    Workbook workbook = new XSSFWorkbook(fileInputStream)

    Sheet sheet = workbook.getSheetAt(0)

    int columnIndex = -1

    Row headerRow = sheet.getRow(0)

    if (headerRow != null) {
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                columnIndex = cell.getColumnIndex()

                break
            }
        }
    }
    
    if (columnIndex == -1) {
        throw new IllegalArgumentException('Columna no encontrada: ' + columnName)
    }
    
    Row row = sheet.getRow(rowIndex)

    if (row == null) {
        row = sheet.createRow(rowIndex)
    }
    
    Cell cell = row.getCell(columnIndex)

    if (cell == null) {
        cell = row.createCell(columnIndex)
    }
    
    if (value instanceof String) {
        cell.setCellValue(value.toString())
    } else {
        throw new IllegalArgumentException('Tipo de valor no soportado: ' + value.getClass().getName())
    }
    
    fileInputStream.close()

    FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))

    workbook.write(fileOutputStream)

    workbook.close()

    fileOutputStream.close()
}

