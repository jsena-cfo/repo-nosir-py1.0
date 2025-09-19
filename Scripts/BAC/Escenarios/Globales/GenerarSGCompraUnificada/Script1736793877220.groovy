import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

GlobalVariable.unidadEjecutora = '4004 - CENTRO DE SALUD 34'

def solicitud1 = WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarSolicitudDeGasto'), [('urgencia') : 'UrgenciaNormal'
        , ('item1') : '33.10.002.0355.1144', ('item2') : '33.10.002.0355.1155'], FailureHandling.STOP_ON_FAILURE)

(GlobalVariable.listaSG[0]) = solicitud1

GlobalVariable.unidadEjecutora = '4007 - CENTROS SALUD 2 12 27'

def solicitud2 = WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarSolicitudDeGasto'), [('urgencia') : 'UrgenciaNormal'
        , ('item1') : '33.10.002.0355.1144', ('item2') : '33.01.002.0034.6'], FailureHandling.STOP_ON_FAILURE)

(GlobalVariable.listaSG[1]) = solicitud2

GlobalVariable.unidadEjecutora = '4008 - CENTROS SALUD 11 45'

def solicitud3 = WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarSolicitudDeGasto'), [('urgencia') : 'UrgenciaNormal'
        , ('item1') : '33.10.002.0355.1144', ('item2') : '33.01.002.0031.1'], FailureHandling.STOP_ON_FAILURE)

(GlobalVariable.listaSG[2]) = solicitud3

GlobalVariable.unidadEjecutora = '4010 - CENTRO SALUD 36'

def solicitud4 = WebUI.callTestCase(findTestCase('BAC/Escenarios/Globales/GenerarSolicitudDeGasto'), [('urgencia') : 'UrgenciaNormal'
        , ('item1') : '33.10.002.0355.1144', ('item2') : '33.01.002.0022.5'], FailureHandling.STOP_ON_FAILURE)

(GlobalVariable.listaSG[3]) = solicitud4

for (def solicitud : GlobalVariable.listaSG) {
    KeywordUtil.logInfo(solicitud)
}

