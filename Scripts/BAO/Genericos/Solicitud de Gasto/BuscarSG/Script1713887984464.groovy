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

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : user, ('password') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/CambiarUnidadEjecutora'), [('nombreUE') : GlobalVariable.UE], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/ddMenu_Buscar'))

WebUI.click(findTestObject('BAC/Home/li_BuscarSG'))

WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Busqueda solicitud de gasto/inp_nroSG'), nroSG)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Busqueda solicitud de gasto/btnBuscarSolicitud'))

WebUI.waitForElementClickable(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnAcciones'), 5)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnAcciones'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/liAcciones', [('accion') : 'Autorizar o rechazar solicitud']))

