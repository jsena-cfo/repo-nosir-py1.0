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
/**Script que carga un documento de 30MB **/
/**Se valida mensaje de error al subir un documento que pesa mas de 25MB**/
/**Se tiene un limite de hasta 25MB en el total**/
boolean validar = false

String nuevaCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : intUser
        , ('varPass') : intPassword], FailureHandling.STOP_ON_FAILURE)

'Comentario: Login usuario Externo (prestador)'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : intUser, ('Contrasena') : intPassword], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : nuevaCarpeta
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : intUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//String pathFile3 = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\+!#$%&()=¡¨].[_;-,_cartograph.pdf'
//String pathFile2 = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\cartograph30MB.pdf'
String pathFile = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/cartograph30MB.pdf'

String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFile, '/', '\\\\')

System.out.println('Path archivo documento: ' + pathFormateado)

String msj = 'Prueba descripcion 30MB'

validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsj'), [('varTitulo') : 'Prueba titulo pdf30mb'
        , ('varDescripcion') : 'Prueba descripcion 30MB', ('varPathFile') : pathFormateado, ('varUsuario') : 'Interno', ('varMsjValidado') : msj], 
    FailureHandling.STOP_ON_FAILURE)

System.out.println((('Validar mensaje: ' + msj) + ' se valido: ') + validar.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

//validar = (mensaje == 'MensajeMaximoPermitido')
assert validar

