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
WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/svg_Tipo de carpeta_consulta'), 1)

'Carga tipo de carpeta Bien Salud (no reintegro)'
WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/svg_Tipo de carpeta_consulta'))

switch (tipoCarpeta) {
    case 'BienSalud':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Bien Salud_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Bien Salud_consulta'))

        break
    case 'DireccionAccionSoc':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Direccion Accion Soc_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Direccion Accion Soc_consulta'))

        break
    case 'FondoCompensador':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Fondo Compensador_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Fondo Compensador_consulta'))

        break
    case 'FondosPermanentes':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Fondos Permanentes_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Fondos Permanentes_consulta'))

        break
    case 'FConCargosARend':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_F Con Cargos A Rend_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_F Con Cargos A Rend_consulta'))

        break
    case 'PagosVarios':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Pagos Varios_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Pagos Varios_consulta'))

        break
    case 'PrestadorComun':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Prestador Comn_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Prestador Comn_consulta'))

        break
    case 'Sanatorio':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Sanatorio_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Sanatorio_consulta'))

        break
    case 'Subsidio':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Subsidio_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Subsidio_consulta'))

        break
    case 'NotaOtros':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_NotaOtros_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_NotaOtros_consulta'))

        break
    case 'Reintegro':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Reintegro_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Reintegro_consulta'))

        break
    case 'GALegales':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_G.A. Legales_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_G.A. Legales_consulta'))

        break
    case 'DeudaFlotante':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Deuda Flotante_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Deuda Flotante_consulta'))

        break
}

