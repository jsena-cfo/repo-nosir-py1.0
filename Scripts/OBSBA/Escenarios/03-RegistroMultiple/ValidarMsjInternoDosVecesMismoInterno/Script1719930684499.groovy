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

/**Author: JER**/
/**Script intenta cargar el mismo interno con la misma informacion**/
/**Valida el mensaje: El usuario XXXXX ya tiene perfil Interno**/
//String usuario2 = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioConCuilSinGuiones'(cuil)
'Toma a un usuario interno'
String usuario = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioParamConCuilSinGuiones'(varUser, varCuil)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registro Perfil Interno dos veces en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

'Intenta registrarse con el mismo interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : varPassword
        , ('varPerfil') : 'Interno', ('varUsuario') : usuario, ('varEmail') : emailMayus, ('varTelefono') : varTelefono, ('varDomicilio') : varDomicilio
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String logTexto = ('***Log: Valida mensaje error: Registra al usuario interno ' + cuilSinGuiones) + ', luego lo intenta registrar con los mismo datos produciendo el error'

String valorTexto = ('\n' + logTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

