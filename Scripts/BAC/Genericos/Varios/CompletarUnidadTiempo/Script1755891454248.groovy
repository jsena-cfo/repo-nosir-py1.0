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
/**Marca los radiobuttons de la pagina de fecha estimada inicio contrato las unidades de tiempo de acuerdo 
 * a la opciones recibibdas:
 * -Habiles
 * -Corridos**/

String numeroUT = getBinding().getAt('numUTVar').toString()

String unidadTiempo = getBinding().getAt('unidadTiempoVar').toString()

switch (numeroUT) {
    case '1':
        if (unidadTiempo == 'habiles') {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos1'), 
                '1', false)
        } else {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos1'), 
                '2', false)
        }
        
        break
    case '2':
        if (unidadTiempo == 'habiles') {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos2'), 
                '1', false)
        } else {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos2'), 
                '2', false)
        }
        
        break
    case '3':
        if (unidadTiempo == 'habiles') {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos3'), 
                '1', false)
        } else {
            WebUI.selectOptionByValue(findTestObject('BAC/FechaEstimadaInicioContrato/select_SelectorDiasHabilesCorridos3'), 
                '2', false)
        }
        
        break
}

WebUI.delay(5)

