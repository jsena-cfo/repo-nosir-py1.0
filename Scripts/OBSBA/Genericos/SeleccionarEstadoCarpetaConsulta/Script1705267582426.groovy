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

String estadoCarpeta = getBinding().getAt('varEstado').toString()

WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/svg_Estado de carpeta_consulta'), 
    1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/svg_Estado de carpeta_consulta'))

switch (estadoCarpeta) {
    case 'En Ingreso':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/li_En Ingreso_consulta'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_En Ingreso_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_En Ingreso_consulta'))

        break
    case 'Archivada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Archivada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Archivada_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Archivada_consulta'))

        break
    case 'Auditada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Auditada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Auditada_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Auditada_consulta'))

        break
    case 'Confirmada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Confirmada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Confirmada_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Confirmada_consulta'))

        break
    case 'En Liquidacion':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_En Liquidacion'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_En Liquidacion_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_En Liquidacion_consulta'))

        break
    case 'Ingresada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Ingresada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Ingresada_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Ingresada_consulta'))

        break
    case 'Pagada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Pagada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Pagada_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Pagada_consulta'))

        break
    case 'Rechazada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Rechazada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Rechazada_consulta'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Rechazada_consulta'))

        break
    case 'Verificada':
        //WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_NuevaCarpeta/li_Verificada'))
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Verificada_consulta'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarCarpeta/li_Verificada_consulta'))

        break
}

