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
/**Script que registra a un usuario Prestador**/
/**Luego trata de registrar un afiliado con los mismo datos**/
/**Se valida el mensaje: "El usuario XXXXX con perfil prestador no puede tener otro perfil asignado"**/
not_run: String genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

not_run: String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

not_run: String cuil = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

'Registrar prestador'
not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuil, ('varPassword') : varPassword
        , ('varPerfil') : 'Prestador', ('varUsuario') : varUsuario, ('varEmail') : varEmail, ('varTelefono') : varTelefono
        , ('varDomicilio') : varDomicilio, ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

not_run: String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuil], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : varCuil, ('varToken') : token], 
    FailureHandling.STOP_ON_FAILURE)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registrar Perfil Afiliado-Prestador mismo pass en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

'Registrar afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : varCuil, ('varPassword') : varPassword, ('varPerfil') : 'Afiliado'
        , ('varUsuario') : varUsuario, ('varEmail') : varEmail, ('varTelefono') : varTelefono, ('varDomicilio') : varDomicilio
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String valorTexto = (('\n' + '***Log: Valida mensaje error: Registra al afiliado ' + varCuil.toString()) + ' y luego intenta cargar nuevamente con los mismos datos dando el mensaje de error') + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

