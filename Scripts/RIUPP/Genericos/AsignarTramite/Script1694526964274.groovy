import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BuscarTramitePorRazonSocial'), [('user') : 'fciorcia', ('pass') : '12345678'
        , ('razonSocial') : GlobalVariable.razonSocial], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnAccionesTramite', [('tramite') : GlobalVariable.nroTramiteEval]))

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/liAcciones', [('tramite') : GlobalVariable.nroTramiteEval
            , ('accion') : 'Asignar']))

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/selectUserEvaluador'), userEvaluador, 
    false)

WebUI.click(findTestObject('RIUPP/Page_BAC - Panel de Tramites RIUPP-CAP/btnModificar'))

