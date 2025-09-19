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

String cuil = getBinding().getAt('varUsuario').toString()

boolean present = false

//boolean valCarpetaCreada
//boolean valCarpetaLista
def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

String anioActual = CustomKeywords.'tool.DateGenerator.currentYear'()

String hoy = CustomKeywords.'tool.DateGenerator.today'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : 'BienSalud'], FailureHandling.STOP_ON_FAILURE)

int numeroRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

String tituloRandom = 'pruebaTitulo' + numeroRandom.toString()

System.out.println('Valor titulo Random: ' + tituloRandom)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: boolean check = WebUI.verifyElementChecked(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'), 
    2, FailureHandling.OPTIONAL)

not_run: if (check == true) {
    not_run: System.out.println('Check marcado')

    not_run: WebUI.uncheck(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarCheckActivadoDeschequear'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo de Carpeta'), tituloRandom)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion de Carpeta'), 'pruebaDescripcion' + 
    numeroRandom.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/div_CarpetaCreadaExito'), 1)

String mensajeValidado = 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!'

/**
valCarpetaCreada = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/p_Carpeta creada con exito'), 
    mensajeValidado)
  **/
(mapBoolean['1']) = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/p_Carpeta creada con exito'), 
    mensajeValidado)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

//System.out.println('Validacion carpeta creada: ' + valCarpetaCreada.toString())
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : hoy, ('varFechaHasta') : hoy, ('varCuil') : cuil, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/div_primeroListado'), 1)

//String valorTextoTituloCarpeta = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/td_primeraCarpetaTitulo2'))
String valorTextoTituloCarpeta = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/div_primeraCarpetaTitulo'))

System.out.println('Valor carpeta lista: ' + valorTextoTituloCarpeta.toString())

System.out.println('Valor carpeta comparado: ' + tituloRandom.toString())

/**
if (valorTextoTituloCarpeta.contains(tituloRandom)) {
    valCarpetaLista = true
} else {
    valCarpetaLista = false
}

System.out.println('Validacion carpeta lista: ' + valCarpetaLista.toString())

System.out.println('Validacion carpeta creada: ' + valCarpetaCreada.toString())


if ((valCarpetaCreada == true) && (valCarpetaLista == true)) {
    present = true
} else if ((valCarpetaCreada == false) || (valCarpetaLista == false)) {
    present = false
}
**/
(mapBoolean['2']) = valorTextoTituloCarpeta.contains(tituloRandom)

System.out.println('Valor maps: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

return present

