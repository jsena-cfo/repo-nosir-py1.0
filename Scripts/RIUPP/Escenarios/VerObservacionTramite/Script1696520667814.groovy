import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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

WebUI.callTestCase(findTestCase('RIUPP/Escenarios/RechazarClase'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : GlobalVariable.proveedorInscripto, ('password') : '12345678'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuMisTramites'))

WebUI.setText(findTestObject('BAC/Menu Mis Tramites/inputNumeroTramite'), GlobalVariable.nroTramiteEval)

WebUI.click(findTestObject('BAC/Menu Mis Tramites/btnBusquedaRapida'))

def driver = DriverFactory.getWebDriver()

def nroTramite = driver.findElement(By.xpath('//table[contains(@id,\'ListaTramites\')]//a[contains(@id,\'NumeroTramite\')]')).click()

WebUI.verifyTextPresent(observacion, false)

