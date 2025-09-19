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

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice4'))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

if (tipoProveedor == 'Persona jurídica extranjera sin sucursal') {
    
    WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [
            ('tipoDoc') : 'Otros documentos', ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptoDDJJ'))
	
	WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptacionUsoSistema'))
	
	WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkDDJJDatosReales'))

    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))
} else {

    WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [
            ('tipoDoc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones', ('nombreArchivo') : 'test.pdf'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [
            ('tipoDoc') : 'Otros Documentos', ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptoDDJJ'))

    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))
}