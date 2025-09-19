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

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, 
    varPort, varDBName, varUser, varPassBase64)

String sql = CustomKeywords.'tool.SqlQueriesObsba.queryObtenerListadoTipoCarpeta'()

System.out.println('SQL: ' + sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean noObtuvo = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

System.out.println('No hubo resultados: ' + noObtuvo.toString())

String lista

ArrayList listaTmp

if (noObtuvo == false) {
    listaTmp = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList'(actorData)

    //lista = CustomKeywords.'tool.StringCK.quitarString'(listaTmp, 'XC_DESCRIPTOR=')

    lista= WebUI.callTestCase(findTestCase('OBSBA/Genericos/FormatearListaTipoCarpeta'), [('varTiposCarpetas') : listaTmp], FailureHandling.STOP_ON_FAILURE)
} else {
    lista = 'NULL'
}

System.out.println('Lista resultados: ' + lista)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

return lista

