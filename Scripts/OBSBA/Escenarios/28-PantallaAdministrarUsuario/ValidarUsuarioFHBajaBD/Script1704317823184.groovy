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

String cuil= this.getBinding().getAt('varUsuario').toString()

String validarCondicion= this.getBinding().getAt('varValidarCondicion').toString()

boolean validar= false

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)


String cuilSinComillas= CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String sql= CustomKeywords.'tool.SqlQueriesObsba.queryObtenerBUsuarioPortal'(cuilSinComillas)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

String fhBajaSql= CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, 'FH_BAJA')

String fhBaja= CustomKeywords.'tool.StringCK.quitarCorchetes'(fhBajaSql)

System.out.println("Fecha Baja validada: " + fhBaja)

if(validarCondicion== "null") { //valida que 
	if (fhBaja== "null") {
		System.out.println("Valida que Fecha Baja sea null")
		validar= true
	}
}
else if (validarCondicion== "noNull") {
	if (fhBaja!= "null") {
		System.out.println("Valida que Fecha Baja sea no null")
		validar= true
	}
}

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)


return validar