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
/**Valida que se cumple el formato de path de documento: **/
/**'users/idUsuario/numeroCarpeta/files/nombreArchivo**/
/**Nota: La parte del storage windows se debe analizar si es viable**/
boolean validar = false

String numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : usuario
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

String dni = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(usuario)

System.out.println('Cuil: ' + usuario + ' Numero carpeta: ' + numeroCarpeta)

validar = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/13-AdjuntarDocumento/ValidarBDPathAlmacenamiento'), [('varCuil') : usuario
        , ('varNumeroCarpeta') : numeroCarpeta], FailureHandling.STOP_ON_FAILURE)

assert validar

