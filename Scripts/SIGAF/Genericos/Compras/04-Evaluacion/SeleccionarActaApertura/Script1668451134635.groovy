import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String numeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Se selecciona acta mediante numero de contratacion**/
String filtroBusqueda= "%PL%230%Decreto N° 433/16%"+numeroContratacion+"%"+CustomKeywords.'tool.DateGenerator.currentYear'()+"%"
//CustomKeywords.'tool.sikuli.ingresarInput'(screen, filtroBusqueda)
CustomKeywords.'tool.robot.type'(filtroBusqueda)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Se cierra modal Hora apertura incompleto**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalHoraAperturaIncompleto.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarHoraIncompleto.png', 'ComprasEvaluacion')

/**Validar si aparece modal error clipboard**/
if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalErrorClipboard.png', 'ComprasEvaluacion', 2)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
}

/**Se carga Hora hasta**/
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.robot.type'('20:00')

CustomKeywords.'tool.sikuli.delay'(2)

/**Validar si aparece modal error clipboard**/
if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalErrorClipboard.png', 'ComprasEvaluacion', 2)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpHoraHastaDC.png', 'ComprasEvaluacion')
	CustomKeywords.'tool.robot.type'('19:00')
}

/**Ingreso solapa Datos del acta Cont**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosActaCont.png', 'ComprasEvaluacion')

/**Se ingresa pliegos vedidos**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Se ingresa presentes en el acto**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'TEXTO INGRESADO')

/**Ingreso solapa Detalles sobres**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDetalleSobres.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ingresa CUIT**/ //30-61025233-4
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '20-04221894-5') 

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**carga Monto oferta**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '100.00'  )

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**selecciona la moneda **/
CustomKeywords.'tool.sikuli.keyEnter'(screen )

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Si aparece el error de moneda, presiona el boton Aceptar del modal**/
if(CustomKeywords.'tool.sikuli.existeImg'(screen,  'modalErrorMoneda.png', 'ComprasEvaluacion', 5)) {
	System.out.println("Se desplego el modal de error moneda")
	CustomKeywords.'tool.sikuli.clickImg'(screen,'btnAceptarHoraIncompleto.png', 'ComprasEvaluacion')
}

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/IngresarGarantias'), [:], FailureHandling.STOP_ON_FAILURE)

/**Ingreso solapa Datos del acta**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosActa.png', 'ComprasEvaluacion')

