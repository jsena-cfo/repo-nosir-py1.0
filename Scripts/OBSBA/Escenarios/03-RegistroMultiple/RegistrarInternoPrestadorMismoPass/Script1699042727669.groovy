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
/**El script crea un usuario interno y lo activa**/
/**Intenta ingresar un usuario prestador con el mismo usuario y pass**/
/**Se valida el mensaje: 'El usuario XXXXX no puede ser Prestador ya que cuenta con otros perfiles'**/

'Carga usuario Interno'
Map datos = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/02-RegistroSimple/RegistrarInternoParam'), [('varPassword') : varPassword, ('varUrl') : varUrl
        , ('varParamRetorno') : 2, ('varXlsInternos') : varXlsInternos, ('varDataFileInternos') : varDataFileInternos], 
    FailureHandling.STOP_ON_FAILURE)

String cuil = datos.getAt('cuil').toString()

String usuario = datos.getAt('usuario').toString()

String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

String reg = '  ->Intento registro Perfil Prestador interno mismo pass en entorno ' + varUrl

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : reg, ('varTextPath') : 'Txt/cuilUsed.txt'], 
    FailureHandling.STOP_ON_FAILURE)

'Carga Usuario Prestador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarObsba'), [('varCuil') : cuilSinGuiones, ('varPassword') : varPassword
        , ('varPerfil') : 'Prestador', ('varUsuario') : usuario, ('varEmail') : varEmail, ('varTelefono') : varTelefono, ('varDomicilio') : varDomicilio
        , ('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String logTexto= "***Log: Valida mensaje error: Registra un interno y luego intenta registrar un prestador con mismo usuario y pass: "

String valorTexto= '\n' + logTexto + cuil.toString() + '\n'

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : valorTexto], FailureHandling.STOP_ON_FAILURE)
