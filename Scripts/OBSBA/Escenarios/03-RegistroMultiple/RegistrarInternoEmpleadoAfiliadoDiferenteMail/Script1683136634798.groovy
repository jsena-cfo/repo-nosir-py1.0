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

/**Script registra como interno, empleado y trata registrarlo con afiliado con otro mail**/
/**Se muestra el mensaje: 'La contraseña y el correo del usuario XXXXX no coinciden con los datos ingresados'**/
'Lo registra como interno'
String cuil = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInterno'), [('password') : pass], 
    FailureHandling.STOP_ON_FAILURE)

//System.out.println('Cuit disponible: ' + cuil)
String emailMayuscula = emailDos.toString().toUpperCase()

System.out.println('Email mayuscula: ' + emailMayuscula)

String token

'Lo registra como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleado'), [('email') : emailMayuscula, ('password') : pass
        , ('cuit') : cuil, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuilSinGuiones, ('varToken') : token], 
    FailureHandling.STOP_ON_FAILURE)

'Lo registra como afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuil, ('varPassword') : pass, ('varPerfil') : 'Afiliado'
        , ('varUsuario') : usuario, ('varEmail') : email, ('varTelefono') : telefono, ('varDomicilio') : direccion, ('varUrl') : url], 
    FailureHandling.STOP_ON_FAILURE)

String reg = '  ->Intento registro Perfil Interno Empleado Afiliado diferente mail en entorno ' + url

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/cuilUsed.txt'], 
    FailureHandling.STOP_ON_FAILURE)

String logTexto= "***Log: Valida mensaje error: Registra un interno, luego lo intenta registrar como empleado y luego lo intenta registrar como afiliado con otro mail: "

String valorTexto= '\n' + logTexto + cuil.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

