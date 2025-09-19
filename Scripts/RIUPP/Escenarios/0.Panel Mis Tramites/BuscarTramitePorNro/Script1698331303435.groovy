import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import internal.GlobalVariable as GlobalVariable

def datos = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorConTramite'), [:], FailureHandling.STOP_ON_FAILURE)

def userLogin = datos[0]

def nroTramiteQuery = datos[1]

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userLogin, ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuMisTramites'))

WebUI.setText(findTestObject('BAC/Menu Mis Tramites/inputNumeroTramite'), nroTramiteQuery)

WebUI.click(findTestObject('BAC/Menu Mis Tramites/btnBusquedaRapida'))

try {
    def driver = DriverFactory.getWebDriver()

    def tramite = driver.findElement(By.xpath('//table[contains(@id,\'ListaTramites\')]//a[contains(@id,\'NumeroTramite\')]')).getText()

    assert tramite == nroTramiteQuery : 'Tramite no encontrado'

    KeywordUtil.logInfo(('Busqueda realizada. Tramite ' + nroTramiteQuery) + ' encontrado')
}
catch (Exception ex) {
    KeywordUtil.markFailed(('Tramite \'' + nroTramiteQuery) + '\' no encontrado')
} 

