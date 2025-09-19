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

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_SubirDocumento'), 1)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_SubirDocumento'), 1)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/svg_Tipo de documento'))

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/li_Receta_documento'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoDocumento'), [('varTipoDocumento') : 'receta'], FailureHandling.STOP_ON_FAILURE)

if (usuario == 'Interno') {
    WebUI.check(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/chk_Visible_documento'))
}

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_Titulo_fileTitle_documento'), titulo)

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/textarea_Observaciones_fileDescription'), 
    descripcion)

not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/input_Descripcin de carpeta'), descripcion)

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
WebUI.uploadFile(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/input_uploadFile'), pathFile)

/**

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'), 2)

WebUI.scrollToElement(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'), 2)

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/span_Subir Archivo2'))
**/
//CustomKeywords.'com.kms.katalon.keyword.uploadfile.UploadFile.uploadFile'(to, pathFile)
not_run: WebUI.delay(2)

not_run: WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_SubirDocumento'), 
    2)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_SubirDocumento'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickAdjuntarDocumento'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(2)

