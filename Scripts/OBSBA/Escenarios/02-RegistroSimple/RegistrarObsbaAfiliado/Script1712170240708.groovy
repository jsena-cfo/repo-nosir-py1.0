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

/**Ingresa nuevo afiliado y lo activa**/
/**El cuit que se ingresa se genera aleatoriamente**/
String genero

//genero = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

genero= "Masculino"

boolean activado= false

String dni = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String cuil = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(genero, dni)

String ultimos4 = CustomKeywords.'adicionales.CuilRandomGenerator.obtenerUltimos4DigitosDni'(dni)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String userAfiliado = varUsuario + ultimos4

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.todayAndTime'()

String reg = '  ->Registro Perfil Afiliado en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(varEmailHotmail)

'Registra afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : varPassword, ('varPerfil') : 'Afiliado'
        , ('varUsuario') : userAfiliado, ('varEmail') : emailMayus, ('varTelefono') : varTelefono, ('varDomicilio') : varDomicilio
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

activado= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuil, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarUsuarioCreado'), [('cuit') : cuil], FailureHandling.STOP_ON_FAILURE)

if(activado== false) {
    cuilSinGuiones= 'error'
}

return cuilSinGuiones

