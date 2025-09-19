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
Connection connection = null

ResultSet actorData

println('Connect database...')

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.oracle, varServer, 
    varPort, varDBName, varUser, varPassBase64)

String sql

String query

String email = ('\'' + 'KLONAUTOMATION@HOTMAIL.COM') + '\''

String tipoDoc = ('\'' + 'DNI') + '\''

String n = ('\'' + 'N') + '\''

String dniS

String numero

String usuario

String queryInsertCompleta = ' '

/**ORA-00604: se ha producido un error a nivel 1 de SQL recursivo
ORA-01000: número máximo de cursores abiertos excedido**/
/**SELECT value FROM v$parameter WHERE name = 'open_cursors'**/
//todos
/**Se ingresa como parametro el dni desde y el dni hasta**/
int rangoDesde = getBinding().getAt('varInsertarDesde')

int rangoHasta = getBinding().getAt('varInsertarHasta')

//int
//int rangoDesde= 12004128
//int rangoHasta= 12004248
//emp
//int rangoDesde= 12004310
//int rangoHasta= 12004499
String rangoString = rangoDesde.toString()

System.out.println('Rango string: ' + rangoString)

String ultimosDigitos = rangoString.substring(4, 8)

String primerCuit = ('\'%REGRESION' + ultimosDigitos) + '%\''

System.out.println('Primer cuit: ' + primerCuit)

sql = ('SELECT * FROM slu.busuario a WHERE a.c_user LIKE \'%REGRE%\' AND a.xc_user LIKE ' + primerCuit)

'Example: Consulta'
println(sql)

actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, sql)

boolean vacio = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult'(actorData)

String reg

String cuilStr

String dniNumeroStr

reg = ''

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
    FailureHandling.STOP_ON_FAILURE)

reg = ''

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
    FailureHandling.STOP_ON_FAILURE)

reg = CustomKeywords.'tool.DateGenerator.todayAndTime'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
    FailureHandling.STOP_ON_FAILURE)

reg = ('Entorno: ' + varServer)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
    FailureHandling.STOP_ON_FAILURE)

reg = 'UserSigaf;DNI;CUIT;Estado;FechaUsado'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
    FailureHandling.STOP_ON_FAILURE)

if (vacio) {
    System.out.println('Se pasa a hacer los inserts')

    for (int numeroDni : (rangoDesde..rangoHasta)) {
        dniS = ''

        numero = ''

        usuario = ''

        query = ''

        dniS = (('\'' + numeroDni.toString()) + '\'')

        numero = dniS.substring(5, 9)

        usuario = ((('\'' + 'REGRESION') + numero) + '\'')

        query = (((((((((((('INSERT INTO SLU.BUSUARIO (C_USER,XC_USER,XL_EMAIL,M_ES_PRIVILEGIADO,N_MAX_DIAS_EXPIRA_PWD,N_MAX_DIAS_EXPIRA_CTA,N_INTENTOS_FALLIDOS_ING,T_DOCUMENTO,N_DOCUMENTO) VALUES (' + 
        usuario) + ',') + usuario) + ',') + email) + ',') + n) + ',100,100,100,') + tipoDoc) + ',') + dniS) + ')')

        System.out.println('Query: ' + query)

        actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, query)

        dniNumeroStr = numeroDni.toString()

        //cuilStr= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'("Masculino", dniNumeroStr)
        cuilStr = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil_conGuiones'('Masculino', dniNumeroStr)

        reg = ((((('REGRESION' + numero.toString()) + ';') + dniNumeroStr) + ';') + cuilStr)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/listaUsuariosSigaf.txt'], 
            FailureHandling.STOP_ON_FAILURE)
    }
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

