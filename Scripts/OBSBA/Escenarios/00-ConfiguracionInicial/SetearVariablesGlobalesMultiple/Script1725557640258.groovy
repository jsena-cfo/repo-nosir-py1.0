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

/**Author: Jer**/
String strUrl = getBinding().getAt('varUrl').toString()

//if (strUrl.contains('obsba-preprod.dguiaf-gcba.gov')) {
System.out.println('Se modifican las variables globales en entorno: ' + strUrl)

GlobalVariable.cuitAfiliado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'afiliado'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitPrestador = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'prestador'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitInterno = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'interno'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitEmpleado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'empleado'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitAdministrador = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'administrador'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.cuitAfiEmpInt = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpLeer'), [('varPerfil') : 'afiliadoEmpleadoInterno'
        , ('varUrl') : strUrl], FailureHandling.STOP_ON_FAILURE)
