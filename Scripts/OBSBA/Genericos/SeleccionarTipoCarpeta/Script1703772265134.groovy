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

String tipoCarpeta = getBinding().getAt('varTipoCarpeta').toString()

'Carga tipo de carpeta Bien Salud (no reintegro)'
WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Tipo de carpeta'), 1)

'Carga tipo de carpeta Bien Salud (no reintegro)'
WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Tipo de carpeta'))

switch (tipoCarpeta) {
    case 'BienSalud':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Bien Salud'))

        break
    case 'DireccionAccionSoc':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Direccion Accion Soc'))

        break
    case 'FondoCompensador':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Fondo Compensador'))

        break
    case 'FondosPermanentes':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Fondos Permanentes'))

        break
    case 'FConCargosARend':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_F Con Cargos A Rend'))

        break
    case 'PagosVarios':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Pagos Varios'))

        break
    case 'PrestadorComun':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Prestador Comn'))

        break
    case 'Sanatorio':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Sanatorio'))

        break
    case 'Subsidio':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Subsidio'))

        break
    case 'NotaOtros':
        //WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/input_Tipo de carpeta_folderType'), 'nota')
        //WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/input_Tipo de carpeta_folderType'), Keys.chord(
        //		Keys.DOWN))
        //WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/input_Tipo de carpeta_folderType'), Keys.chord(
        //		Keys.ENTER))
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_NotaOtros'))

        break
    case 'Reintegro':
        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_Reintegro'))

        break
}

