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

def proveedor = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerProveedorInscripto'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.razonSocial = proveedor[1]

WebUI.callTestCase(findTestCase('RIUPP/Genericos/BusquedaAvanzadaProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Busqueda de Proveedor/btnDarDeBajaEval'))

WebUI.click(findTestObject('BAC/Busqueda de Proveedor/btnDarDeBajaVerde'))

WebUI.verifyTextPresent('Verifique que el campo justificación de baja de proveedor haya sido ingresado.', false)

WebUI.verifyTextPresent('Por favor verifique que todos los datos obligatorios hayan sido ingresados y estén correctos.', 
    false)

WebUI.verifyTextPresent('No es posible realizar la baja del proveedor ya que no se ha seleccionado la casilla de verificación.', 
    false)

WebUI.setText(findTestObject('BAC/Busqueda de Proveedor/txtJustificacion'), 'test')

WebUI.click(findTestObject('BAC/Busqueda de Proveedor/btnDarDeBajaVerde'))

WebUI.verifyTextPresent('No es posible realizar la baja del proveedor ya que no se ha seleccionado la casilla de verificación.', 
    false)

WebUI.check(findTestObject('BAC/Busqueda de Proveedor/chkNoGestionesPendientes'))

WebUI.click(findTestObject('BAC/Busqueda de Proveedor/btnDarDeBajaVerde'))

WebUI.verifyTextPresent('La operación dar de baja fue realizada con éxito', false)

def estado = WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.Queries/ObtenerEstadoProveedor'), [:], FailureHandling.STOP_ON_FAILURE)

assert estado == 'Dar De Baja' : 'Estado incorrecto'



