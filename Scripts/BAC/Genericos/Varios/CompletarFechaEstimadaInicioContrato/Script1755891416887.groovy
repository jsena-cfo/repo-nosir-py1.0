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
/**Marca los radiobuttons de la pagina de fecha estimada inicio contrato de acuerdo a la opciones recibibdas:
 * -Dentro dias perfecccionamiento
 * -A Partir de x Dias de Perfeccioanmiento
 * -A Partir de Mes Siguiente de Perfeccioanmiento
 * NOTA: Se debe deshabilitar cuando se quiere ejecutar con la oca generada la suite de 
 * Actualizacion de precios**/

String opcion = getBinding().getAt('opcionVar').toString()

String cantidadDias = getBinding().getAt('cantidadDiasVar').toString()

String unidadTiempo = getBinding().getAt('unidadTiempoVar').toString()

WebUI.scrollToElement(findTestObject('BAC/FechaEstimadaInicioContrato/input_radioApartirDelLosDelMesSiguienteAlPerfeccionamiento'), 
    2)

System.out.println("Opcion: " + opcion)

switch (opcion) {
    case 'DentroDiasPerfeccionamiento':
        'Dentro de los dias del perfeccionamiento del Documento Contractua'
        WebUI.click(findTestObject('BAC/FechaEstimadaInicioContrato/input_radioDentroDeLosDelPerfeccionamiento'))

        WebUI.setText(findTestObject('BAC/FechaEstimadaInicioContrato/input_CantidadDiasRadio1'), cantidadDias)

        WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CompletarUnidadTiempo'), [('numUTVar') : '1', ('unidadTiempoVar') : unidadTiempo], 
            FailureHandling.STOP_ON_FAILURE)

        break
    case 'APartirDiasPerfeccioanmiento':
        WebUI.click(findTestObject('BAC/FechaEstimadaInicioContrato/input_radioAPartirDelLosDelPerfeccionamiento'))

        WebUI.setText(findTestObject('BAC/FechaEstimadaInicioContrato/input_CantidadDiasRadio2'), cantidadDias)

        WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CompletarUnidadTiempo'), [('numUTVar') : '2', ('unidadTiempoVar') : unidadTiempo], 
            FailureHandling.STOP_ON_FAILURE)

        break
    case 'APartirMesSiguientePerfeccioanmiento':
        WebUI.click(findTestObject('BAC/FechaEstimadaInicioContrato/input_radioApartirDelLosDelMesSiguienteAlPerfeccionamiento'))

        WebUI.setText(findTestObject('BAC/FechaEstimadaInicioContrato/input_CantidadDiasRadio3'), cantidadDias)

        WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CompletarUnidadTiempo'), [('numUTVar') : '3', ('unidadTiempoVar') : unidadTiempo], 
            FailureHandling.STOP_ON_FAILURE)

        break
}

