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
import org.openqa.selenium.Keys as Keys

String varUsuario = getBinding().getAt('varUsuario').toString()

String varPassword = getBinding().getAt('varPassword').toString()

String varNumeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

String varNumeroActa = getBinding().getAt('varNumeroActa').toString()

varNumeroActa = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GenerarActaApertura'), [('varUsuario') : varUsuario
        , ('varPassword') : varPassword, ('varNumeroContratacion') : varNumeroContratacion], FailureHandling.STOP_ON_FAILURE)

String numeroActaNorm = varNumeroActa.trim()

System.out.println('Numero de acta obtenido: ' + numeroActaNorm)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GenerarOferta'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion', ('varNumeroActa') : numeroActaNorm, ('varNumeroContratacion') : varNumeroContratacion], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/04-Evaluacion/GenerarDictamenEvaluacion'), [('varUsuario') : varUsuario
        , ('varPassword') : varPassword, ('varRol') : 'ejecucion', ('varNumeroContratacion') : varNumeroContratacion, ('varNumeroActa') : numeroActaNorm], 
    FailureHandling.STOP_ON_FAILURE)

