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
/****/
/**Hay problemas con el cambio de cuit-cuil
 * Se resuelve en RM 107916 y 107917**/
boolean validar = false

def mapDatos

def mapDatosMod

mapDatosMod = [('1') : 'REGREModificado', ('2') : 'cuit', ('3') : '20-10001000-4', ('4') : '1510001000', ('5') : 'Calle Modificada 111'
    , ('6') : 'modificado1010@gmail.com']

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuarioAdm, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

'Se toman los datos que fueron cargados previamente'
mapDatos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosMiPerfil'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Datos iniciales: ' + mapDatos)

System.out.println('Datos modificado: ' + mapDatosMod)

'Se modifican los datos con nuevos valores'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarDatosMiPerfil'), [('varNombre') : mapDatosMod['1'], ('varTipoDocumento') : mapDatosMod[
        '2'], ('varNumeroCuit') : mapDatosMod['3'], ('varTelefono') : mapDatosMod['4'], ('varDomicilio') : mapDatosMod['5']
        , ('varEmail') : mapDatosMod['6']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickMenuHome'), [('varOpcion') : 'MiPerfil'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/label_Mi Perfil'), 1)

validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarDatosMiPerfil'), [('varNombre') : mapDatosMod['1'], ('varTipoDocumento') : mapDatosMod[
        '2'], ('varNumeroCuit') : mapDatosMod['3'], ('varTelefono') : mapDatosMod['4'], ('varDomicilio') : mapDatosMod['5']
        , ('varEmail') : mapDatosMod['6']], FailureHandling.STOP_ON_FAILURE)

'Se insertan los datos previos a la modificacion'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarDatosMiPerfil'), [('varNombre') : mapDatos['1'], ('varTipoDocumento') : mapDatos[
        '2'], ('varNumeroCuit') : mapDatos['3'], ('varTelefono') : mapDatos['4'], ('varDomicilio') : mapDatos['5'], ('varEmail') : mapDatos[
        '6']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Validar: ' + validar.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

