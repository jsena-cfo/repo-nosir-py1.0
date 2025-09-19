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
/**Valida los filtros probando todos los valores en los campos con selector
 * Valida selectores tipo carpeta y estado**/

boolean validar = false

def mapBoolean

mapBoolean = [('1') : false, ('2') : false]

def mapBooleanTipos

mapBooleanTipos = [('1') : false, ('2') : false, ('3') : false, ('4') : false, 
	('5') : false, ('6') : false, ('7') : false]

def mapBooleanEstados

mapBooleanEstados = [('1') : false, ('2') : false, ('3') : false, ('4') : false, 
	('5') : false, ('6') : false, ('7') : false, ('8') : false, ('9') : false]

'Login con usuario interno'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : userVar, ('Contrasena') : passVar], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

'filtra por todos los tipos de carpeta'
String[] tipos = ['BienSalud', 'DireccionAccionSoc', 'FConCargosARend', 
	'FondoCompensador', 'NotaOtros', 'Reintegro', 'Subsidio']

int indexTipo = 1

for (String tipo : tipos) {
    println('Tipo de carpeta: ' + tipo)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : ''
            , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : tipo, ('varEstadoCarpeta') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 1)

	String tipoStr= WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaTipoCarpeta'))
	
	String tipoStrFormat= CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(tipoStr)
	
	//tipoStrFormat= CustomKeywords.'tool.StringCK.quitarCaracteres'(tipoStrFormat, ".")
	
	//el tipo nota se escribe Nota/Otros
	tipoStrFormat= CustomKeywords.'tool.StringCK.quitarCaracteres'(tipoStrFormat, "/")

	String tipoStrCompare= CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(tipo.toString().toUpperCase())
	
	System.out.println("Valor tipoStrFormat: " + tipoStrFormat)
	
	System.out.println("Valor tipoStrCompare: " + tipoStrCompare)
	
	//(mapBooleanTipos[indexTipo.toString()]) = (tipoStrFormat== tipoStrCompare) 
    (mapBooleanTipos[indexTipo.toString()]) = tipoStrFormat.contains(tipoStrCompare)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

    indexTipo = (indexTipo + 1)
}

'filtra por todos los estados'
String[] estados = ['Archivada', 'Auditada', 'Confirmada', 'En Ingreso', 
	'En Liquidacion', 'Ingresada', 'Pagada', 'Rechazada'
    , 'Verificada']

//int cantEstados = 0
int indexEstado = 1

for (String estado : estados) {
    println('Estado de carpeta: ' + estado)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : ''
            , ('varFechaDesde') : '', ('varFechaHasta') : '', ('varCuil') : '', ('varTipoCarpeta') : '', ('varEstadoCarpeta') : estado], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_carpetaPrimeraDos'), 1)

    //(mapBooleanEstados[indexEstado])= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaEstado'), estado.toString())

	String estadoStr= WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/div_primeraCarpetaEstado'))
	
	String estadoStrFormat= CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(estadoStr)
	
	String estadoStrCompare= CustomKeywords.'tool.StringCK.quitarGuionesyBlancos'(estado.toString().toUpperCase())
	
	System.out.println("Valor estadoStrFormat: " + estadoStrFormat)
	
	System.out.println("Valor estadoStrCompare: " + estadoStrCompare)
	
	(mapBooleanEstados[indexEstado.toString()]) = (estadoStrFormat== estadoStrCompare)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

    //cantEstados = (cantEstados + 1)
    indexEstado = (indexEstado + 1)
}

//(mapBoolean['1']) = (cantTipos == tipos.length)
(mapBoolean['1']) = !(mapBooleanTipos.containsValue(false))

//(mapBoolean['2']) = (cantEstados == estados.length)
(mapBoolean['2']) = !(mapBooleanEstados.containsValue(false))

System.out.println('Map booleano tipos: ' + mapBooleanTipos)

System.out.println('Map booleano estados: ' + mapBooleanEstados)

System.out.println('Map booleano: ' + mapBoolean)

validar = !(mapBoolean.containsValue(false))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validar