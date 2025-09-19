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
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaItems.png', 'ComprasSolicitudGasto', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItems.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inputCatalogo.png', 'ComprasSolicitudGasto', -23, 12, '295')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '651503')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '9032747')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.delay'(1)

float cantidad = 1.00

float valor = 162198.08

CustomKeywords.'tool.sikuli.ingresarInput'(screen, cantidad.toString())

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, valor.toString())

CustomKeywords.'tool.sikuli.keyTab'(screen)

float redondeo = cantidad * valor

String montoCalculado = redondeo.round(2).toString()

String monto = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerMontoTotalOCR'), [:], FailureHandling.STOP_ON_FAILURE)

String montoMinus = monto.minus(',' /**Se quita la comilla que separa centenas**/ )

String montoObtenido = montoMinus.trim()

/**Ingresar lugar de entrega**/
WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RellenarLugarDeEntrega'), [:], FailureHandling.STOP_ON_FAILURE)

String montoCalculadoStr = montoCalculado.toString()

String montoObtenidoStr = montoObtenido.toString()

System.out.println('Monto calculado: ' + montoCalculadoStr)

System.out.println('Monto obtenido: ' + montoObtenidoStr)

if (montoObtenidoStr.equalsIgnoreCase(montoCalculadoStr)) {
    System.out.println('El monto total es correcto')

    assert true
} else {
    System.out.println('El monto total es incorrecto')

    assert false
}

