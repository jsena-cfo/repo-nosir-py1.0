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

WebUI.callTestCase(findTestCase('BAO/Genericos/Adjudicacion/BuscarAfectacion'), [('nroProceso') : GlobalVariable.nroPC, ('UE') : 'UE: 404 - DIRECCIÓN GENERAL DE RECURSOS FÍSICOS DE SALUD,'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Adjudicacion/btnEditarImputacion'))

//Distribuir montos en proporcion 80-20

def primerResultado = calcularPorcentaje(80, monto)

WebUI.setText(findTestObject('BAO/Adjudicacion/inpMontoImputacion', [('partida') : '1']), primerResultado)

WebUI.click(findTestObject('BAO/Adjudicacion/btnIngresarDetalleMonto', [('partida') : '1']))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Agregar nueva imputacin'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/input_FechaImputacin'), GlobalVariable.fechaActual)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/inp_MontoImputacion'), primerResultado)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Aceptar'))

def segundoResultado = calcularPorcentaje(20, monto)

WebUI.setText(findTestObject('BAO/Adjudicacion/inpMontoImputacion', [('partida') : '2']), segundoResultado)

WebUI.click(findTestObject('BAO/Adjudicacion/btnIngresarDetalleMonto', [('partida') : '2']))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Agregar nueva imputacin'))

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/input_FechaImputacin'), GlobalVariable.fechaActual)

WebUI.setText(findTestObject('BAC/Page_BAC - Adjudicación/inp_MontoImputacion'), segundoResultado)

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Aceptar'))

WebUI.click(findTestObject('BAC/Page_BAC - Adjudicación/a_Guardar y Volver'))

//
WebUI.setText(findTestObject('BAO/Adjudicacion/inpClave'), GlobalVariable.pass)

WebUI.click(findTestObject('BAO/Adjudicacion/btnAutorizar'))

WebUI.verifyTextPresent('Se ha realizado correctamente la solicitud de afectación de presupuesto en SIGAF y efectuado el pase correspondiente. Se notificará al Gestor y Supervisor de Obra.', 
    false)

def calcularPorcentaje(porcentaje, numero) {
    def resultado = (porcentaje / 100) * numero
    def redondeo = Math.round(resultado * 100) / 100.0
	return redondeo.toString()
}
