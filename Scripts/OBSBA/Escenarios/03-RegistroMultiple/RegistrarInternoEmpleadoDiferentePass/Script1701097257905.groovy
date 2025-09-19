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

/**Script registra como interno y trata registrarlo con empleado con otro password**/
/**Se muestra el mensaje: 'La contraseña y el correo del usuario XXXXX no coinciden con los datos ingresados'**/
/**Valida de acuerdo al entorno el mensaje resultante, el entorno Homologacion contiene otro mensaje con respecto al otro**/
'Se registra como interno'
String cuil = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInterno'), [('password') : passUno
        , ('url') : url], FailureHandling.STOP_ON_FAILURE)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Intento registro Perfil Empleado Interno diferente pass en entorno ' + url

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

'Se intenta registrar como empleado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleado'), [('email') : email, ('password') : passDos, ('cuit') : cuil
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

def msjError = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerMensaje'), [:], FailureHandling.STOP_ON_FAILURE)

//valida de acuerdo al entorno el mensaje resultante, el entorno Homologacion contiene otro mensaje con respecto al otro
String mensajeComparado

if (url.indexOf('homo') > -1) {
    mensajeComparado = 'La contraseña y el correo ingresado debe coincidir con la de su anterior perfil'

    System.out.println('Mensaje sobre entorno Homologacion')
} else {
    if (url.indexOf('preprod') > -1) {
        mensajeComparado = (('La contraseña y el correo del usuario ' + cuilSinGuiones) + ' no coinciden con los datos ingresados')

        System.out.println('Mensaje sobre entorno Preproduccion')
    } else {
        if (url.indexOf('test') > -1) {
            mensajeComparado = (('La contraseña y el correo del usuario ' + cuilSinGuiones) + ' no coinciden con los datos ingresados')

            System.out.println('Mensaje sobre entorno Test')
        } else {
            if (url.indexOf('desa') > -1) {
                mensajeComparado = (('La contraseña y el correo del usuario ' + cuilSinGuiones) + ' no coinciden con los datos ingresados')

                System.out.println('Mensaje sobre entorno Desa')
            }
        }
    }
}

String logTexto= "***Log: Valida mensaje error: Registra un interno y luego intenta registrarlo como empleado con otro pass: "

String valorTexto= '\n' + logTexto + cuil.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)


System.out.println('Mensaje validado: ' + mensajeComparado)

assert msjError == mensajeComparado

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

