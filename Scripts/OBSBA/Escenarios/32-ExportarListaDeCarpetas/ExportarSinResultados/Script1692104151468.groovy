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
 * Se ingresa un filtro que no genera datos a descargar **/
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

'Filtra desde el 01/01/2021 al dia 01/06/2021'
String anio = '2022'

String fechaDesde = '01012022'

String fechaHasta = '05012022'

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpeta'), [('varAnio') : anio, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaDesde, ('varFechaHasta') : fechaHasta, ('varCuil') : ''], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anio, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaDesde, ('varFechaHasta') : fechaHasta, ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'), 2, FailureHandling.STOP_ON_FAILURE)

existeExportar = WebUI.verifyElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'))

assert existeExportar

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/span_Exportar'))

WebUI.delay(2)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

