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

switch (procedimiento) {
    case 'Licitación Pública':
        completarDatosEnComun()

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    case 'Contratación Directa':
        completarDatosEnComun()

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorParticular'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaSi'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPrecios'))

        WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_GuardaryVolver'))

        break
    case 'Convenio Marco':
        completarDatosEnComun()

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_MontoEstimado'), 
            '30')

        WebUI.setText(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - Info Basica Convenio Marco/input_CantidadDuracionConvenio'), 
            '30')

        WebUI.selectOptionByLabel(findTestObject('Object Repository/BAC/Page_BAC - Proceso de Compra/Page_BAC - CompletarDatosBasicosConvenioMarco/select_SeleccionarDias'), 
            'Días hábiles', false)

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorGeneral'))

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
    case 'Contratación Menor':
        completarDatosEnComun()

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaProrrogaSi'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AceptaRedeterminacionPrecios'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_InvitacionProveedorGeneral'))

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

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_EtapaUnica'))

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_AlcanceNacional'))

    WebUI.check(findTestObject('BAO/Proceso de Contratacion/Informacion Basica/radioTipoCotizacionRenglon', [('tipo') : cotizRenglones]))

    WebUI.check(findTestObject('BAO/Proceso de Contratacion/Informacion Basica/radio_AdjRenglon', [('tipo') : adjRenglones]))

    not_run: if ((procedimiento != 'Contratación Menor') && (procedimiento != 'Convenio Marco')) {
        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_TipoCotizacionMoneda'))

        WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/radio_MonedaDeCotizacin'))
    }
    
    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/option_PesoArgentino'))

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/btn_AgregarMoneda'))

    WebUI.check(findTestObject('BAO/Proceso de Contratacion/Informacion Basica/rbFormaDeEnvioInvitaciones', [('tipo') : tipoEnvio]))

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/input_CantidadDiasOferta'), cantDias)

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/select_SeleccionarTipoDias'), 
        tipoDeDias, false)

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/select_Direccion'), 
        direccion, false)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page BAC - InfoBasica/textarea_Otra_DirDoctoFisica'), 
        'Test')

    WebUI.setText(findTestObject('BAO/Proceso de Contratacion/Informacion Basica/textareaTelefonoUOA'), '123456789')

    WebUI.selectOptionByLabel(findTestObject('BAO/Proceso de Contratacion/Informacion Basica/selectTipoRedeterminacion'), 
        tipoRedet, false)
}

