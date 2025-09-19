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
import java.text.SimpleDateFormat

boolean campoFechaValidado = false

mapBoolean = [('fechaPrestacionBloqueada') : false, ('fechaCargadaHoy') : false]

//not_run: fechaPrestacionBloqueada = WebUI.verifyElementNotClickable(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndicesInformacionBasica/input_Fecha de Prestacin'), 
//    FailureHandling.CONTINUE_ON_FAILURE)
String hoy = CustomKeywords.'tool.DateGenerator.todayFormat'('d/M/yyyy')

String valor= WebUI.getAttribute(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndicesInformacionBasica/input_Fecha de Prestacin'), 'value')
		
System.out.println("Valor hoy: " + hoy)

System.out.println("Valor valor: " + valor)

(mapBoolean['fechaCargadaHoy'])= (hoy.compareTo(valor)== 0)

(mapBoolean['fechaPrestacionBloqueada']) = WebUI.verifyElementAttributeValue(findTestObject('BAC/ActualizacionPrecios/Page_BAC - IndicesInformacionBasica/input_Fecha de Prestacin'), 
    'readonly', 'true', 2, FailureHandling.CONTINUE_ON_FAILURE)

System.out.println('MapBoolean: ' + mapBoolean)

campoFechaValidado = !(mapBoolean.containsValue(false))

return campoFechaValidado

