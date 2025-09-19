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
/**Script que valida los campos: tipo carpeta, estado, fecha y contiene pago de nueva carpeta**/
boolean present = false

//boolean validacionTipoCarpeta
//boolean validacionEstado
//boolean validacionFecha
//boolean validacionContienePago
def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false]

'Se loguea como usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : intUser, ('Contrasena') : intPassword], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//validacionTipoCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarTipoCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)
//validacionEstado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarEstado'), [:], FailureHandling.STOP_ON_FAILURE)
//validacionFecha = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarFecha'), [:], FailureHandling.STOP_ON_FAILURE)
//validacionContienePago = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarContienePago'), [:], FailureHandling.STOP_ON_FAILURE)
//System.out.println('Validacion tipo carpeta: ' + validacionTipoCarpeta.toString())
//System.out.println('Validacion estado: ' + validacionEstado.toString())
//System.out.println('Validacion fecha: ' + validacionFecha.toString())
//System.out.println('Validacion contiene pago: ' + validacionContienePago.toString())
(mapBoolean['1']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarTipoCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['2']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarEstado'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['3']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarFecha'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['4']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarContienePago'), [:], FailureHandling.STOP_ON_FAILURE)

//if ((((validacionTipoCarpeta == true) && (validacionEstado == true)) && (validacionFecha == true)) && (validacionContienePago == 
//true)) {
//    present = true
//} else if ((((validacionTipoCarpeta == false) || (validacionEstado == false)) || (validacionFecha == false)) || (validacionContienePago == 
//false)) {
//    present = false
//}
System.out.println('MapBoolean: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert present

