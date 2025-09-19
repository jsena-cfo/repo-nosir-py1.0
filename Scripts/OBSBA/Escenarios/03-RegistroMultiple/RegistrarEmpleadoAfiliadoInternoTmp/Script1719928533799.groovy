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
/**Script toma un empleado-afiliado y lo registra como interno**/
'Toma usuario afiliado-empleado'
String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(varCuil)

String ultimos4Digitos = CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(varCuil)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String userEmpleado = varUser + ultimos4Digitos

//String emailMayuscula2 = emailDos.toString().toUpperCase()
String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

//String emailMinuscula = emailDos
System.out.println('Email mayuscula: ' + emailMayus)

'Lo registra como interno'
WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInternoParamUnicoBD'), [('varPass') : varPassword
        , ('varUrl') : varUrl, ('varCuil') : cuilSinGuiones, ('varEmail') : emailMayus], FailureHandling.STOP_ON_FAILURE)

String logTexto = '***Log: Valida mensaje error: Registra un interno, luego lo registra como empleado y luego como afiliado: ' + 
cuilSinGuiones

String valorTexto = ('\n' + logTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

