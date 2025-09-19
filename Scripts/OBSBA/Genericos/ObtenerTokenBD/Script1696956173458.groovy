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

import com.katalon.plugin.keyword.connection.DatabaseKeywords as DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords as ResultSetKeywords
import com.katalon.plugin.keyword.connection.DBType as DBType

/**Author: JER**/
/**El password de la BD debe estar encoding en Base64**/
/**encode password to Base64: https://www.base64encode.org**/

Connection connection = null

ResultSet actorData

println('Connect database...')

String cuil= this.getBinding().getAt('varUsuario').toString()

String cuilSinBlancos = cuil.replaceAll('\\s', '')

String cuilSinGuiones = cuilSinBlancos.replaceAll('-', '')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, 
    varPort, varDBName, varUser, varPassBase64)

String sql 
//-sql= 'SELECT * FROM (SELECT * FROM slu.bdocumento INNER JOIN slu.busuario_portal ON bdocumento.o_usuario = busuario_portal.o_usuario WHERE busuario_portal.n_documento = ' + varUsuario + ' ORDER BY bdocumento.fh_alta DESC) WHERE ROWNUM = 1'

//-sql= 'SELECT * FROM( SELECT * FROM slu.bdocumento WHERE bdocumento.r_ruta LIKE ' + "'" + '%null%' + "'" + ') WHERE ROWNUM = 1'

//-sql= 'SELECT a.c_guid FROM slu.busuario_portal a WHERE a.n_documento= ' + cuilSinGuiones

//sql= 'SELECT * FROM (SELECT a.c_guid FROM slu.busuario_portal a WHERE a.n_documento= ' + cuilSinGuiones + ' ORDER BY a.fh_alta DESC) WHERE ROWNUM = 1'

sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerUsuarioCuilSinGuiones'(cuilSinGuiones)

'Example: Consulta'
println (sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean vacio= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(
        actorData)

'Example: check result set is empty'
println('Check result set is empty: ' + vacio.toString())

'Example: Valor campo CGUID'
String token= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'C_GUID')
println('Valor token: ' + token)

//String tokenReplace= token.replaceAll('[','')
//String tokenReplace2= tokenReplace.replaceAll(']','')

String tokenReplace2= token.substring(1,5)

boolean hayToken= false

if (!vacio) {
	println('No es vacio Valor token: ' + tokenReplace2)
	hayToken= true
}
else {
	println('Vacio')
}

'Example: Get list of row value using row '
println('Get list of row value using row: ')

println(CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList'(actorData))

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

assert hayToken

return tokenReplace2
