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

String opcion = getBinding().getAt('varTipoPerfil').toString()

boolean presente = false

boolean visible = false

WebUI.waitForPageLoad(1)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'), 1)

WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'), 1)

WebUI.delay(1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'))

WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_QuitarTipoPerfil'), 1)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_QuitarTipoPerfil'))

WebUI.delay(1)

switch (opcion) {
    case 'afiliado':
        while (presente == false) {
            presente = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), 1, FailureHandling.OPTIONAL)

            //visible = WebUI.verifyElementVisible(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), FailureHandling.OPTIONAL)
            if (presente == false) {
                WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'))
            }
        }
        
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), 1)

        WebUI.mouseOver(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'))

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'))

        break
    case 'empleado':
        while (presente == false) {
            presente = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Empleado'), 2, FailureHandling.OPTIONAL)

            //visible = WebUI.verifyElementVisible(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), FailureHandling.OPTIONAL)
            if (presente == false) {
                WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'))
            }
        }
        
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Empleado'), 1)

        WebUI.mouseOver(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Empleado'))

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Empleado'))

        break
    case 'interno':
        while (presente == false) {
            presente = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Interno'), 2, FailureHandling.OPTIONAL)

            //visible = WebUI.verifyElementVisible(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), FailureHandling.OPTIONAL)
            if (presente == false) {
                WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'))
            }
        }
        
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Interno'), 1)

        WebUI.mouseOver(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Interno'))

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Interno'))

        break
    case 'prestador':
        while (presente == false) {
            presente = WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Prestador'), 2, FailureHandling.OPTIONAL)

            //visible = WebUI.verifyElementVisible(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Afiliado'), FailureHandling.OPTIONAL)
            if (presente == false) {
                WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/svg_Tipo de perfil'))
            }
        }
        
        WebUI.waitForElementClickable(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Prestador'), 1)

        WebUI.mouseOver(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Prestador'))

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/li_Prestador'))

        break
}

