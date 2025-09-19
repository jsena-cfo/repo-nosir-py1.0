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

def mapBoolean

boolean ingreso= false

mapBoolean= ["1": WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/label_Consulta de Recibos'), 2, FailureHandling.OPTIONAL).toString(),
	         "2": WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/label_Consulta de Recibos'), 2, FailureHandling.OPTIONAL).toString(),
			 "3": WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/input_Fecha Hasta'), 2, FailureHandling.OPTIONAL).toString(),
			 "4": WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_BuscarConsultarRecibos'), 2, FailureHandling.OPTIONAL).toString(),
			 "5": WebUI.verifyElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_ConsultarRecibos/button_Limpiar'), 2, FailureHandling.OPTIONAL).toString()
			 ]

System.out.println("Valor maps: " + mapBoolean)

//valida que no contenga false
ingreso= !mapBoolean.containsValue("false")

assert ingreso

return ingreso

