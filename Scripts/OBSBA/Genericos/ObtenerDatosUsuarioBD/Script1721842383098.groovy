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


String cuil= this.getBinding().getAt('varCuil').toString()

String rol= this.getBinding().getAt('varRol').toString()

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

String sql = CustomKeywords.'tool.SqlQueriesObsba.queryObtenerDatosUsuarioCuilRol'(cuil, rol)

System.out.println('SQL: ' + sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean noObtuvo = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

System.out.println('No hubo resultados: ' + noObtuvo.toString())

//String lista

Map mapDatos= [('cuil') : 'No aplica', ('usuario') : 'No aplica', ('usuarioNombre') : 'No aplica', ('perfil') : 'No aplica',
	('mail') : 'No aplica', ('domicilio') : 'No aplica', ('fechaAlta') : 'No aplica']

if (noObtuvo == false) {
	//listaTmp = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList'(actorData)
	
	(mapDatos['cuil'])= cuil
	
	String usuarioVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'C_USER')
	
	(mapDatos['usuario'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(usuarioVal)
	
	String usuarioNombreVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XC_USER')
	
	(mapDatos['usuarioNombre'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(usuarioNombreVal)
	
	String perfilVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'T_PERFIL')
	
	(mapDatos['perfil'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(perfilVal)
	
	String mailVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XL_EMAIL')

	(mapDatos['mail'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(mailVal)
	
	String domicilioVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XL_DOMICILIO')
	
	(mapDatos['domicilio'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(domicilioVal)
	
	String fechaAltaVal= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'FH_ALTA')
	
	(mapDatos['fechaAlta'])= CustomKeywords.'tool.StringCK.quitarCorchetes'(fechaAltaVal)
}

System.out.println('Map Datos: ' + mapDatos)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

return mapDatos

