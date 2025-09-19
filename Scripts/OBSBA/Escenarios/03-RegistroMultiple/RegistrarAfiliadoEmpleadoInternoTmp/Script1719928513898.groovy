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

/**Author: Jer**/
/**Se toma un usuario registrado como Afiliado y como empleado
 *  y se lo registra como interno**/
'Toma usuario afiliado-empleado'
String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

'Lo registra como interno'
WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInternoParamUnicoBD'), [('varPass') : varPassword
        , ('varUrl') : varUrl, ('varCuil') : cuilSinGuiones, ('varEmail') : emailMayus], FailureHandling.STOP_ON_FAILURE)

String logTexto = '***Log: Usuario con rol Afiliado Empleado Interno: ' + cuilSinGuiones.toString()

String valorTexto = ('\n' + logTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpGuardar'), [('varUsuario') : cuilSinGuiones, ('varPerfil') : 'afiliadoEmpleadoInterno'
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

