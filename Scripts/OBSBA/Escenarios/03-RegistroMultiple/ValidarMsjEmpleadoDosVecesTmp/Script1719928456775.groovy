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
/**Script registra un empleado, lo activa y luego intenta volver a registrarse **/
/**Al no poder, valida el mensaje resultante de acuerdo al entorno**/
/**'El usuario XXXXX ya tiene perfil Empleado'**/
'Toma empleado registrado'
String primerEmailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(primerEmail)

String segundoEmailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(segundoEmail)

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(varCuil)

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Registro Perfil Empleado dos veces en entorno ' + url

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

'Vuelve a intentar registrarse'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleado'), [('email') : segundoEmailMayus, ('password') : pass
        , ('cuit') : varCuil, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

def msjError = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerMensaje'), [:], FailureHandling.STOP_ON_FAILURE)

//valida de acuerdo al entorno el mensaje resultante
String mensajeComparado

if (url.indexOf('homo') > -1) {
    mensajeComparado = 'La contraseña y el correo ingresado debe coincidir con la de su anterior perfil'

    System.out.println('Mensaje sobre entorno Homologacion')
} else {
    if (url.indexOf('preprod') > -1) {
        mensajeComparado = (('El usuario ' + cuilSinGuiones) + ' ya tiene perfil Empleado')

        System.out.println('Mensaje sobre entorno Preproduccion')
    } else {
        if (url.indexOf('test') > -1) {
            mensajeComparado = (('El usuario ' + cuilSinGuiones) + ' ya tiene perfil Empleado')

            System.out.println('Mensaje sobre entorno Test')
        } else {
            if (url.indexOf('desa') > -1) {
                mensajeComparado = (('El usuario ' + cuilSinGuiones) + ' ya tiene perfil Empleado')

                System.out.println('Mensaje sobre entorno Desa')
            }
        }
    }
}

System.out.println('Mensaje validado: ' + mensajeComparado)

String valorTexto = ('***Log: Valida mensaje error: Registra el empleado ' + cuilSinGuiones) + ' y luego intenta volver a registrarlo mostrando el mensaje de error'

String logTexto = ('\n' + valorTexto) + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)

assert msjError == mensajeComparado

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

