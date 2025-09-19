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

/**Author: Jer**/
/****/
String cuil= getBinding().getAt('varCuil')

String nombre = getBinding().getAt('varNombre')

String telefono = getBinding().getAt('varTelefono')

String domicilio = getBinding().getAt('varDomicilio')

String email = getBinding().getAt('varEmail')

String intentosFallidos = getBinding().getAt('varIntentosFallidos')

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false]

boolean validar = false

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

String cuilSinComillas= CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBUsuarioPortal'(cuilSinComillas)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

String nombreSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XC_USER')

String telefonoSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'N_TELEFONO')

String domicilioSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XL_DOMICILIO')

String emailSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'XL_EMAIL')

String intentosFallidosSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'N_LOGIN_FALLIDO')

System.out.println("Valor 1: " + mapBoolean['1'])

System.out.println("Valor 1 comp: " + CustomKeywords.'tool.StringCK.quitarCorchetes'(nombreSql))

(mapBoolean['1'])= (nombre== CustomKeywords.'tool.StringCK.quitarCorchetes'(nombreSql))

System.out.println("Nombre: " + nombre)

System.out.println("NombreBD: " + CustomKeywords.'tool.StringCK.quitarCorchetes'(nombreSql))

(mapBoolean['2'])= (telefono== CustomKeywords.'tool.StringCK.quitarCorchetes'(telefonoSql))

(mapBoolean['3'])= (domicilio== CustomKeywords.'tool.StringCK.quitarCorchetes'(domicilioSql))

(mapBoolean['4'])= (email== CustomKeywords.'tool.StringCK.quitarCorchetes'(emailSql))

(mapBoolean['5'])= (intentosFallidos== CustomKeywords.'tool.StringCK.quitarCorchetes'(intentosFallidosSql))

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

System.out.println('MapBooleanBD: ' + mapBoolean)

validar = !mapBoolean.containsValue(false)

return validar