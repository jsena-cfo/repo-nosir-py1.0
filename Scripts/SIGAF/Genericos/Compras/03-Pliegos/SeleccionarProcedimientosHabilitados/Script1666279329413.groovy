import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String numeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RealizarEjecutarConsulta'), [('varNumeroContratacion') : numeroContratacion], 
    FailureHandling.STOP_ON_FAILURE)

def mapHorarios = [:]

mapHorarios = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RellenarDatosContratacion'), [:], FailureHandling.STOP_ON_FAILURE)

String horario = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RellenarDatosContratacionCont'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RellenarClausula'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RellenarItems'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RealizarIngresoCompleto'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/RealizarAutorizacion'), [:], FailureHandling.STOP_ON_FAILURE)

(mapHorarios['HorarioInicio']) = horario

return mapHorarios

