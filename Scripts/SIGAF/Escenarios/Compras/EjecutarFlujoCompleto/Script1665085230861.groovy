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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

/**Paso1**/
/**Las solicitudes se cargan en la Hoja1SG del xls**/
'Paso1'
String numeroLegajo = WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarSolicitudGasto'), [('varUsuario') : varUsuario
        , ('varPassword') : varPassword], FailureHandling.STOP_ON_FAILURE)

'Paso1'
String numero = numeroLegajo.trim()

/**Paso2**/
/**Las contrataciones se cargan en la Hoja2PC del xls**/
'Paso2'
String numeroContratacion = WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarParametrosContratacion'), [
        ('varUsuario') : varUsuario, ('varPassword') : varPassword, ('varNumero') : numero], FailureHandling.STOP_ON_FAILURE)

/**Paso3**/
/**Este paso no se puede hacer inmediatamente luego del paso previo, el acta no esta disponible inmediatamente**/
/**En preproduccion el listado se carga inmediatamente en el entorno de QA Automation no**/
/**Usa la hora inicio y la hora apertura**/
/**Se realiza el ingreso de sobres**/
'Paso3'
WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarPliegoBasesCondiciones'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varNumeroContratacion') : numeroContratacion], FailureHandling.STOP_ON_FAILURE)

/**Paso4**/
/**Este paso no se puede hacer inmediatamente luego del paso previo, el acta no esta disponible inmediatamente**/
/**Se usa el numero de contratacion**/
/**Se carga hora apertura**/
/**Se carga informacion en la Hoja3AC del xls**/
/**Se carga informacion se cargan en la Hoja4DE del xls**/
'Paso4'
WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarEvaluacionOfertas'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varNumeroContratacion') : numeroContratacion, ('varNumeroActa') : numeroActa], FailureHandling.STOP_ON_FAILURE)

/**Paso5**/
'Paso5'
WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarAdjudicacion'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varNumeroContratacion') : numeroContratacion], FailureHandling.STOP_ON_FAILURE)

/**Paso6**/
/**El orden de compra perfeccionamiento toma las primeras ordenes que encuentra**/
/**No puede filtrar por una en particular**/
'Paso6'
not_run: WebUI.callTestCase(findTestCase('SIGAF/Escenarios/Compras/GenerarOrdenCompra'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varNumeroContratacion') : numeroContratacion], FailureHandling.STOP_ON_FAILURE)

