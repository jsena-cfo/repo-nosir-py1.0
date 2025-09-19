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
/**Se toma un usuario Afiliado registrado y se lo registra como empleado**/
'Se toma un usuario registrado como afiliado '
String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(varCuil)

String userNombre = varUser + CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dni)

String token

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

System.out.println('Cuit afiliado cargado: ' + cuilSinGuiones)

//String userNombre2 = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioConCuilSinGuiones'(cuil)
//String emailMayuscula2 = varEmailDos.toString().toUpperCase()
String emailMayuscula = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

//String emailMinuscula = emailDos
System.out.println('Email mayuscula: ' + emailMayuscula)

'Lo registra como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('varEmail') : emailMayuscula, ('varPassword') : varPassword
        , ('varCuit') : cuilSinGuiones, ('varUser') : userNombre, ('varTelefono') : varTelefono, ('varDireccion') : varDomicilio
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuilSinGuiones, ('varToken') : token], 
    FailureHandling.STOP_ON_FAILURE)

String logTexto = '***Log: Usuario con rol Afiliado Empleado: ' + cuilSinGuiones

String valorTexto = ('\n' + logTexto) + '\n'

GlobalVariable.cuitAfiEmpInt = cuilSinGuiones

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

