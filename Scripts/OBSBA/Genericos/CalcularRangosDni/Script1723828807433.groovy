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
/**Bloque de Insert en BD Oracle configurado: 250**/
/**Ej: Rangos de dni usados:
dniCuitIntMin= 12004000 (interno)
dniCuitIntMax= 12004250
int dniCuitEmpMin= 12004251 (empleado)
int dniCuitEmpMax= 12004501
**/

String rangoDniCuilIntMin= this.getBinding().getAt('varRangoCuitIntMin').toString()

int sqlBlockLimit= 249
String dniCuitIntMinString= CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(rangoDniCuilIntMin)
int dniCuitIntMin= dniCuitIntMinString as int
int dniCuitIntMax= dniCuitIntMin + sqlBlockLimit
int dniCuitEmpMin= dniCuitIntMax + 1
int dniCuitEmpMax= dniCuitEmpMin + sqlBlockLimit

//String genero= 'Masculino'

def mapRangos

mapRangos = [('dniIntMin') : dniCuitIntMin, ('dniIntMax') : dniCuitIntMax,
	('dniEmpMin') : dniCuitEmpMin, ('dniEmpMax') : dniCuitEmpMax]

System.out.println("Map rangos: " + mapRangos)

return mapRangos