import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice1-Preinscripcion/InscripcionProveedorNacional'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice1-Preinscripcion/CompletarDatosProvNacional'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice2-InfoBasica/CompletarInfoBasica'), [('tipoProveedor') : tipoProveedor], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice3-PersonasLegales/CompletarPersonasLegales'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbPymeNo'))

WebUI.verifyElementNotVisible(findTestObject('RIUPP/Page_BAC - Indice 4/inpFilePyme'), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Se valida que la carga de archivo de pyme no esta disponible al seleccionar NO ES PYME')

def pathArchivo = System.getProperty('user.dir') + '\\test.pdf'

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbPymeSI'))

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 4/selectTipoPyme'), 'Micro', false)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 4/selectTipoPyme'), 'Mediana', false)

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 4/selectTipoPyme'), 'Pequeña', false)

WebUI.uploadFile(findTestObject('RIUPP/Page_BAC - Indice 4/inpFilePyme'), pathArchivo)

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/btnSubirPyme'))

