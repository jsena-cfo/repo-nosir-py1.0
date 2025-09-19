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

/** Author: Jer **/
/** Script envia email automatico a la lista de destinatarios**/
def mapRangos

mapRangos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRangosDni'), [('varRangoIntMin') : varRangoIntMin], 
    FailureHandling.STOP_ON_FAILURE)

int rangoDniIntMax = ((mapRangos['dniIntMax']) as int)

int rangoDniEmpMax = ((mapRangos['dniEmpMax']) as int)

String textoCalculado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CantidadRegistrosDisponibles'), [('varCuitInterno') : varCuitIntEmpAfi
        , ('varCuitEmpleado') : varCuitEmpAfiInt, ('varRangoDniIntMax') : rangoDniIntMax, ('varRangoDniEmpMax') : rangoDniEmpMax], 
    FailureHandling.STOP_ON_FAILURE)

String entorno= WebUI.callTestCase(findTestCase('OBSBA/Genericos/RetornarEntorno'), [('varUrl') : varUrl], FailureHandling.STOP_ON_FAILURE)

String titulo = 'OBSBA QA Automation - CFO'

String asunto = 'Usuarios Registro Multiple - Ent: ' + entorno

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtml'), [('varTitulo') : titulo, ('varAsunto') : asunto, ('varTextoCalculado') : textoCalculado
        , ('varTipoBody') : 'Multiple', ('varCuilAfiliado') : varCuitAfiEmpInt, ('varCuilPrestador') : '', ('varCuilInterno') : varCuitIntEmpAfi
        , ('varCuilEmpleado') : varCuitEmpAfiInt, ('varCuilAdministrador') : ''], FailureHandling.STOP_ON_FAILURE)

