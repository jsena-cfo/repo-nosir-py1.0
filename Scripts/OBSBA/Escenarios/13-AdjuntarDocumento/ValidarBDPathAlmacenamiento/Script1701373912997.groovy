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

import java.sql.Connection as Connection
import java.sql.ResultSet as ResultSet
import com.katalon.plugin.keyword.connection.DBType as DBType
import com.katalon.plugin.keyword.connection.DatabaseKeywords as DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords as ResultSetKeywords



/**Author: JER**/
/**Valida que el ultimo documento subido por un usuario tenga el path de documentos con el formato correcto**/
/**El password de la BD debe estar encoding en Base64**/
/**encode password to Base64: https://www.base64encode.org**/

String numeroCarpeta= this.getBinding().getAt('varNumeroCarpeta').toString()

String cuil= this.getBinding().getAt('varCuil').toString()

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

String sql

/**
String partSql1= 'SELECT b.O_DOCUMENTO , b.fh_alta, t.O_USUARIO , t.O_CARPETA, t.O_USUARIO, t.O_CARPETA, b.R_RUTA '
String partSql2= 'FROM slu.BDOCUMENTO b '
String partSql3= 'INNER JOIN slu.ACARPETA_DOCUMENTO ad ON ad.O_DOCUMENTO = b.O_DOCUMENTO '
String partSql4= 'INNER JOIN slu.TCARPETA t ON t.O_CARPETA = ad.O_CARPETA '
String partSql5= 'INNER JOIN slu.busuario_portal p ON p.O_USUARIO= t.O_USUARIO '
String partSql6= 'WHERE t.O_CARPETA= ' + numeroCarpeta + 'AND p.n_documento= ' + cuil + ' '
String partSql7= 'ORDER BY b.fh_alta DESC'
	
sql= partSql1 + partSql2 + partSql3 + partSql4 + partSql5 + partSql6 + partSql7
**/

sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBDocumentoParaCarpetaCuil'(numeroCarpeta, cuil)

System.out.println("SQL: " + sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

'Example: check result set is empty'
println('Check result set is empty: ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(
		actorData))

'Example: Valor campo Ruta'
String ruta= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'R_RUTA')
println('Valor ruta: ' + ruta)

String idUsuario= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'O_USUARIO')
println('Valor idUsuario: ' + idUsuario)

String odocumento= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'O_DOCUMENTO')
println('Valor odocumento: ' + odocumento)

//String idUsuarioSinCorchetes= idUsuario.substring(1,5)

String idUsuarioSinCorchetes= CustomKeywords.'tool.StringCK.quitarCorchetes'(idUsuario)

System.out.println("idUsuarioSinCorchetes: " + idUsuarioSinCorchetes)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

String odocumentoSinComillas= CustomKeywords.'tool.StringCK.quitarCorchetes'(odocumento)

String nombreArchivo= 'carta_onu-' + odocumentoSinComillas + '.pdf'

String rutaComparable= 'users/' + idUsuarioSinCorchetes + '/' + numeroCarpeta + '/files/' + nombreArchivo

String pathFormateado= CustomKeywords.'tool.StringCK.reemplazarSubstring'(rutaComparable, "\\\\", "/")


String rutaSinComillas= CustomKeywords.'tool.StringCK.quitarCorchetes'(ruta)

System.out.println("Ruta: " + rutaSinComillas)

System.out.println("Ruta comparable: " + rutaComparable)

System.out.println("Ruta Formateada: " + pathFormateado)
boolean validar= false

//if (rutaSinComillas.contains(rutaComparable)) {
if (rutaSinComillas.contains(pathFormateado)) {
	validar= true
}
else {
	validar= false
}

return validar