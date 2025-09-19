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

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/btnNuevaCarpeta'))

/***
 * VALORES POSIBLES PARA TIPO DE CARPETA:
 * Bien Salud
 * Direccion Accion Soc
 * Fondo Compensador
 * Fondos Permanentes
 * F Con Cargos A Rend.
 * Nota/otros
 * Prestador Común
 * Reintegro
 * Subsidio 
 * ***/
not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/inputTipoCarpeta'), Keys.chord(Keys.BACK_SPACE))

not_run: WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/inputTipoCarpeta'), tipoCarpeta)

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/inputTipoCarpeta'), Keys.chord(Keys.DOWN + Keys.ENTER))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : tipoCarpeta], FailureHandling.STOP_ON_FAILURE)

if (contienePago == true) {
    WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Titulo'), titulo)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion'))

WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_Descripcion'), descripcion)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/button_Guardar'))

