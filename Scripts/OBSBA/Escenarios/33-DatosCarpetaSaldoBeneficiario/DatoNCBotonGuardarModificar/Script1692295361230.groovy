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
/**Valida  ejecucion de las funciones guardar y modificar**/
/**Valida que el usr observa los campos Importe de Carpeta, Fecha de Prestacion y
 * CUIT del Bnef**/
/**Guarda una carpeta como Bien y luego la modifica por Fondo compensador
 * cambia la fecha de prestacion, el importe y el cuit beneficiario**/
String tipoCarpeta = 'Sanatorio'

String contienePago = 'true'

String titulo = 'TituloModificado'

String descripcion = 'DescripcionModificado'

String fechaPrestacion = '06-2023'

String importe = '225,20'

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

String anioActual = CustomKeywords.'tool.DateGenerator.currentYear'()

String dniBeneficiario = CustomKeywords.'adicionales.DniRandomGenerator.generarDNIRandom'()

String generoBeneficiario = CustomKeywords.'adicionales.GeneroRandomGenerator.obtenerGeneroAleatorio'()

String cuitBeneficiario = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'(generoBeneficiario, dniBeneficiario)

def mapBoolean

mapBoolean = [('2') : false]

mapBooleanAux = [('1') : false, ('2') : false]

boolean ingreso = false

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

String hoy = CustomKeywords.'tool.DateGenerator.today'()

'Se loguea como prestador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

'Prueba el guardar'
mapBooleanAux = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpetaConPago'), [('varCuil') : usuario], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

'Prueba el modificar'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ModificarCarpeta'), [('varTipoCarpeta') : tipoCarpeta, ('varContienePago') : contienePago
        , ('varTitulo') : titulo, ('varDescripcion') : descripcion, ('varTipoUsuario') : 'Prestador', ('varFechaPrestacion') : fechaPrestacion
        , ('varImportePrestacion') : importe, ('varCuitBeneficiario') : cuitBeneficiario], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: String tituloGet = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/input_Ttulo_folderTitle'), 
    'value')

not_run: String descripcionGet = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_GuardarCarpeta/textarea_DescripcionModificado'))

//falta el id
String tituloGet2 = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), 
    'value')

String descripcionGet2 = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), 
    'value')

System.out.println('TituloGet: ' + tituloGet2)

System.out.println('Titulo: ' + titulo)

System.out.println('DescripcionGet: ' + descripcionGet2)

System.out.println('Descripcion: ' + descripcion)

//falta poner el id en titulo de carpeta, no fue insertado en el html
//(mapBoolean['1']) = (tituloGet2.compareTo(titulo) == 0)
(mapBoolean['2']) = (descripcionGet2.compareTo(descripcion) == 0)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
ingreso = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert ingreso

