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


String url = getBinding().getAt('varUrlVar').toString()

String numeroOca = getBinding().getAt('varNumeroOca').toString()

boolean updateHecho = false

//formato aaaa-MM-dd
String ayer= CustomKeywords.'tool.DateGenerator.yerterday'('yyyy-MM-dd')

//'2025-06-30 00:00:00.000'
String ayerCeroHora= ayer + ' 00:00:00.000'

//'2025-06-30 12:00:00.000'
String ayerMediodia= ayer + ' 12:00:00.000'

System.out.println("Ayer: " + ayer.toString())

System.out.println("Ayer Cero Hora: " + ayerCeroHora.toString())

System.out.println("Ayer Mediodia: " + ayerMediodia.toString())

//def mapDB = [('varServer') : '', ('varPort') : '', ('varDBName') : '', ('varUser') : '', ('varPassBase64') : '']

//mapDB = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ObtenerBDConfiguracion'), [('varUrl') : url], 
//    FailureHandling.STOP_ON_FAILURE)

//System.out.println('MapDB: ' + mapDB)

Connection connection = null

ResultSet actorData

println('Connect database...')


def profilename = RunConfiguration.getExecutionProfile()

//CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

//CustomKeywords.'tool.sqlServerDB.conectarDBSecure'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

//connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, varPort, varDBName, varUser, varPassBase64)

String sql1 = CustomKeywords.'tool.SqlQueriesBac.queryUpdateFechaCreacion'(numeroOca, ayerCeroHora)

System.out.println('SQL1: ' + sql1)

/**Sql Server usa executeUpdate**/
//actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

CustomKeywords.'tool.sqlServerDB.ejecutarUpdate'(sql1)

String sql2 = CustomKeywords.'tool.SqlQueriesBac.queryUpdateFechaInicio'(numeroOca, ayerMediodia)

System.out.println('SQL1: ' + sql2)

/**Sql Server usa executeUpdate**/
//actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

CustomKeywords.'tool.sqlServerDB.ejecutarUpdate'(sql2)

//updateHecho = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

println('Disconnect DB...')

//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()

//return updateHecho

