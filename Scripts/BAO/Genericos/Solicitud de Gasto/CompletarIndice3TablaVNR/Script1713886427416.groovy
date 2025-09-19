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

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 3/btnCompletarDatosTablaVNR'))

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 3/btnIngresarTabla'))

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 3/inputNombreTabla'), tabla)

WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 3/selectDescripcionRubro'), 'Inodoro de calidad inferior @INDEC', 
    false)

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 3/textareaRubros'), 'test')

WebUI.setText(findTestObject('BAO/Solicitud de Gasto/Indice 3/inputPorcentaje'), '100')

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 3/btnGuardar'))

WebUI.selectOptionByLabel(findTestObject('BAO/Solicitud de Gasto/Indice 3/selectTablaCreada'), tabla, false)

WebUI.click(findTestObject('BAO/Solicitud de Gasto/Indice 3/btnGuardar y volver'))

