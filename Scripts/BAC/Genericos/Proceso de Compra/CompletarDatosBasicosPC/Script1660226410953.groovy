import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

switch (procedimiento) {
    case 'Licitación Pública':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/check_SinModalidad'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    case 'Compra Unificada':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/checkCompraUnificada'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    case 'Contratación Directa':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/check_SinModalidad'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.selectOptionByValue(findTestObject('Object Repository/BAC/Page_BAC - ContratacionDirectaPC/select_SeleccioneIncisoUrgenciaInciso'), 
            '1', false)

        WebUI.uncheck(findTestObject('Object Repository/BAC/Page_BAC - ContratacionDirectaPC/input_IncisoActaAper'))

        WebUI.uncheck(findTestObject('Object Repository/BAC/Page_BAC - ContratacionDirectaPC/input_incisoAutLla'))

        WebUI.uncheck(findTestObject('Object Repository/BAC/Page_BAC - ContratacionDirectaPC/input_IncisoAutPliego'))

        WebUI.uncheck(findTestObject('Object Repository/BAC/Page_BAC - ContratacionDirectaPC/input_IncisoComisionEvaluadora'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    case 'Contratación Menor':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/check_SinModalidad'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    case 'Convenio Marco':
        WebUI.click(findTestObject('BAC/Home/menuCrear'))

        WebUI.click(findTestObject('BAC/Home/li_CrearPC'))

        def popUpEstaPresente = WebUI.waitForElementVisible(findTestObject('BAC/Home/popup_Advertencia'), 10)

        if (popUpEstaPresente) {
            WebUI.click(findTestObject('BAC/Home/popup_Advertencia'))
        }
        
        def fechaActual = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)

        WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/inp_NombreProcesodeCompra'), 
            nombrePC + fechaActual)

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/radiobtnProcedimientoDeSeleccion', 
                [('procedimiento') : 'Licitación Pública']))

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicosConvenioMarco/check_ConvenioMarco'))

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicosConvenioMarco/input_TipoDeConvenioMarco'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    default:
        KeywordUtil.logInfo('Procedimiento desconocido')

        break
}

WebUI.waitForElementPresent(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/spanNroProcesoCompra'), 
    30)

def numeroPC = WebUI.getText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/spanNroProcesoCompra'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo(numeroPC)

return numeroPC //METODO AUX
//WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/chk_Tipo de Modalidad', [('modalidad') : modalidad]))
//WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))
//WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

def completarDatosEnComun() {
    WebUI.click(findTestObject('BAC/Home/menuCrear'))

    WebUI.click(findTestObject('BAC/Home/li_CrearPC'))

    def popUpEstaPresente = WebUI.waitForElementVisible(findTestObject('BAC/Home/popup_Advertencia'), 5)

    if (popUpEstaPresente) {
        WebUI.click(findTestObject('BAC/Home/popup_Advertencia'))
    }
    
    def fechaActual = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/inp_NombreProcesodeCompra'), 
        nombrePC + fechaActual)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/radiobtnProcedimientoDeSeleccion', 
            [('procedimiento') : procedimiento]))
}

