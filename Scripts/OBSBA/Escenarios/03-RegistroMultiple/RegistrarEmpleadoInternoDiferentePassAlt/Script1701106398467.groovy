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
/**Script registra un empleado**/
/**Luego intenta registrar un prestador con los mismos datos**/
/**Se valida el mensaje: **/
/** "La contraseña XXXXX no coincide con la contraseña de los perfiles activados"**/
'Registrar empleado'
def mapUsuario

mapUsuario = [('cuil') : '', ('usuario') : '']

String varEmailMayus = varEmail.toUpperCase()

mapUsuario = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarEmpleadoAltCuitUsuario'), [('password') : varPassword
        , ('telefono') : varTelefono, ('direccion') : varDomicilio, ('email') : varEmailMayus, ('url') : varUrl], FailureHandling.STOP_ON_FAILURE)

String cuil = (mapUsuario['cuil']).toString()

String usuarioName = (mapUsuario['usuario']).toString()

String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuil)

cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String txtRegistrado = (((('Se registro y activo usuario: ' + usuarioName) + ' dni: ') + dni) + ' cuit: ') + cuil

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registro Perfil Empleado con peril interno con distinto pass en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Empleado Registrado: '], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)

'Intenta registrar interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : varPassword2
        , ('varPerfil') : 'Interno', ('varUsuario') : usuarioName, ('varEmail') : varEmail, ('varTelefono') : varTelefono
        , ('varDomicilio') : varDomicilio, ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String logTexto= "***Log: Valida mensaje error: Registra un empleado y luego intenta registrarlo como prestador con los mismo datos: "

String valorTexto= '\n' + logTexto + cuil.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)
