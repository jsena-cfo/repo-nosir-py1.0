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

import org.openqa.selenium.Keys as Keys
import java.sql.Connection as Connection
import java.sql.ResultSet as ResultSet
import com.katalon.plugin.keyword.connection.DBType as DBType
import com.katalon.plugin.keyword.connection.DatabaseKeywords as DatabaseKeywords
import com.katalon.plugin.keyword.connection.ResultSetKeywords as ResultSetKeywords


String rangoCuitMin = getBinding().getAt('varRangoCuitMin').toString()

String rangoCuitMax = getBinding().getAt('varRangoCuitMax').toString()

String dniMin= CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(rangoCuitMin)

String dniMax= CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(rangoCuitMax)

String nombreCuitMin= 'REGRESION' + dniMin.substring(4, 8)

String nombreCuitMax= 'REGRESION' + dniMax.substring(4, 8)

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

//String sql2 = 'SELECT * FROM slu.BUSUARIO_PORTAL bp WHERE bp.c_user LIKE ' + "'" + '%REGRE%' + "'" + ' AND bp.xc_user LIKE ' + "'" + '%' + nombreUsuario + '%' + "'"

String sql = CustomKeywords.'tool.SqlQueriesObsba.queryObtenerUsuarioSiguienteInsertado'(nombreCuitMin, nombreCuitMax)

System.out.println("SQL: " + sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean estaVacio = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

def mapData

mapData = [('1') : null, ('2') : null]

if (estaVacio== false) {
	
	String usuario= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'C_USER')

	String dni= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'N_DOCUMENTO')
	
	String usuarioFormateado= usuario.substring(1,14)
	
	String dniFormateado= dni.substring(1,9)
	
	System.out.println("Usuario BD: " + usuarioFormateado)
	
	System.out.println("Dni BD: " + dniFormateado)
	
	(mapData['1']) = usuarioFormateado
	
	(mapData['2']) = dniFormateado
	
}
println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

return mapData