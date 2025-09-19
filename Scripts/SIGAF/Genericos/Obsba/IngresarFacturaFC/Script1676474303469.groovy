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

cantRows = findTestData('Data Files/IngresoFondoCompensador').getRowNumbers()

for (row = 1; row <= cantRows; row++) {
    TipoDeComprobante = findTestData('Data Files/IngresoFondoCompensador').getValue(1, row)

    NroComprobante1 = findTestData('Data Files/IngresoFondoCompensador').getValue(2, row)

    NroComprabante2 = findTestData('Data Files/IngresoFondoCompensador').getValue(3, row)

    ejercicio = findTestData('Data Files/IngresoFondoCompensador').getValue(4, row)

    nroCarpeta = findTestData('Data Files/IngresoFondoCompensador').getValue(5, row)

    unidadEjecutora = findTestData('Data Files/IngresoFondoCompensador').getValue(6, row)

    ente = findTestData('Data Files/IngresoFondoCompensador').getValue(7, row)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarCabeceraFC'), [('TipoDeComprobante') : TipoDeComprobante
            , ('NroComprobante1') : NroComprobante1, ('NroComprobante2') : NroComprabante2, ('ejercicio') : ejercicio, ('nroCarpeta') : nroCarpeta
            , ('unidadEjecutora') : unidadEjecutora, ('ente') : ente, ('fechaEmision') : '16/02/2023', ('fechaIngresoCarpeta') : '03/02/2023'
            , ('FprestacionDesde') : '31/12/2022', ('FprestacionHasta') : '31/12/2022', ('observaciones') : 'FACTURA MIGRADA DEUDA FLOTANTE 2022'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarDetallePresupuestario'), [('objetoGasto') : '6952', ('acta') : '036'
            , ('ff') : '31', ('tm') : '1', ('ug') : '1', ('fechaEmision') : '', ('fechaCarpeta') : ''], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/GuardarFactura'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/CargarEstadoIngresadoFC'), [('row') : row], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/VolverAIngresar'), [:], FailureHandling.STOP_ON_FAILURE)
}

