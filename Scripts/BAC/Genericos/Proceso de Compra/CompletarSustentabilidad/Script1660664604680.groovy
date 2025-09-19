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

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/btnCompletarDatos'))

def requisitoSustentabilidad = CustomKeywords.'tool.utilities.capitalize'(requisitoSustentabilidad)

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/radioSustentabilidad', [('option') : requisitoSustentabilidad]))

if (requisitoSustentabilidad == 'Si') {
    def tipoRecomendaciones = CustomKeywords.'tool.utilities.capitalize'(tipoRecomendaciones)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/chkTipoDeRecomendaciones', [('option') : tipoRecomendaciones]))

    def logisticaInversaOMinima = CustomKeywords.'tool.utilities.capitalize'(logisticaInversaOMinima)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/radio_IncluyeLogistica', [('option') : logisticaInversaOMinima]))

    def embalajeReciclable = CustomKeywords.'tool.utilities.capitalize'(embalajeReciclable)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/radioLogisticaEmbalajeReciclado', [('option') : embalajeReciclable]))

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/btnGuardar y Volver'))
} else {
    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Sustentabilidad/btnGuardar y Volver'))
}