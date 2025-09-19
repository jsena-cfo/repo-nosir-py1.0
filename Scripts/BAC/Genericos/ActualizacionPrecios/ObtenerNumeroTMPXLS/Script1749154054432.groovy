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


//tipo: SPR, OCA, PRORROGA
String tipo= this.getBinding().getAt('varTipo').toString()
String url= this.getBinding().getAt('varUrl').toString()
String numero

//numeroSPR= '401-0146-SPR25'
//numeroSPR= '401-0147-SPR25'
//numeroSPR= '401-0152-SPR25'
//numeroSPR= '401-0153-SPR25'
//numeroSPR= '401-0154-SPR25' 
//numeroSPR = '401-0155-SPR25'

numero= WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionPrecios/RegistroTmpLeerSPR'), [('varTipo') : tipo, ('varUrl') : url], 
    FailureHandling.STOP_ON_FAILURE)

return numero

