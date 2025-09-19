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

def mapDatosAfiliado = getBinding().getAt('varDatosAfiliado')

def mapDatosInterno = getBinding().getAt('varDatosInterno')

def mapDatosEmpleado = getBinding().getAt('varDatosEmpleado')

def mapDatosPrestador = getBinding().getAt('varDatosPrestador')

def mapDatosAdministrador = getBinding().getAt('varDatosAdministrador')

String body

Map mapP= [('pAfiliado') : '', ('pInterno') : '', ('pEmpleado') : '',
	('pPrestador') : '', ('pAdministrador') : '']


(mapP['pAfiliado'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyP'), [('varMapDatos') : mapDatosAfiliado], FailureHandling.STOP_ON_FAILURE)

(mapP['pInterno'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyP'), [('varMapDatos') : mapDatosInterno], FailureHandling.STOP_ON_FAILURE)

(mapP['pEmpleado'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyP'), [('varMapDatos') : mapDatosEmpleado], FailureHandling.STOP_ON_FAILURE)

(mapP['pPrestador'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyP'), [('varMapDatos') : mapDatosPrestador], FailureHandling.STOP_ON_FAILURE)

(mapP['pAdministrador'])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyP'), [('varMapDatos') : mapDatosAdministrador], FailureHandling.STOP_ON_FAILURE)


body = '<p><strong> Usuarios Registro Simple </strong></p>' + 
'<p><font size="5" color="#0000ff">*Usuario Afiliado </font></p>' + (mapP['pAfiliado']) + 
'<p><font size="5" color="#0000ff">*Usuario Prestador </font></p>' + (mapP['pPrestador']) +
'<p><font size="5" color="#0000ff">*Usuario Interno </font></p>' + (mapP['pInterno']) + 
'<p><font size="5" color="#0000ff">*Usuario Empleado </font></p>' + (mapP['pEmpleado']) + 
'<p><font size="5" color="#0000ff">*Usuario Administrador </font></p>' + (mapP['pAdministrador'])

return body
