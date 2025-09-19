import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import java.lang.CharSequence as CharSequence
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
import java.text.DecimalFormat

String varCatalogoN1 = getBinding().getAt('varCatalogoN1').toString()

String varCatalogoN2 = getBinding().getAt('varCatalogoN2').toString()

String varCatalogoN3 = getBinding().getAt('varCatalogoN3').toString()

String varCantidad = getBinding().getAt('varCantidad').toString()

String varPrecioUnitario = getBinding().getAt('varPrecioUnitario').toString()

boolean estadoIgual

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaItems.png', 'ComprasSolicitudGasto', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItems.png', 'ComprasSolicitudGasto')

/**295**/
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inputCatalogo.png', 'ComprasSolicitudGasto', -23, 12, varCatalogoN1)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**651503**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varCatalogoN2)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**9032747**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varCatalogoN3)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

//float cantidad = 1.00
//float valor = 162198.08

DecimalFormat decimalFormat = new DecimalFormat("0.00")

System.out.println("Cantidad: " + varCantidad) 

System.out.println("Precio unitario: " + varPrecioUnitario)

double cantidad = varCantidad.toDouble()

double valor = varPrecioUnitario.toDouble()

//String cantidadDoubleText= Double.valueOf(decimalFormat.format(cantidad)).toString()

String cantidadDoubleText = String.format("%.2f", cantidad)

System.out.println("Cantidad double: " + cantidadDoubleText)

//String valorDoubleText= Double.valueOf(decimalFormat.format(valor)).toString()

String valorDoubleText = String.format("%.2f", valor)

System.out.println("Valor double: " + valorDoubleText)

//System.out.println("Valor double: " + Double.valueOf(decimalFormat.format(valor)).toString())

CustomKeywords.'tool.sikuli.ingresarInput'(screen, cantidad.toString())

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, valor.toString())

CustomKeywords.'tool.sikuli.keyTab'(screen)

double redondeo = cantidad * valor

//double montoCalculadoDosDigitos = Double.valueOf(decimalFormat.format(redondeo))

String montoCalculadoDosDigitos = String.format("%.2f", valor)

//String montoCalculado = redondeo.round(2).toString()

String montoCalculado = montoCalculadoDosDigitos.toString()

String monto = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerMontoTotalOCR'), [:], FailureHandling.STOP_ON_FAILURE)

String montoMinus = monto.minus(',' /**Se quita la comilla que separa centenas**/ )

String montoObtenido = montoMinus.trim()

/**Ingresa lugar de entrega**/
WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RellenarLugarDeEntrega'), [('varLugarEntrega') : findTestData('comprasSolicitudGastoTD').getValue(
            'colLugarEntrega', 1), ('varCantidadEntrega') : findTestData('comprasSolicitudGastoTD').getValue('colCantidadEntrega', 
            1), ('varObservaciones') : findTestData('comprasSolicitudGastoTD').getValue('colObservaciones', 1)], FailureHandling.STOP_ON_FAILURE)

String montoCalculadoStr = montoCalculado.toString().replaceAll(",", ".") //se cambia coma por punto

String montoObtenidoOCRStr = montoObtenido.toString()

System.out.println('Monto calculado: ' + montoCalculadoStr)

System.out.println('Monto obtenido: ' + montoObtenidoOCRStr)

if (montoObtenidoOCRStr.equalsIgnoreCase(montoCalculadoStr)) {
    System.out.println('El monto total es correcto')

    //assert true
} else {
    System.out.println('El monto total es incorrecto')

    //assert false
}

estadoIgual= WebUI.verifyMatch(montoObtenidoOCRStr, montoCalculadoStr, false)

assert estadoIgual== true
