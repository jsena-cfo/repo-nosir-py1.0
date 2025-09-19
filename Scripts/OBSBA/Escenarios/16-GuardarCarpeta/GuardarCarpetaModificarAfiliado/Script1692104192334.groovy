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
/**Script crea una carpeta con un usuario Afiliado, modifica los campos**/
/**y valida que el campo haya sido modificado**/
String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : usuario
        , ('varPass') : password], FailureHandling.STOP_ON_FAILURE)

String tipoCarpeta = 'FondoCompensador'

String contienePago = 'false'

String titulo = 'TituloModificado'

String descripcion = 'DescripcionModificado'

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

String anioActual = CustomKeywords.'tool.DateGenerator.currentYear'()

'Loguearse como afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarCarpeta'), [('varTipoCarpeta') : tipoCarpeta, ('varContienePago') : contienePago
        , ('varTitulo') : titulo, ('varDescripcion') : descripcion, ('varTipoUsuario') : 'Afiliado', ('varFechaPrestacion') : ''
        , ('varImportePrestacion') : '', ('varCuitBeneficiario') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : 'numeroCarpeta'
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

def mapBoolean

boolean ingreso = false

//String tituloGet= WebUI.getText('ObsbaPortal/Page_ObSBA_CrearCarpeta/inputTitulo')
not_run: String tituloGet2 = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/input_Ttulo_folderTitle'), 
    'value')

String tituloGet = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), 
    'value')

not_run: String descripcionGet2 = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/textarea_DescripcionModificado'))

String descripcionGet = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'))

System.out.println('Titulo: ' + tituloGet)

System.out.println('Descripcion: ' + descripcionGet)

mapBoolean = [('1') : tituloGet.compareTo(titulo) == 0, ('2') : descripcionGet.compareTo(descripcion) == 0]

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
ingreso = !(mapBoolean.containsValue('false'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert ingreso

