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
import java.sql.SQLException
import com.katalon.plugin.keyword.connection.DBType as DBType
import com.katalon.plugin.keyword.connection.DatabaseKeywords as DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords as ResultSetKeywords

/**Author: JER**/
/**Se conecta a BD SQL Server (no Oracle) y 
 * carga un recibo para un empelado*/

String cuil= this.getBinding().getAt('varCuil').toString()

Connection connection = null

def actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.sqlserver, varServer,
	varPort, varDBName, varUser, varPassBase64)

String sql 

//sql= CustomKeywords.'tool.SqlQueriesObsba.queryGenerarReciboEmpleadoCuil'(cuil)
String pathFile= 'salary/destino/27295011217/27295011217-SEP-2022-0.pdf'
String numMes= CustomKeywords.'adicionales.NumberRandomGenerator.generarMesRandomAleatorio'().toString()
String anio= '2022'
sql= CustomKeywords.'tool.SqlQueriesObsba.queryGenerarReciboEmpleadoCuilParam'(cuil, pathFile, numMes, anio)

System.out.println('SQL: ' + sql)

/**Sql Server usa executeUpdate**/
actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, sql)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

//return mapDatos

