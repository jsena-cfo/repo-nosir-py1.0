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
/**Se crea una carpeta con doc como prestador**/
/**Se envia la carpeta**/
/**Se ingresa como un interno carga un doc no visible**/
/**Se ingresa como el prestador y valida que no vea el doc y queda en estado privado**/

boolean subido = false

boolean present = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

String numeroCarpeta

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

'Se crea una carpeta con doc como afiliado'
numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDocParam'), [('varUsuario') : userPrestador
        , ('varPass') : pass, ('varVisible') : false], FailureHandling.STOP_ON_FAILURE)

'Envia la carpeta'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userPrestador, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : userPrestador, ('varTipoCarpeta') : ''
        , ('varEstadoCarpeta') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

enviado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

'Se ingresa como un interno carga un doc no visible'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userInterno, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

String pathFile = System.getProperty('user.dir') + '\\Xls\\obsba\\uploadXls\\carta_onu.pdf'

String pathFile2 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/carta_onu.pdf'

String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFile2, '/', '\\\\')

System.out.println('Pathfile: ' + pathFile)

//String pathFile = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\carta_onu.pdf'
String titulo = 'Documento NoVisible'

String descripcion = 'Descripcion Doc Adjunto NoVisible'

subido = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsjParam'), [('varTitulo') : titulo, ('varDescripcion') : descripcion
        , ('varPathFile') : pathFormateado, ('varUsuarioRol') : 'Interno', ('varMsjValidado') : 'Archivo subido correctamente'
        , ('varVisible') : false], FailureHandling.STOP_ON_FAILURE)

System.out.println('Documento fue subido: ' + subido.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

'Se ingresa como un afiliado y valida que no vea el doc'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userPrestador, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : userPrestador, ('varTipoCarpeta') : ''
        , ('varEstadoCarpeta') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_docGrillaTitulo'), 1)

String valorTitulo = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_docGrillaTitulo'))

String valorDescripcion = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_docDescripcionGrilla'))

System.out.println('Valor titulo: ' + titulo)

System.out.println('Valor descripcion: ' + descripcion)

System.out.println('Valor titulo: ' + valorTitulo)

System.out.println('Valor descripcion: ' + valorDescripcion)

(mapBoolean['1']) = (valorTitulo != titulo)

(mapBoolean['2']) = (valorDescripcion != descripcion)

System.out.println('Valor maps: ' + mapBoolean)

//valida que no contenga false
present = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert present

