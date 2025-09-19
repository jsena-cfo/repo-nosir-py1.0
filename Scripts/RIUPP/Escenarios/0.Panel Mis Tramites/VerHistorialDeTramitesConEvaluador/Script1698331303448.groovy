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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

def proveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorInscripto'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.razonSocial = (proveedor[1])

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BusquedaAvanzadaProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Busqueda de Proveedor/btnVerHistorial'))

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




