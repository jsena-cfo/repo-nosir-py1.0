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

def mapRangos

mapRangos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRangosDni'), [('varRangoIntMin') : varRangoIntMin], 
    FailureHandling.STOP_ON_FAILURE)

//String dniCuilIntMin = CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(varRangoIntMin)
//String dniCuilIntMax = CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(varRangoIntMax)
//String dniCuilEmpMin = CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(varRangoEmpMin)
//String dniCuilEmpMax = CustomKeywords.'adicionales.DniRandomGenerator.retornarDNIDeCuit'(varRangoEmpMax)
int intDniCuilIntMin = ((mapRangos['dniIntMin']) as int)

int intDniCuilIntMax = ((mapRangos['dniIntMax']) as int)

int intDniCuilEmpMin = ((mapRangos['dniEmpMin']) as int)

int intDniCuilEmpMax = ((mapRangos['dniEmpMax']) as int)

System.out.println('Map Rangos: ' + mapRangos)

'Solo usar en el entorno de Preproduccion, la configuracion en la BD permite hasta 250 inserts'
WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/InsertarUsuariosSigafBD'), [('varInsertarDesde') : intDniCuilIntMin
        , ('varInsertarHasta') : intDniCuilIntMax], FailureHandling.STOP_ON_FAILURE)

'Solo usar en el entorno de Preproduccion'
WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/InsertarUsuariosSigafBD'), [('varInsertarDesde') : intDniCuilEmpMin
        , ('varInsertarHasta') : intDniCuilEmpMax], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Se realizaron los inserts correctamente'], 
    FailureHandling.STOP_ON_FAILURE)

