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
/**Existe el botón y funciona correctamente, dirige a la
 * pantalla 'Consulta Usuarios'**/
def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

boolean validarVolver = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'AdministracionUsuario'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarUsuario'), [('varRazonSocial') : '', ('varTipoUsuario') : 'interno'
        , ('varNombreUsuario') : '', ('varIntentosFallidos') : '', ('varCuil') : usuarioInt, ('varFechaDesde') : '', ('varFechaHasta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdministrarUsuario'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Volver'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/label_Consulta Usuarios'), 
    1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarUsuario/label_Consulta Usuarios'), 1)

not_run: validarVolver = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/label_Consulta Usuarios'), 
    'Consulta Usuarios')

validarVolver = !(mapBoolean.containsValue(false))

System.out.println('Valida volver: ' + mapBoolean.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validarVolver

