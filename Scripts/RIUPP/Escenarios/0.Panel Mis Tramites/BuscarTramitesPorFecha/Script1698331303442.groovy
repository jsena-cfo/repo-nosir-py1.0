import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

def datos = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorConTramite'), [:], FailureHandling.STOP_ON_FAILURE)

def userLogin = datos[0]

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : userLogin, ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/menuMisTramites'))

def fechaHace30Dias = CustomKeywords.'tool.DateGenerator.dateNDaysBeforeToday'(30)

WebUI.setText(findTestObject('BAC/Menu Mis Tramites/inputFechaDesde'), fechaHace30Dias)

WebUI.setText(findTestObject('BAC/Menu Mis Tramites/inputFechaHasta'), GlobalVariable.fechaActual)

WebUI.click(findTestObject('BAC/Menu Mis Tramites/btnBuscar'))

TestObject testObj = findTestObject('BAC/Menu Mis Tramites/tableListaTramites')

List<WebElement> tramitesProveedor = WebUI.findWebElements(testObj, 10)

//AGREGAR PARA IMPRIMIR LOS RESULTADOS LUEGO DEL BUCLE PARA MEJOR VISUALIZACION DEL OUTPUT
for (int i = 1; i <= tramitesProveedor.size(); ++i) {
    def driver = DriverFactory.getWebDriver()

    def nroTramite = driver.findElement(By.xpath(('(//table[contains(@id,\'ListaTramites\')]//a[contains(@id,\'NumeroTramite\')])[' + 
            i) + ']')).getText()

    println('Nro Tramite encontrado: ' + nroTramite)
}



