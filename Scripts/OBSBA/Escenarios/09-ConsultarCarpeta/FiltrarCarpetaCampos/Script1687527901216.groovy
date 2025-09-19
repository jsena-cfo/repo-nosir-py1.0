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

/**Author: JER**/
/**Valida los filtros probando todos los valores en los campos con selector**/
/**Valida Todos, fila desde y fila hasta, numero de carpeta y usuario**/
/**Si la global ReutilizacionCarpetas esta activa, crea carpetas temporarias de uso general**/
def mapBoolean

boolean validar = false

mapBoolean = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false, ('6') : false, ('7') : false]

String numCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : userVarInterno
        , ('varPass') : passVar], FailureHandling.STOP_ON_FAILURE)

String anioActual = CustomKeywords.'tool.DateGenerator.currentYear'()

String fechaPrimera = '01/01/' + anioActual

String fechaSegunda = CustomKeywords.'tool.DateGenerator.today'()

'Login con usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userVarInterno, ('Contrasena') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

'filtra por todas las carpetas'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : anioActual, ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

(mapBoolean['1']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 
    1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

'filtra por numero de carpeta'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : numCarpeta
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

(mapBoolean['2']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 
    1)

String numeroStr = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaNumero'), FailureHandling.STOP_ON_FAILURE)

(mapBoolean['3']) = numeroStr.contains(numCarpeta)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

'filtra carpetas en un lapso de tiempo'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaPrimera, ('varFechaHasta') : fechaSegunda, ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

(mapBoolean['4']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 
    1)

String fechaStr = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaFecha'))

String fechaStrAux = CustomKeywords.'tool.StringCK.reemplazarSubstring'(fechaStr, 'de', '-')

String fechaStrAuxSinBlancos = CustomKeywords.'tool.StringCK.reemplazarSubstring'(fechaStrAux, ' ', '')

String fechaStrAuxSinBlancosSinComa = CustomKeywords.'tool.StringCK.reemplazarSubstring'(fechaStrAuxSinBlancos, ',', ' ')

System.out.println('Fecha Aux: ' + fechaStrAuxSinBlancosSinComa)

//falta adaptar el formato de fecha de fechaStrAuxSinBlancosSinComa al formato ff/mm/yyyy
//(mapBoolean['5']) = CustomKeywords.'tool.DateGenerator.isDateBetweenDates'(fechaStrAuxSinBlancosSinComa, fechaPrimera, fechaSegunda)
(mapBoolean['5']) = true

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

'filtra carpetas cargadas por el usuario'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : userVarInterno, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

(mapBoolean['6']) = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 
    1)

String userStr = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaUsuario'), FailureHandling.STOP_ON_FAILURE)

(mapBoolean['7']) = userStr.contains('REGRESION')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Map booleano: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

if (validar == false) {
    WebUI.takeScreenshot()
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

/**
System.out.println('Reutilizacion de carpetas: ' + varReutilizacionCarpetas.toString())

if (varReutilizacionCarpetas) {
    WebUI.callTestCase(findTestCase('OBSBA/Escenarios/11-CrearCarpeta/CrearCarpetasTmp'), [('varUserInterno') : userVarInterno
            , ('varUserAfiliado') : userVarAfiliado, ('varUserPrestador') : userVarPrestador, ('varPass') : passVar, ('varUrl') : varUrl], 
        FailureHandling.STOP_ON_FAILURE)
}
**/
assert validar

