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

switch (modalidad) {
    case 'Sin Modalidad':
        completarDatosEnComun()

        completarDatosPorProcedimiento()

        if (redeterminacion) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPrecios'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPreciosNo'))
        }
        
        if (prorroga) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaSi'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaNo'))
        }
        
        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    case 'Orden de Compra Abierta':
        completarDatosEnComun()

        completarDatosPorProcedimiento()

        if (prorroga) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaSi'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaNo'))
        }
        
        if (actualizacionPrecios) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_ActualizacionPreciosSi'))

            not_run: WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/inputPeriodicidad'), 
                '30')

            not_run: WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/inputDuracionPeriodicidad'), 
                '5')

            WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/ConfigurarPeriodicidad'), [:], FailureHandling.STOP_ON_FAILURE)
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_ActualizacionPreciosNo'))
        }
        
        if (redeterminacion) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPrecios'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPreciosNo'))
        }
        
        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    case 'Convenio Marco':
        completarDatosEnComun()

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/option_PesoArgentino'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_AgregarMoneda'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorGeneral'))

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_MontoEstimado'), 
            '30')

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_CantidadDuracionConvenio'), 
            '30')

        WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicosConvenioMarco/select_SeleccionarDias'), 
            'Días hábiles', false)

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_PeriodicidadCada'), 
            '15')

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_PeriodicidadCadaIncremento'), 
            '15')

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_DiasPeriodoActualizacion'), 
            '15')

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_DiasPeriodoActualizacionIncremento'), 
            '15')

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    case 'Compra Unificada':
        completarDatosEnComun()

        completarDatosPorProcedimiento()

        if (redeterminacion) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPrecios'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPreciosNo'))
        }
        
        if (prorroga) {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaSi'))
        } else {
            WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaNo'))
        }
        
        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    default:
        break
}

def completarDatosEnComun() {
    def adjCantidad = CustomKeywords.'tool.utilities.capitalize'(adjCantidad)

    def adjRenglones = CustomKeywords.'tool.utilities.capitalize'(adjRenglones)

    def cotizCantidad = CustomKeywords.'tool.utilities.capitalize'(cotizCantidad)

    def cotizRenglones = CustomKeywords.'tool.utilities.capitalize'(cotizRenglones)

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_Completar datos'))

    def etapa = CustomKeywords.'tool.utilities.capitalize'(etapa)

    if (etapa == 'Unica') {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_EtapaUnica'))
    } else if (etapa == 'Multiple') {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_EtapaMultiple'))
    }
    
    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AlcanceNacional'))

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AdjCantRenglones', [('tipo') : adjCantidad]))

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AdjRenglon', [('tipo') : adjRenglones]))

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radioTipoCotizacionCantRenglones', 
            [('tipo') : cotizCantidad]))

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radioTipoCotizacionRenglon', [('tipo') : cotizRenglones]))

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/input_CantidadDiasOferta'), '20')

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/select_SeleccionarTipoDias'), 
        'Días corridos', false)

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/select_Direccion'), 
        'Otra dirección', false)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/textarea_Otra_DirDoctoFisica'), 
        'Test')

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/textarea_TelefonoContactoUOA'), 
        '123456789')
}

def completarDatosPorProcedimiento() {
    if (((procedimiento == 'Contratación Menor') || (modalidad == 'Convenio Marco')) || (modalidad == 'Compra Unificada')) {
        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/option_PesoArgentino'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_AgregarMoneda'))
    } else {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_TipoCotizacionMoneda'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_MonedaDeCotizacin'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/option_PesoArgentino'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_AgregarMoneda'))
    }
    
    if (procedimiento == 'Contratación Directa') {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorParticular'))
    } else {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorGeneral'))
    }
}

