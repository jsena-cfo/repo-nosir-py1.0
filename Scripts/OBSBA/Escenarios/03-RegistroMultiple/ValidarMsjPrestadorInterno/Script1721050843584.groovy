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
/**Script carga un prestador y luego intenta cargar nuevamente al mismo**/
/**Se valida el mensaje: 'El usuario XXXXX con perfil prestador no puede tener otro perfil asignado'**/
'Toma al usuario prestador tmp'
boolean valida = false

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(varCuil)

String ultimos4Digitos = CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dni)

String userPrestador = varUsuario + ultimos4Digitos

String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

String validarMsj = ('El usuario ' + cuilSinGuiones) + ' con perfil prestador no puede tener otro perfil asignado'

'Lo intenta registrar como interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : userPrestador, ('varCuil') : cuilSinGuiones
        , ('varPassword') : varPassword, ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidadorMensaje'), [('varMensaje') : validarMsj], FailureHandling.STOP_ON_FAILURE)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registrar Perfil Prestador Dos veces en entorno' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

String valorTexto = ('***Log: Valida mensaje error: Registra al prestador ' + cuilSinGuiones) + ' y luego intenta cargar nuevamente al mismo lo que produce el error'

String logTexto = ('\n' + valorTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : logTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

