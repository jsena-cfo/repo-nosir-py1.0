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

boolean validar= false

String tipoCarpeta = getBinding().getAt('varTipoCarpeta').toString()

String cuil = getBinding().getAt('varCuil').toString()

String valorRandom = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

'Carga tipo de carpeta Bien Salud (no reintegro)'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoCarpeta'), [('varTipoCarpeta') : tipoCarpeta], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarCheckDesactivadoChequear'), [:], FailureHandling.STOP_ON_FAILURE)

if (tipoCarpeta != 'Reintegro') {
    WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'))

    String fecha = '06/2023'

    WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 'value', 
        'MM-YYYY', 1, FailureHandling.CONTINUE_ON_FAILURE)

    String cuilConGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.agregarGuionesCuil'(cuil)

    //System.out.println("Cuil con guiones: " + cuilConGuiones)
    WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), 'value', 
        cuilConGuiones, 1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementAttributeValue(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), 'type', 
        'number', 1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.CONTROL, 
            'a'))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), fecha)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), '100,11')

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_TituloCarpetaMod'), 'titulo' + valorRandom)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_DescripcionCarpetaMod'), 'descripcion' + valorRandom //def inputDesactivado = WebUI.getAttribute(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_CUITBenefPago'), 'disabled')
        //WebUI.verifyMatch(inputDesactivado, 'true', true)
        )
} else {
    System.out.println('Carpeta de tipo reintegro, valida que no se muestran campos')

    WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_FechaPrestacion'), 2, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ImportePrestacion'), 2, FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ReintegroTituloCarpeta'), 'tituloReintegro' + 
        valorRandom)

    WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/input_ReintegroDescripcionCarpeta'), 'descripcionReintegro' + 
        valorRandom)
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/div_CarpetaCreadaExito'), 1)

//validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/p_CarpetaCreadaExito'), 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!')

validar= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarMensajeModalTexto'), [('varTexto') : 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

return validar
