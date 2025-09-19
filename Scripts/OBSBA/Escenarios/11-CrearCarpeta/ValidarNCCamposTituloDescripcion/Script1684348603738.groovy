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
/**Script que valida los campos Titulo y Descripcion de nueva carpeta**/
boolean present = false

//boolean validacionTitulo = false
//boolean validacionDescripcion = false
def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

'Se loguea como usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : intUser, ('Contrasena') : intPassword], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//validacionTitulo = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarTituloCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)
//validacionDescripcion = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarDescripcionCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)
(mapBoolean['1']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarTituloCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['2']) = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarDescripcionCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//System.out.println('ValidacionTitulo: ' + validacionTitulo.toString())
//System.out.println('ValidacionDescripcion: ' + validacionDescripcion.toString())
/**
if ((validacionTitulo == true) && (validacionDescripcion == true)) {
    present = true
} else if ((validacionTitulo == false) || (validacionDescripcion == false)) {
    present = false
}
**/
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

assert present

