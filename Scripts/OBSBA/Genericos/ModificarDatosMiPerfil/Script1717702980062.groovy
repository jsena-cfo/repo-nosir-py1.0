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

/**Author: Jer**/
/**Se modifican todos los campos excepto el password**/
/** NOTA: Hay problemas con el cambio de cuit-cuil 
 * Se resuelve en RM 107916 y 107917**/

String nombre = getBinding().getAt('varNombre').toString()

String tipoDocumento = getBinding().getAt('varTipoDocumento').toString()

String numeroCuit = getBinding().getAt('varNumeroCuit').toString()

String telefono = getBinding().getAt('varTelefono').toString()

String domicilio = getBinding().getAt('varDomicilio').toString()

String email = getBinding().getAt('varEmail').toString()

WebUI.callTestCase(findTestCase('OBSBA/Genericos/LimpiarDatosMiPerfil'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Apellido  Nombre  Razon Social_fullName'), nombre)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoDocumentoMiPerfil'), [('varTipoDocumento') : tipoDocumento], 
    FailureHandling.STOP_ON_FAILURE)

//Hay problemas con el cambio de cuit-cuil
//Se resuelve en RM 107916 y 107917
not_run: WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_CUITCUIL_nDocumento'), numeroCuit)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_N Telfono_nTelefono'), telefono)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Domicilio_address'), domicilio)

WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_MiPerfil/input_Email_email'), email)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

