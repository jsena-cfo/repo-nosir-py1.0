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
/**Script que carga mas de 10 documentos**/
/**Valida la composicion de la grilla**/
String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : varUser
        , ('varPass') : varPass], FailureHandling.STOP_ON_FAILURE)

boolean present = false

boolean validar

def mapBoolean

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false, ('7') : false, ('8') : false
    , ('9') : false, ('10') : false, ('11') : false]

'Comentario: Login usuario Externo (prestador)'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varUser, ('Contrasena') : varPass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

String anio = CustomKeywords.'tool.DateGenerator.currentYear'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : numeroCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : varUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/IngresarACarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

for (int i : (1..11)) {
    validar = false

    String numeroStr = new String()

    numeroStr = i.toString()

    //String pathFile2 = 'C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\pruebaXls1.xlsx'
    //String pathFile3 = ('C:\\Devs\\Projects\\Katalon\\SIGAF-BAC-Automation\\Xls\\obsba\\uploadXls\\pruebaXls' + numeroStr) + '.xlsx'
    String pathFile = CustomKeywords.'tool.UploadFile.pathRelativeProject'() + '/Xls/obsba/uploadXls/pruebaXls1.xlsx'

    String pathFormateado = CustomKeywords.'tool.StringCK.reemplazarSubstring'(pathFile, '/', '\\\\')

    System.out.println('Path archivo documento: ' + pathFile)

    String msj = 'Archivo subido correctamente'

    validar = WebUI.callTestCase(findTestCase('OBSBA/Genericos/SubirDocumentoMsj'), [('varTitulo') : 'Prueba titulo ' + 
            numeroStr, ('varDescripcion') : 'Prueba descripcion ' + numeroStr, ('varPathFile') : pathFormateado, ('varUsuario') : 'Externo'
            , ('varMsjValidado') : msj], FailureHandling.STOP_ON_FAILURE)

    System.out.println((('Validar mensaje: ' + msj) + ' se valido: ') + validar.toString())

    (mapBoolean[i.toString()]) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_docGrillaTitulo'), 
        'Prueba titulo ' + numeroStr)
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Validar mapBoolean: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

assert present

