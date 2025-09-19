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

String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPass').toString()

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

String fechaHoy = CustomKeywords.'tool.DateGenerator.today'()

boolean subido = false

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolverCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : usuario, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String pathFile = System.getProperty('user.dir') + '\\Xls\\obsba\\uploadXls\\carta_onu.pdf'

String pathFile2 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/carta_onu.pdf'

String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFile2, '/', '\\\\')

System.out.println('Pathfile: ' + pathFile)

//String pathFile = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\carta_onu.pdf'
String titulo = 'DocAdjunto1001'

String descripcion = 'DescripcionDocAdjunto1001'

/**
String mensaje
  
mensaje = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumento'), [('varTitulo') : titulo, ('varDescripcion') : descripcion
        , ('varPathFile') : pathFormateado, ('varUsuario') : 'Interno'], FailureHandling.STOP_ON_FAILURE)
**/
subido = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsj'), [('varTitulo') : titulo, ('varDescripcion') : descripcion
        , ('varPathFile') : pathFormateado, ('varUsuario') : 'Interno', ('varMsjValidado') : 'Archivo subido correctamente'], 
    FailureHandling.STOP_ON_FAILURE)

System.out.println('Documento fue subido: ' + subido.toString())

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String carpeta2 = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RetornarNumeroCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

String anioGuion = CustomKeywords.'tool.DateGenerator.currentYear'() + '-'

String numeroCarpeta = carpeta2.substring(5)

System.out.println('Carpeta Doc: ' + numeroCarpeta)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

return numeroCarpeta

