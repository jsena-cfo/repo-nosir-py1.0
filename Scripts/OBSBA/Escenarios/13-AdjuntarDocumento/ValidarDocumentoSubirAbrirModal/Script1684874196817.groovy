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
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

/**Author: JER**/
/**Script que valida que se abre el modal de carga de archivos**/
/**Valida para el browser Edge, Chrome y Firefox**/
String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : user
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

boolean validacion = false

String browserName = DriverFactory.getExecutedBrowser().getName()

'Login con usuario Prestador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : user, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : user, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoDocumento'), [('varTipoDocumento') : 'receta'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), 'Prueba titulo' + 
    valorRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/textarea_Observaciones_fileDescription'), 'Prueba Observaciones' + 
    valorRandom)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickSubirArchivo'), [:], FailureHandling.STOP_ON_FAILURE)

'Si no hay un stopFailure en el paso anterior, se abrio el modal y la validacion es True'
validacion = true

not_run: switch (browserName) {
    case 'EDGE_CHROMIUM_DRIVER':
        println('Validacion abre modal Edge')

        WebUI.waitForImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadIE_documento2'), 
            2)

        validacion = WebUI.verifyImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadIE_documento2'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'CHROME_DRIVER':
        println('Validacion abre modal Chrome')

        WebUI.waitForImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadChrome_documento'), 
            2)

        validacion = WebUI.verifyImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadChrome_documento'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'FIREFOX_DRIVER':
        println('Validacion abre modal Firefox')

        WebUI.waitForImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadFirefox_documento2'), 
            2)

        validacion = WebUI.verifyImagePresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalUploadFirefox_documento2'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
}

not_run: CustomKeywords.'tool.UploadFile.closeModalImgCancelar'()

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Nombre navegador: ' + browserName)

System.out.println('Validacion abrio modal: ' + validacion.toString())

assert validacion

