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

String varNumeroActa = getBinding().getAt('varNumeroActa').toString()

Screen screen = new Screen()

/**Seleccionar acta autorizada**/
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

//String filtroBusqueda = ((CustomKeywords.'tool.DateGenerator.currentYear'() + '%') + varNumeroActa) + '%1%1'

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'().toString()

String filtroBusqueda= "%"+ anioActual +"%"+ varNumeroActa +"%1%1%" + "proveedor uno%"

System.out.println("Filtro de busqueda oferta: " + filtroBusqueda)

//CustomKeywords.'tool.sikuli.ingresarInput'(screen, filtroBusqueda)

CustomKeywords.'tool.robot.type'(filtroBusqueda)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Carga de datos**/
/**Carga plazo de entrega**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Lunes a viernes 09hs a 18hs')

/**Carga tipo moneda**/
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Ingreso solapa Datos del acta Cont**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOfertaCont.png', 'ComprasEvaluacion')

/**Ingreso solapa Renglones oferta**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaRenglonesOferta.png', 'ComprasEvaluacion')

/**Click boton Items Pliego**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnItemsPliego', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnItemsPliego', 'ComprasEvaluacion')

/**Ingreso importe unitario**/
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '90')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ingreso lugar de entrega**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnLugaresEntrega', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnLugaresEntrega', 'ComprasEvaluacion')

/**Lugar entrega**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Plazo entrega**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '5')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Cantidad**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Observacion**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto observacion')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLugar.png', 'ComprasEvaluacion')

/**Ingreso solapa Datos del acta**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOferta.png', 'ComprasEvaluacion')

