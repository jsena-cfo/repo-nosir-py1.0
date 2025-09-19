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
import java.sql.SQLException as SQLException
import com.katalon.plugin.keyword.connection.DBType as DBType
import com.katalon.plugin.keyword.connection.DatabaseKeywords as DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords as ResultSetKeywords
import CustomKeywords as CustomKeywords
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration


String url= this.getBinding().getAt('varUrlVar').toString()

String numeroOca= this.getBinding().getAt('varNumeroOca').toString()

boolean updateHecho= false

//formato aaaa-MM-dd
String ayer= CustomKeywords.'tool.DateGenerator.yerterday'("aaaa-MM-dd")

def mapDB = [('varServer') : '', ('varPort') : '', ('varDBName') : '', ('varUser') : '', ('varPass') : '', ('varPassBase64') : '', ('varUrlDB') : '']

mapDB= WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerBDConfiguracion'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapDB: ' + mapDB)

Connection connection = null

ResultSet actorData

println('Connect database...')

//connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.sqlserver, '10.17.24.30', '1436', 'BAC_TEST', 'usrSEAC', 'u53r534c09')

//connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, varPort, varDBName, varUser, varPassBase64)

def profilename = RunConfiguration.getExecutionProfile()

//CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_Notificaciones, GlobalVariable.userDB, GlobalVariable.passDB)

//CustomKeywords.'tool.sqlServerDB.conectarDB'((mapDB['varUrlDB']), (mapDB['varUser']), (mapDB['varPass']))

CustomKeywords.'tool.sqlServerDB.conectarDB'('10.17.24.30,1436\\BAC_TEST', 'usrSEAC', 'u53r534c09')

String sql

sql = CustomKeywords.'tool.SqlQueriesBac.queryUpdateFechaCreacion'(numeroOca, ayer)

//queryBCiudad = "SELECT * FROM [API_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 113 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"

System.out.println('SQL: ' + sql)

/**Sql Server usa executeUpdate**/
//actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

actorData = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(sql)

sql = CustomKeywords.'tool.SqlQueriesBac.queryUpdateFechaInicio'(numeroOca, ayer)

System.out.println('SQL: ' + sql)

/**Sql Server usa executeUpdate**/
actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

updateHecho= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

return updateHecho


