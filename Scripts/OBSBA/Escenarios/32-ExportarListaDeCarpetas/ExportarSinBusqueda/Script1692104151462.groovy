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
import java.awt.Desktop as Desktop
import java.io.File as File
import java.io.IOException as IOException

/**Script que valida que existe el boton Exportar
 * No se aplica filtro, se descarga todos los datos posibles 
 * Valida que se descarga el archivo exportado xlsx **/
boolean existeExportar = false

boolean descargado = false

boolean eliminado = false

String valor = CustomKeywords.'tool.DateGenerator.todayFormat'('yyyyMMdd')

String ext = '.xlsx'

String nameFile = valor + ' Folders'

System.out.println('tiempo: ' + valor)

System.out.println('nombre: ' + nameFile)

'Se loguea como usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : usuario, ('Contrasena') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'), 1, FailureHandling.STOP_ON_FAILURE)

existeExportar = WebUI.verifyElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'))

assert existeExportar

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

String home = System.getProperty('user.home')

String userDownloads = new File(home + '/Downloads/')

String path = ((userDownloads + '\\') + nameFile) + ext

System.out.println('path: ' + path)

WebUI.delay(1)

descargado = CustomKeywords.'tool.DownloadFile.isFileDownloaded'(userDownloads, nameFile + ext)

System.out.println('Descarga archivo: ' + descargado.toString())

if (descargado == true) {
    System.out.println('Se encontro archivo y se elimina')

    eliminado = CustomKeywords.'tool.DownloadFile.deleteFileDownloaded'(userDownloads, nameFile + ext)

    if (eliminado == true) {
        System.out.println('El archivo fue eliminado')
    } else {
        System.out.println('No se pudo eliminar el archivo')
    }
} else {
    System.out.println('No se encontro archivo para eliminar')
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert descargado

