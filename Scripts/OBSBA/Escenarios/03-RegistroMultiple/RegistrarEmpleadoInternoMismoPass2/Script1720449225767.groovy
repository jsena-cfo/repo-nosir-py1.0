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

/**Script**/
/**Se registra un usuario empleado y luego se lo registra como 
 * interno con el mismo pass**/
not_run: def mapUsuario

not_run: mapUsuario = [('cuil') : '', ('usuario') : '']

not_run: String varEmailMayus = varEmail.toUpperCase()

'Se registra como empleado'
not_run: mapUsuario = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarEmpleadoAltCuitUsuario'), 
    [('password') : varPassword, ('telefono') : varTelefono, ('direccion') : varDomicilio, ('email') : varEmailMayus, ('url') : varUrl], 
    FailureHandling.STOP_ON_FAILURE)

not_run: String cuil = (mapUsuario['cuil']).toString()

not_run: String usuarioName2 = (mapUsuario['usuario']).toString()

String usuarioName = CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioConCuilSinGuiones'(varCuil)

cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registro Perfil Empleado con peril interno con mismo pass en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

'Registrar interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : varPassword
        , ('varPerfil') : 'Interno', ('varUsuario') : usuarioName, ('varEmail') : varEmail, ('varTelefono') : varTelefono
        , ('varDomicilio') : varDomicilio, ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String logTexto = '***Log: Registra al empleado ' + varCuil.toString() + 'y luego se lo registrar como interno con el mismo pass produciendo el error'

String valorTexto = '\n' + logTexto+ '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

