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

int dniDesde= 10000000
int dniHasta= 10000015
String ultimoDni = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/ValidarUsuariosInsertadosBD'), 
    [:], FailureHandling.STOP_ON_FAILURE)

if (ultimoDni == '00000000') {
    WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/InsertarUsuariosSigafBD'), [('varInsertarDesde') : dniDesde
            , ('varInsertarHasta') : dniHasta], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/GenerarXlsUsuariosDinamicos'), [('varGenerarDesde') : dniDesde.toString()
            , ('varGenerarHasta') : dniHasta.toString()], FailureHandling.STOP_ON_FAILURE)
} else {
    int siguienteDni = ultimoDni.toInteger() + 1

    int limiteDni = siguienteDni + 15
	
	String cuilDesde= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', siguienteDni.toString())
	
	String cuilHasta= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', limiteDni.toString())

    WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/InsertarUsuariosSigafBD'), [('varInsertarDesde') : siguienteCuit
            , ('varInsertarHasta') : ultimoCuit], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/GenerarXlsUsuariosDinamicos'), [('varGenerarDesde') : siguienteCuit
            , ('varGenerarHasta') : ultimoCuit], FailureHandling.STOP_ON_FAILURE)
}

