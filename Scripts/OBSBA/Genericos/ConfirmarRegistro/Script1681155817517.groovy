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

String cuit = getBinding().getAt('cuit').toString()

String token= this.getBinding().getAt('varToken').toString()

boolean validar1= false

boolean validar2= false

//WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', false)

validar1= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Revise su bandeja de correo electrónico para confirmar el registro'], FailureHandling.STOP_ON_FAILURE)

String cuitSinGuiones = cuit.replaceAll('-', '')

String cuitSinBlancos = cuitSinGuiones.replaceAll('\\s', '')

System.out.println('Valor cuit: ' + cuit)

System.out.println('Valor cuit sin guiones: ' + cuitSinGuiones)

System.out.println('Valor cuit sin blancos: ' + cuitSinBlancos)

//String urlRegistro = ('https://obsba-homo.dguiaf-gcba.gov.ar/register/complete/' + cuitSinBlancos) + '/1111'

//String urlRegistro = (url + 'register/complete/' + cuitSinBlancos) + '/1111'

String urlRegistro = (url + 'register/complete/' + cuitSinBlancos) + '/' + token

System.out.println('Valor url: ' + urlRegistro)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : urlRegistro], FailureHandling.STOP_ON_FAILURE)

//WebUI.navigateToUrl(urlRegistro)
//WebUI.verifyTextPresent('Gracias por su Registro', false)

validar2= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Gracias por su Registro'], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

