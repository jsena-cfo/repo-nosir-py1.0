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

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/Indice3/btnModificarAdminLeg'))

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNombre'), 'Test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCorreoElectronico'), 'Modificacion@test.com.ar')

WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/selectPais'), 'Argentina', 
    false)

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCalle'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputNumero'), '1234')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputPiso'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputDepartamento'), 'test')

WebUI.setText(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputCodigoPostal'), '1234')

WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/inputMontoLimiteOfertar'))

WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 3/Administrador legitimado/btn_Agregar'))

WebUI.click(findTestObject('RIUPP/Modificar Datos Proveedor/btnGuardar'))

