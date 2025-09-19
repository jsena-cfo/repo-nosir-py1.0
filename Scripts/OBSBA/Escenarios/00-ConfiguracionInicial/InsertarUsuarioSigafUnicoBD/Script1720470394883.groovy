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
String cuil= this.getBinding().getAt('varCuil').toString()

String emailVar= this.getBinding().getAt('varEmail').toString()

System.out.println("Insertar BD cuil: " + cuil)

System.out.println("Insertar BD email: " + emailVar)

Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer,
	varPort, varDBName, varUser, varPassBase64)

String sql

String query

String email2 = ('\'' + 'KLONAUTOMATION@HOTMAIL.COM') + '\''

//String email = ('\'' + 'klonautomation@gmail.com') + '\''

String email= '\'' + emailVar + '\''

String tipoDoc = ('\'' + 'DNI') + '\''

String n = ('\'' + 'N') + '\''

String dniStr= CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuil)

String numero

String usuario

String queryInsertCompleta = ' '

String ultimos4Digitos = CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dniStr)

String nombreUsuario = '\'%REGRESION' + ultimos4Digitos + '%\''

sql = ('SELECT * FROM slu.busuario a WHERE a.c_user LIKE \'%REGRE%\' AND a.xc_user LIKE ' + nombreUsuario)

'Example: Consulta'
println(sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean vacio = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

String reg

String cuilStr

//String dniNumeroStr

if (vacio) {
	System.out.println('Se pasa a hacer el insert')

	dniS = ''

	numero = ''

	usuario = ''

	query = ''

	dniS = (('\'' + dniStr.toString()) + '\'')

	usuario = ((('\'' + 'REGRESION') + ultimos4Digitos) + '\'')

	query = (((((((((((('INSERT INTO SLU.BUSUARIO (C_USER,XC_USER,XL_EMAIL,M_ES_PRIVILEGIADO,N_MAX_DIAS_EXPIRA_PWD,N_MAX_DIAS_EXPIRA_CTA,N_INTENTOS_FALLIDOS_ING,T_DOCUMENTO,N_DOCUMENTO) VALUES (' +
		usuario) + ',') + usuario) + ',') + email) + ',') + n) + ',100,100,100,') + tipoDoc) + ',') + dniS) + ')')

	System.out.println('Query: ' + query)

	actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, query)

		//dniNumeroStr = numeroDni.toString()

		//cuilStr2= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'("Masculino", dniNumeroStr)
	//cuilStr3 = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil_conGuiones'('Masculino', dniS)
    cuilStr= cuil
	reg = ((((('REGRESION' + numero.toString()) + ';') + dniStr) + ';') + cuilStr)

	WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'],
			FailureHandling.STOP_ON_FAILURE)
	
} else {
	System.out.println('No se necesita hacer los inserts')
}

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

vacio = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

println('Disconnect DB...')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

boolean ejecutado

if (vacio) {
	System.out.println('No se hicieron los inserts')

	WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'No se hicieron los inserts'], FailureHandling.STOP_ON_FAILURE)

	ejecutado = false
} else {
	System.out.println('Se hicieron los inserts')

	ejecutado = true
}

assert ejecutado