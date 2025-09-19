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
/**El password de la BD debe estar encoding en Base64**/
/**encode password to Base64: https://www.base64encode.org**/
/**Valida el path de un doc que contiene null**/

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, 
    varPort, varDBName, varUser, varPassBase64)

String sql

//sql= 'SELECT * FROM( SELECT * FROM slu.bdocumento WHERE bdocumento.r_ruta LIKE ' + "'" + '%null%' + "'" + ') WHERE ROWNUM = 1'

sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBDocumentoNull'()

'Example: Consulta'
println (sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean sinResultados= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(
        actorData)

'Example: check result set is empty'
println('Check result set is empty: ' + sinResultados.toString())

'Example: Valor campo Ruta'
String ruta= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'R_RUTA')
println('Valor ruta: ' + ruta)

'Example: Valor campo Fecha'
String fechaAlta= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'FH_ALTA')
println('Valor fecha alta: ' + fechaAlta)

boolean contieneNull= false

if (ruta != null) {
	if (ruta.indexOf('null') == -1) {
		println('Ruta no contiene null')
	}
	else {
		println('Ruta contiene null')
		contieneNull= true
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

assert contieneNull
