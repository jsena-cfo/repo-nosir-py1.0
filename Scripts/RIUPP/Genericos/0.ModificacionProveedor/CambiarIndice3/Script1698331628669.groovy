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

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnEditarIndice3'))

def tipoProveedor = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtTipoProveedor'))

if (tipoProveedor == 'Persona humana') {
    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/Indice3/btnModificarPH'))

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCalle'), 'test mod')

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNumero'), '4321')

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCodigoPostal'), '4321')

    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/Indice3/btnGuardarCambios'))
	
	WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))
} else {
    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/Indice3/btnModificarAdminLeg'))

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNombre'), 'Test')

    WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputApellido'), 'Modificacion')

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btn_Agregar'))

    WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))
}

