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
/**Se valida que es posible subir un documento que pesa menos de 25MB**/
/**Se tiene un limite de hasta 25MB en el total**/
boolean validar = false

String nuevaCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : varUser
        , ('varPass') : varPass], FailureHandling.STOP_ON_FAILURE)

'Login con usuario Interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varUser, ('Contrasena') : varPass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : nuevaCarpeta
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : varUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//String pathFile2 = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\pruebaXls1.xlsx'
String pathFile = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/carta_onu.pdf'

String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFile, '/', '\\\\')

String msj = 'Archivo subido correctamente'

validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsj'), [('varTitulo') : 'Prueba titulo 1', ('varDescripcion') : 'Prueba descripcion 1'
        , ('varPathFile') : pathFormateado, ('varUsuario') : 'Interno', ('varMsjValidado') : msj], FailureHandling.STOP_ON_FAILURE)

System.out.println((('Validar mensaje: ' + msj) + ' se valido: ') + validar.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

