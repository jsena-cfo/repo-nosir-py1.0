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

'El script ClickVolverRegistroFinalizar se utiliza para volver de la pantalla que indica "Gracias por su registro" y'

'El script ClickVolverRegistro se utiliza para volver de la pantalla "Registro Revise su bandeja de correo electrónico para confirmar el registro"'

'Parecería que son el mismo botón pero el del script ClickVolverRegistro es del tipo Submit y el del script ClickVolverRegistroFinalizar es del tipo Button por eso se utilizan 2 scripts diferentes'
WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_RegistroVOLVERButton'), 2)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_RegistroVOLVERButton'))

