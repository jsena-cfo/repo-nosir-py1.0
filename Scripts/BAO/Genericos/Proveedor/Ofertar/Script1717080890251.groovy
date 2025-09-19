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

//login
WebUI.callTestCase(findTestCase('BAO/Genericos/Varios/Login'), [('user') : proveedor, ('password') : pass], FailureHandling.STOP_ON_FAILURE)

//Buscar Proceso de Compra y adquirir pliego,
BuscarPC(pliego)

Accionar('Adquirir Pliego')

WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Vista Proveedor/a_Adquirir pliego'))

//Ofertar
BuscarPC(pliego)

Accionar('Ofertar')

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/IngresarNombreOferta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/CompletarOfertas'), [('cantidad') : cantidad, ('precio') : precio
        , ('renglon') : '1'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Page_BAC - Vista Proveedor/a_SiguientePaso'))

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/IngresarReqMinimos'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/IngresarGarantias'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAO/Genericos/Proveedor/ConfirmarOferta'), [:], FailureHandling.STOP_ON_FAILURE)

def BuscarPC(String fnNroPC) {
    WebUI.click(findTestObject('BAC/Home/ddMenu_Buscar'))

    WebUI.click(findTestObject('BAO/Home/liOpcionMenu', [('opcion') : 'Buscar Proceso']))

    WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page BAC - Busqueda PC/inpNroCompra'), 
        fnNroPC)

    WebUI.click(findTestObject('BAO/Proceso de Contratacion/Busqueda Proceso/btnBuscarPCProveedor'))
}

def Accionar(String fnAccionPC) {
    WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page BAC - Busqueda PC/btn_Acciones'))

    WebUI.click(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page BAC - Busqueda PC/li_EditarPC', 
            [('accion') : fnAccionPC]))
}

