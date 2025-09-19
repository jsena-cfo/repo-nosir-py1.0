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


String usuarioBloqueo = getBinding().getAt('varUsuarioBloqueo').toString()

String tipoPerfil = getBinding().getAt('varTipoPerfil').toString()

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false]

boolean validar= false


WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/button_DarDeAlta'))

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/h2_darDeAltaAtencin'), 2)

String msj = ((('¿Desea dar de alta al usuario ' + usuarioBloqueo) + ' con perfil ') + tipoPerfil) + '?'

WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/p_msjDarDeAltaAtencion'), msj)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/button_CONFIRMAR'))

(mapBoolean['1'])= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/h2_usuarioDadoAltaExito'), 'Operación realizada exitosamente')

(mapBoolean['2'])= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultaUsuarioAdministrador/p_msjUsuarioDadoDeAlta'), 'El usuario fue dado de alta.')

(mapBoolean['3']) = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/28-PantallaAdministrarUsuario/ValidarUsuarioFHBajaBD'), 
    [('varUsuario') : usuarioBloqueo, ('varValidarCondicion') : 'null'], FailureHandling.STOP_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

return validar