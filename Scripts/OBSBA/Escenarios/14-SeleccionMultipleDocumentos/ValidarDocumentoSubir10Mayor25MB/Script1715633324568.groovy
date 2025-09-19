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
/**Se cargan varios archivos simultaneamnete (10) que sumados dan mas de 25MB
 *Se valida que no es posible subir los documentos**/
/**Se tiene un limite de hasta 25MB en el total**/
boolean validar= false

String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : varUser
        , ('varPass') : varPass], FailureHandling.STOP_ON_FAILURE)

'Comentario: Login usuario Externo (prestador)'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varUser, ('Contrasena') : varPass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : varUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

//String pathFile = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\pruebaXlsBigFile.xls'
//String archivosMultiples= '\"File1\" \"File2\"'
String archivosMultiples = '"pruebaXlsBigFile05" "pruebaXlsBigFile" "pruebaXlsBigFile02" "pruebaXlsBigFile03" "pruebaXlsBigFile04" "pruebaXls6" "pruebaXls7" "pruebaXls8" "pruebaXls9" "pruebaXls10" '

//String pathFile2 = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\' + archivosMultiples
String pathFile1 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXlsBigFile.xls' //+ archivosMultiples

String pathFile2 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXlsBigFile02.xls' //+ archivosMultiples

String pathFile3 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXlsBigFile03.xls' //+ archivosMultiples

String pathFile4 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXlsBigFile04.xls' //+ archivosMultiples

String pathFile5 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXlsBigFile05.xls' //+ archivosMultiples

String pathFile6 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls6.xlsx' //+ archivosMultiples

String pathFile7 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls7.xlsx' //+ archivosMultiples

String pathFile8 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls8.xlsx' //+ archivosMultiples

String pathFile9 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls9.xlsx' //+ archivosMultiples

String pathFile10 = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls10.xlsx' //+ archivosMultiples

String pathFileMultiple = (((((((((((((((((pathFile1 + '\n') + pathFile2) + '\n') + pathFile3) + '\n') + pathFile4) + '\n') + 
pathFile5) + '\n') + pathFile6) + '\n') + pathFile7) + '\n') + pathFile8) + '\n') + pathFile9) + '\n') + pathFile10

String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFileMultiple, '/', '\\\\')

//String pathFormateadoMultiples= pathFormateado + archivosMultiples
System.out.println('Path archivo documento: ' + pathFormateado)

String msj = 'Prueba descripcion 30MB'

validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsj'), [('varTitulo') : 'Prueba titulo pdf30mb'
        , ('varDescripcion') : 'Prueba descripcion 30MB', ('varPathFile') : pathFormateado, ('varUsuario') : 'Interno', ('varMsjValidado') : msj], 
    FailureHandling.STOP_ON_FAILURE)

System.out.println((('Validar mensaje: ' + msj) + ' se valido: ') + validar.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar

