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

String opcion = getBinding().getAt('varOpcion').toString()

not_run: WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/svg_logout'), 1)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/svg_logout'))

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/button_menuHome'))

switch (opcion) {
    case 'AdministracionUsuario':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Administracin de Usuario'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Administracin de Usuario'))

        break
    case 'MiPerfil':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Mi Perfil'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Mi Perfil'))

        break
    case 'Dashboard':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Dashboard'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Dashboard'))

        break
    case 'ReporteCuentaCorriente':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Reporte Cuenta Corriente del Beneficiario'), 
            1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Reporte Cuenta Corriente del Beneficiario'))

        break
    case 'CerrarSesion':
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Cerra Sesin'), 1)

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_MenuHome/li_Cerra Sesin'))

        break
}

