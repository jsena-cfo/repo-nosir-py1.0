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

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice1-Preinscripcion/CompletarDatosProvNacional'), [('tipoProveedor') : 'Cooperativas'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/RIUPP/Page_BAC - Indice 2/btnSiguiente'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/a_Siguiente'))

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/ValidarArchivoGenerico'), [('nombreDoc') : 'Acta de designación de autoridades'
        , ('fileMax') : 15], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/ValidarArchivoGenerico'), [('nombreDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
        , ('fileMax') : 15], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/ValidarArchivoGenerico'), [('nombreDoc') : 'Estatuto Social o Contrato Constitutivo'
        , ('fileMax') : 15], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/ValidarArchivoGenerico'), [('nombreDoc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones'
        , ('fileMax') : 15], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/ValidarArchivoGenerico'), [('nombreDoc') : 'Otros Documentos'
        , ('fileMax') : 15], FailureHandling.STOP_ON_FAILURE)


