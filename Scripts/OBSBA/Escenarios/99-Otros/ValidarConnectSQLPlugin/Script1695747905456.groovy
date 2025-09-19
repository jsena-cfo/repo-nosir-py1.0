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

import java.sql.Connection
import java.sql.ResultSet

import com.katalon.plugin.keyword.connection.DBType
import com.katalon.plugin.keyword.connection.DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords
//import com.kms.katalon.core.configuration.RunConfiguration
//import com.katalon.plugin.keyword.connection.ResultSetKeywords
//import com.katalon.plugin.keyword.connection

//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(oracle, null, null, null, null, null)

Connection connection = null;

ResultSet actorData;

/**
String server= 'localhost'
String port= '1521'
String dbName= 'XE'
String userName= 'system'
String password= 'YWRtaW4='
**/

String server= 'oradbpreprod02.hacienda-gcba.gov.ar'
String port= '1521'
String dbName= 'OSBAPRE'
String userName= 'USU_OBSBA'
String password= 'OBSBA2022'
//encode password to Base64: https://www.base64encode.org/
String passwordBase64= 'T0JTQkEyMDIy'

//CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords'
println 'Connect database...'
connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, server, port, dbName, userName, passwordBase64)

String sql

//sql= "SELECT * FROM slu.busuario a WHERE a.c_user LIKE '%REGRE%' AND a.xc_user LIKE '%REGRESION4075%'"

sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBUsuarioNombreUsuario'('REGRE', 'REGRESION4075')
//sql= "SELECT * FROM tblActor"

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

'Example: check result set is empty' 
println 'Check result set is empty: ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

'Example: Export a result set to csv file'
//CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.exportToCSV'(actorData, RunConfiguration.getProjectDir() +"/OutPut Files/oracle_actor.csv")

'Example: Get total of rows from a result set'
println 'Get total of rows from a result set ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getRowCount'(actorData)

'Example: Get total of coulmns from a result set'
println 'Get total of coulmns from a result set ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getColumnCount'(actorData)

'Example: Get first row value'
println 'Get first row: value: ' + CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListRowValue'(actorData,1,1)

'Example: Get list of row value using row '
println 'Get list of row value using row: '
println  CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList'(actorData)

println 'Disconnect DB...'
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

