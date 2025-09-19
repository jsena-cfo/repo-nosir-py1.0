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
/**Script toma un usuario interno-empleado y trata registrarlo con afiliado con otro password**/
/**Se muestra el mensaje: 'La contraseña y el correo del usuario XXXXX no coinciden con los datos ingresados'**/
//System.out.println('Cuit disponible: ' + cuil)
'Toma un usuario interno-empleado'
String emailMayuscula = varEmailHotmail.toString().toUpperCase()

//CustomKeywords.'tool.StringCK.pasarAMayuscula'(emailDos)
'Usa mail alternativo'
String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

System.out.println('Email mayuscula: ' + emailMayuscula)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String usuarioNombre = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioParamConCuilSinGuiones'(usuario, 
    varCuil)

'Lo registra como afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : passDos
        , ('varPerfil') : 'Afiliado', ('varUsuario') : usuarioNombre, ('varEmail') : emailMayus, ('varTelefono') : telefono
        , ('varDomicilio') : direccion, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

String reg = '  ->Intento registro Perfil Interno Empleado Afiliado diferente pass en entorno ' + url

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/cuilUsed.txt'], 
    FailureHandling.STOP_ON_FAILURE)

String logTexto = ('***Log: Valida mensaje error: Registra al usuario interno ' + cuilSinGuiones.toString()) + ', luego lo intenta registrar como empleado y luego lo intenta registrar como afiliado con otro pass, produciendo el error'

String valorTexto = ('\n' + logTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

