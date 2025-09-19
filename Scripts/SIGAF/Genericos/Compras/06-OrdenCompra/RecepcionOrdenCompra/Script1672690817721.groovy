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
import internal.GlobalVariable as GlobalVariable

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAceptar.png', 'ComprasOrdenCompra', 25)

String diaHoy = CustomKeywords.'tool.DateGenerator.today'()

CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.delay'(3)

String numeroOrden = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/ObtenerTextoRegionOCR'), [('varX') : '309', ('varY') : '203'
        , ('varW') : '83', ('varH') : '13'], FailureHandling.STOP_ON_FAILURE)

String numeroOrdenNormalizado = numeroOrden.toString().trim()

System.out.println('Numero Orden compra: ' + numeroOrdenNormalizado)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '318', ('varY') : '206', ('varW') : '12', ('varH') : '8'], 
    FailureHandling.STOP_ON_FAILURE)

if (!(numeroOrdenNormalizado.equals(''))) {
    System.out.println('Hay numero de orden')

    def mapDatos = [('numeroOrden') : numeroOrdenNormalizado]

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/GuardarDatosXlsUnico'), [('varPathXls') : 'Xls/datosXls.xlsx'
            , ('varHoja') : 'Hoja7OCRE', ('varDatos') : mapDatos], FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'ComprasOrdenCompra')
}

