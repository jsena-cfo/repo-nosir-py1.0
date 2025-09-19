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

boolean validados = false

mapBoolean = [('opcionOrdenCompraAbierta') : false, ('opcionSolicitudesActualizacionPrecios') : false, ('opcionEjecutar') : false
    , ('validarCampos') : false, ('tipoTarea') : false]

(mapBoolean['opcionOrdenCompraAbierta']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - RecibirOC/span_Orden compra abierta'), 
    2)

(mapBoolean['opcionSolicitudesActualizacionPrecios']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/a_Solicitudes de Actualizacin de Precios 12'), 
    2)

(mapBoolean['opcionEjecutar']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/a_Ejecutar'), 
    2)

(mapBoolean['validarCampos']) = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/ValidarSeccionSolicitudActualizacionCampos'), 
    [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['tipoTarea']) = WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionPrecios/Page_BAC - SolicitudActualizacionPrecios/td_tipo_tarea'), 
    2)

System.out.println('MapBoolean: ' + mapBoolean)

validados = !(mapBoolean.containsValue(false))

return validados

WebUI.acceptAlert()



