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
/**Script crea una carpeta con un usuario Interno, modifica los campos**/
/**y valida que el campo haya sido modificado**/
String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : usuario
        , ('varPass') : password], FailureHandling.STOP_ON_FAILURE)

String tipoCarpeta = 'Fondo Compensador'

String contienePago = 'true'

String titulo = 'TituloModificado'

String descripcion = 'DescripcionModificado'

//String fechaPrestacion = '06/06/2023'
String fechaPrestacion = '06-2023'

String importe = '100'

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

String anioActual = CustomKeywords.'tool.DateGenerator.currentYear'()

String dniBeneficiario = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String generoBeneficiario = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

String cuitBeneficiario = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(generoBeneficiario, dniBeneficiario)

'Loguearse como interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarCarpeta'), [('varTipoCarpeta') : tipoCarpeta, ('varContienePago') : contienePago
        , ('varTitulo') : titulo, ('varDescripcion') : descripcion, ('varTipoUsuario') : 'Interno', ('varFechaPrestacion') : fechaPrestacion
        , ('varImportePrestacion') : importe, ('varCuitBeneficiario') : cuitBeneficiario], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: String tituloGet2 = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/input_Ttulo_folderTitle'), 
    'value')

not_run: String descripcionGet2 = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/textarea_DescripcionModificado'))

not_run: String tituloGet = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), 
    'value')

not_run: String descripcionGet = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'))

String beneficiarioCuitGet = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), 
    'value')

//WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'))
String importeGet = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), 
    'value')

String cuitBeneficiarioSinComillas = CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(beneficiarioCuitGet)

String cuitSinComillas = CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(cuitBeneficiario)

/**
WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), 
    cuitBeneficiario)
String importeGet2 = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), 
    importe)
    **/
def mapBoolean

boolean ingreso = false

mapBoolean = [('1') : false, ('2') : false]

System.out.println('Cuit beneficiario: ' + cuitSinComillas)

System.out.println('Cuit beneficiario modificado: ' + cuitBeneficiarioSinComillas)

System.out.println('Importe: ' + importe)

System.out.println('Importe modificado: ' + importeGet)

//System.out.println('Valor maps: ' + mapBoolean)
//(mapBoolean['1']) = (tituloGet.compareTo(titulo) == 0)
//(mapBoolean['2']) = (descripcionGet.compareTo(descripcion) == 0)
(mapBoolean['1']) = (cuitBeneficiarioSinComillas.compareTo(cuitSinComillas) == 0)

(mapBoolean['2']) = (importeGet.compareTo(importe) == 0)

//(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), 
//    cuitBeneficiario)
//(mapBoolean['2']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), 
//    importe)
//String descripcionGet = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'))
//System.out.println('Titulo get: ' + tituloGet)
//System.out.println('Descripcion get: ' + descripcionGet)
System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
ingreso = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert ingreso

