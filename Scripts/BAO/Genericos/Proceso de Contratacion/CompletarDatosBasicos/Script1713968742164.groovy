import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

switch (procedimiento) {
    case 'Licitación Pública':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/check_SinModalidad'))

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
    case 'Licitación Pública Abreviada':
        completarDatosEnComun()

        WebUI.check(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/check_SinModalidad'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/optionEncuadreLegal'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/btnEncuadreSeleccionado'))

        WebUI.click(findTestObject('BAC/Home/btn_Siguiente Paso'))

        break
    case 'Contratación de la obra pública estandarizada':
        WebUI.click(findTestObject('BAC/Home/menuCrear'))

        WebUI.click(findTestObject('BAC/Home/li_CrearPC'))

        def popUpEstaPresente = WebUI.waitForElementPresent(findTestObject('BAC/Home/popup_Advertencia'), 10)

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

return numeroPC

def completarDatosEnComun() {
    WebUI.click(findTestObject('BAO/Home/opcionMenu', [('opcion') : 'Crear']))

    WebUI.click(findTestObject('BAO/Home/liOpcionMenu', [('opcion') : 'Crear Proceso de Contratación']))
    
    def fechaActual = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/inp_NombreProcesodeCompra'), 
        nombrePC + fechaActual)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicos/radiobtnProcedimientoDeSeleccion', 
            [('procedimiento') : procedimiento]))
}

