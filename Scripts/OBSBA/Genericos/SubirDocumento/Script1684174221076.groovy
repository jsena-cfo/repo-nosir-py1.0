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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String titulo = getBinding().getAt('varTitulo').toString()

String descripcion = getBinding().getAt('varDescripcion').toString()

String pathFile = getBinding().getAt('varPathFile').toString()

String usuario = getBinding().getAt('varUsuario').toString()

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_Subir Archivo'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_Subir Archivo'), 1)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoDocumento'), [('varTipoDocumento') : 'receta'], FailureHandling.STOP_ON_FAILURE)

System.out.println('Usuario rol: ' + usuario)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarCheckVisibleDocInternoChequear'), [('varUsuarioRol') : usuario], FailureHandling.STOP_ON_FAILURE)

not_run: if (usuario == 'Interno') {
    //WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/chk_Visible_documento'))
    not_run: WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/chk_Visible_documento'), FailureHandling.OPTIONAL)
}

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), titulo)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/textarea_Observaciones_fileDescription'), descripcion)

//WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'), pathFile)
//WebUI.uploadFile(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'), pathFile)
TestObject to = new TestObject()

String spanSubirArchivo1 = '//div[@id=\'root\']/main/div[2]/form[2]/div/div[6]/label/span'

String spanSubirArchivo2 = ((('//div[@id=' + '\'') + 'root') + '\'') + ']/div/main/div/form[2]/div/div[6]/label/span'

String spanSubirArchivo3 = ((((((((((((((('//span[@role = ' + '\'') + 'button') + '\'') + ' and (text() = ') + '\'') + 'Subir Archivo') + 
'\'') + ' or . = ') + '\'') + 'Subir Archivo') + '\'') + ' or . = ') + '\'') + 'SUBIR ARCHIVO') + '\'') + ')]'

to.addProperty('xpath', ConditionType.EQUALS, spanSubirArchivo3)

//CustomKeywords.'tool.UploadFile.uploadFile'(to, pathFile)
//CustomKeywords.'tool.UploadFile.uploadFileWeb'(pathFile)
WebUI.uploadFile(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_uploadFIle'), pathFile)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdjuntarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

String mensaje = ''

String errorMensaje = ''

if (descripcion == 'Prueba descripcion 30MB') {
    errorMensaje = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarDocMensajeArchivoPesado'), [:], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (errorMensaje == 'MensajeMaximoPermitido') {
    mensaje = errorMensaje //String mensaje01= 'Documentos guardados correctamente'

    //String mensaje02= 'Operación exitosa'
    not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE /**
    String tituloSinBarras = titulo.replaceAll('/', '')

    WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_DocumentoPrimerTitulo'), 
        tituloSinBarras, FailureHandling.OPTIONAL)
    **/ ) /**
	not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/LimpiarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)
	
		mensaje = 'SinMensaje'
	**/
} else {
    WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/h2_msjArchivoSubidoCorrectamente'), 
        1)

    String mensaje01 = 'Archivo subido correctamente'

    WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/h2_msjArchivoSubidoCorrectamente'), 
        mensaje01, FailureHandling.OPTIONAL)

    String mensaje02 = 'Estimado usuario, le informamos que los documentos se han adjuntado con éxito. Por favor, no se olvide de presionar el botón "Enviar". ¡Gracias por su colaboración!'

    WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/p_msjArchivoSubidoCorrectamente'), 
        mensaje02, FailureHandling.OPTIONAL)

    if (WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/h2_msjArchivoSubidoCorrectamente'), 
        mensaje01, FailureHandling.OPTIONAL)) {
        mensaje = mensaje01
    } else {
        not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/LimpiarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickLimpiar'), [:], FailureHandling.STOP_ON_FAILURE)

        mensaje = 'SinMensaje'
    }
    
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)
}

return mensaje

