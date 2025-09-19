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

WebUI.check(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/rbTipoProveedor', [('tipo') : tipoProveedor]))

WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputRazonSocial'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputCUIT'), '30716402084')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputCorreo'), 'testQA@test.com')

//WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputCorreo'), 'klonautomation@hotmail.com')
WebUI.setText(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/inputSitioWeb'), 'www.test.com.ar')

WebUI.click(findTestObject('RIUPP/Page_BAC - Sistema de compras pblicas/btnSiguiente'))

WebUI.verifyTextPresent('Alerta del Gobierno: Ese número de CUIT ya se encuentra registrado en el sistema.', false)

WebUI.closeBrowser()