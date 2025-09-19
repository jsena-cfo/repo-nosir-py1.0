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



String usuario= "'" + this.getBinding().getAt('varUsuario').toString() + "'"

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

String sql

//sql= "INSERT INTO SLU.AUSUARIO_ROL(C_USER, C_ROL_USUARIO, FH_BAJA, FH_ALTA, FHU_ACTUALIZ, C_USUARIO) VALUES(" + usuario + ", 'OSBA_PERSONA_ADMIN', NULL, TIMESTAMP '2023-07-31 10:33:06.000000', TIMESTAMP '2023-07-31 10:33:06.000000', 'DEPLOY')"

sql= CustomKeywords.'tool.SqlQueriesObsba.queryInsertarAdministrador'(usuario)

System.out.println("Sql: " + sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

String sqlConsulta

//sqlConsulta= "SELECT * FROM SLU.AUSUARIO_ROL a WHERE a.c_user LIKE " + usuario

sqlConsulta= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerUsuarioAdministrador'(usuario)

System.out.println("Sql: " + sqlConsulta)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sqlConsulta)

boolean vacio= false
boolean seInserto= false

vacio= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(
	actorData)

if (vacio) {
	System.out.println("No se pudo insertar administrador")
	}
else {
	String value= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'C_USER')
	
	System.out.println("Se pudo insertar administrador")
	seInserto= true
}

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

assert (seInserto)