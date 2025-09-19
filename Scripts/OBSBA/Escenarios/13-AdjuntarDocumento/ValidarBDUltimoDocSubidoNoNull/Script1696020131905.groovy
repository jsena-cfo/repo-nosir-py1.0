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
/**Valida que el ultimo documento subido por un usuario no contenga null en su ruta**/
/**El password de la BD debe estar encoding en Base64**/
/**encode password to Base64: https://www.base64encode.org**/

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, 
    varPort, varDBName, varUser, varPassBase64)

String sql

//sql= 'SELECT * FROM (SELECT * FROM slu.bdocumento INNER JOIN slu.busuario_portal ON bdocumento.o_usuario = busuario_portal.o_usuario WHERE busuario_portal.n_documento = ' + varUsuario + ' ORDER BY bdocumento.fh_alta DESC) WHERE ROWNUM = 1'

sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBDocumentoUltimoCargadoUsuario'(varUsuario)

'Example: Consulta'
println (sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

'Example: check result set is empty'
println('Check result set is empty: ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(
        actorData))

'Example: Export a result set to csv file'

//CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.exportToCSV'(actorData, RunConfiguration.getProjectDir() +"/OutPut Files/oracle_actor.csv")
'Example: Get total of rows from a result set'
println('Get total of rows from a result set ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getRowCount'(
        actorData))

'Example: Get total of columns from a result set'
println('Get total of coulmns from a result set ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getColumnCount'(
        actorData))

'Example: Get first row value'
println('Get first row value: ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListRowValue'(
        actorData, 1, 1))

'Example: Valor campo Ruta'
String ruta= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'R_RUTA')
println('Valor ruta: ' + ruta)

'Example: Valor campo Fecha'
String fechaAlta= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'FH_ALTA')
println('Valor fecha alta: ' + fechaAlta)

boolean validacion= false

if (ruta != null) {
	if (ruta.indexOf('null') == -1) {
		println('Ruta no contiene null')
		validacion= true
	}
	else {
		println('Ruta contiene null')
	}
}
else {
	println('Ruta es null')
}

'Example: Get list of row value using row '
println('Get list of row value using row: ')

println(CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList'(actorData))

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

assert validacion
