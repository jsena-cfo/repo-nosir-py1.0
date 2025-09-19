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

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : 'efilippo', ('password') : '12345678'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : '401 - MINISTERIO DE SALUD'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/ddMenu_Buscar'))

WebUI.click(findTestObject('BAC/Home/li_BuscarAfectacion'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/Convenio Marco/inpSolicitudDeCompra'), nroSolicitudCompra)

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Busqueda Afectacion/btnVer'))

WebUI.waitForElementClickable(findTestObject('BAC/Page_BAC - Proceso de Compra/Busqueda Afectacion/btnIngresarCompromiso'), 
    5)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Busqueda Afectacion/btnIngresarCompromiso'))

