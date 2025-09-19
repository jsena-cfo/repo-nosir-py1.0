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

boolean completarFechaEstimadaInicioContrato = false

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/btn_CompletarDatos'))

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/input_MontoContrato'), monto)

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/radio_DatosInformacion'))

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/input_DiasDuracionContrato'), duracion)

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/select_SeleccionarDiasSemanas'), 
    tiempo, false)

if (completarFechaEstimadaInicioContrato == true) {
    CustomKeywords.'tool.Logger.log'('La OCA generada no puede usarse para ejecutar la suite de ActualizacionPrecios')

    WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CompletarFechaEstimadaInicioContrato'), [('opcionVar') : 'APartirDiasPerfeccioanmiento'
            , ('cantidadDiasVar') : '5', ('unidadTiempoVar') : 'habiles'], FailureHandling.STOP_ON_FAILURE)
} else {
    CustomKeywords.'tool.Logger.log'('La OCA generada puede usarse para ejecutar la suite de ActualizacionPrecios')

    CustomKeywords.'tool.Logger.log'('Se ingresa a opcion "Desde el perfeccionamiento del documento contractual"')
}

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - MontoYDuracion/btn_GuardaryVolver'))

