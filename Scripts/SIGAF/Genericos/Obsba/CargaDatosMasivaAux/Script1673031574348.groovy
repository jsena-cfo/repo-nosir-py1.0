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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPassword').toString()

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/LoginObsba'), [('varUsuario') : usuario, ('varPassword') : password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

Map mapGlobal = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/ObtenerMapXlsAux'), [:], FailureHandling.STOP_ON_FAILURE)

// Range is also a list and can be used here.
def rangoCabecera = ('1'..'10')

def rangoDetalle = ('11'..'15')

//int cantidadFilas= mapGlobal.size()
//for (def index : (1..cantidadFilasXls)) {
System.out.println('Tamaño map: ' + mapGlobal.size())

for (def fila : mapGlobal) {
    Map mapAux = [:]

    Map mapAuxCabecera = [:]

    Map mapAuxDetalle = [:]

    //Map mapFilaAux = mapGlobal.get(index)
    //Map mapFilaAux = (Map) fila.getValue()
    mapAux = fila.getValue()

    //println(mapAux['col1'])
    mapAuxCabecera = mapAux.subMap(rangoCabecera)

    mapAuxDetalle = mapAux.subMap(rangoDetalle)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarCabeceraAux'), [('varMapFila') : mapAuxCabecera], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarDetallePresupuestarioAux'), [('varMapFila') : mapAuxDetalle], 
        FailureHandling.STOP_ON_FAILURE)
}

assert true

