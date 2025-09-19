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

cantRows = findTestData('Data Files/FacturasObsBA').getRowNumbers()

for (row = 1; row <= cantRows; row++) {
	ejercicio = findTestData('Data Files/FacturasObsBA').getValue(1, row)

	nroCarpeta = findTestData('Data Files/FacturasObsBA').getValue(2, row)

	unidadEjecutora = findTestData('Data Files/FacturasObsBA').getValue(3, row)

	ente = findTestData('Data Files/FacturasObsBA').getValue(4, row)

	fechaEmision = findTestData('Data Files/FacturasObsBA').getValue(5, row)

	fechaCarpeta = findTestData('Data Files/FacturasObsBA').getValue(6, row)
	
	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarCabecera'), [('ejercicio') : ejercicio, ('nroCarpeta') : nroCarpeta
			, ('unidadEjecutora') : unidadEjecutora, ('ente') : ente, ('observaciones') : "FACTURA MIGRADA DEUDA FLOTANTE 2022"], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarDetallePresupuestario'), [('objetoGasto') : '6952', ('acta') : '035'
			, ('ff') : '31', ('tm') : '1', ('ug') : '1', ('fechaEmision') : fechaEmision, ('fechaCarpeta') : fechaCarpeta],
		FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/GuardarFactura'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarNroInternoTestData'), [('row') : row], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/VolverAIngresar'), [:], FailureHandling.STOP_ON_FAILURE)
}

