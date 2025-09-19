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

def nroObra = WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/ObtenerUltimaObra'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnCompletarDatosInd2'))

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 2/inputNumeroObraPublica'), nroObra)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnBuscar'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnAcciones'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/liAcciones', [('accion') : 'Vincular']))

WebUI.verifyTextPresent('La obra fisica ha sido vinculada satifactoriamente.', false)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnUbicacionGeografica'))

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 2/inputCalleFrenteObra'), 'test')

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 2/inputObraLatitud'), '-34.76379310735808')

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 2/inputObraLongitud'), '-58.212166498151305')

WebUI.delay(5)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnGuardar'))

WebUI.delay(1)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnGuardar'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 2/btnGuardarYVolver'))

