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

String tipoCarpeta = getBinding().getAt('varTipoCarpeta').toString()

String contienePago = getBinding().getAt('varContienePago').toString()

String titulo = getBinding().getAt('varTitulo').toString()

String descripcion = getBinding().getAt('varDescripcion').toString()

String tipoUsuario = getBinding().getAt('varTipoUsuario').toString()

String fecha = getBinding().getAt('varFechaPrestacion').toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : tipoCarpeta], FailureHandling.STOP_ON_FAILURE)

if (contienePago == 'true') {
    WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo' //if(tipoCarpeta== 'Bien Salud') {
            //String cuil = getBinding().getAt('varTitulo').toString()
            //String fechaPrestacion = getBinding().getAt('varDescripcion').toString()
            //String importe = getBinding().getAt('varTipoUsuario').toString()
            ) //}
        )
} else {
    WebUI.uncheck(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/chkContienePAgo'))
}

if (tipoUsuario != 'Afiliado') {
    String fechaPrestacion = getBinding().getAt('varFechaPrestacion').toString()

    String importePrestacion = getBinding().getAt('varImportePrestacion').toString()

    String cuitBeneficiario = getBinding().getAt('varCuitBeneficiario').toString()

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), Keys.chord(Keys.CONTROL, 
            'a'))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_CUIT Beneficiarioa'), cuitBeneficiario)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), Keys.chord(Keys.CONTROL, 
            'a'))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Importe de Prestacin2'), importePrestacion)

    not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Fecha de Prestacin2'), 
        2)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Fecha de Prestacin2'), Keys.chord(Keys.CONTROL, 
            'a'))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Fecha de Prestacin2'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Fecha de Prestacin2'), fecha)
}

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Titulo de carpeta'), titulo)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), descripcion)

System.out.println('Tipo de usuario: ' + tipoUsuario)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

