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



String strUrl= this.getBinding().getAt('varUrl')-toString()

def mapDB = [varServer: "", varPort: "", varDBName: "", varUser: "", varPassBase64:""]

if (strUrl.contains('-preprod.dguiaf-gcba.gov')) { //preprod
	//10.17.24.29\API_PRE:1437
	(mapDB['varServer'])= "10.17.24.29"
	(mapDB['varPort'])= "1437"
	(mapDB['varDBName'])= "API_PRE"
	(mapDB['varUser'])= "usrSEAC"
	(mapDB['varPass'])= "u53r534c09"
	(mapDB['varPassBase64'])= "dTUzcjUzNGMwOQ=="//pass: u53r534c09
	(mapDB['varUrlDB'])= "//10.17.24.29" + '\\' + "API_PRE:1437"
}
else {
   if (strUrl.contains('-test.dguiaf-gcba.gov')) { //test  //https://bac-test.dguiaf-gcba.gov.ar/
	   //10.17.24.30/BAC_TEST:1436
	   (mapDB['varServer'])= '10.17.24.30'
	   (mapDB['varPort'])= '1436'
	   (mapDB['varDBName'])= 'BAC_TEST'
	   (mapDB['varUser'])= 'usrSEAC'
	   (mapDB['varPass'])= "u53r534c09"
	   (mapDB['varPassBase64'])= 'dTUzcjUzNGMwOQ==' //pass: u53r534c09  dTUzcjUzNGMwOQ==
	   (mapDB['varUrlDB'])= "//10.17.24.30" + '\\' + "BAC_TEST:1436"
   }
   else {
	  if (strUrl.contains('-desa.dguiaf-gcba.gov')) { //desa
		   //entorno desa
	  }
	  else {
		  if (strUrl.contains('-homo.dguiaf-gcba.gov')) { //homologacion
			  //10.17.24.30\BAC_HOMO:1439
			  (mapDB['varServer'])= "10.17.24.30"
			  (mapDB['varPort'])= "1439"
			  (mapDB['varDBName'])= "BAC_HOMO"
			  (mapDB['varUser'])= "usrSEAC"
			  (mapDB['varPass'])= "u53r534c09"
			  (mapDB['varPassBase64'])= "dTUzcjUzNGMwOQ=="//pass:u53r534c09 
			  (mapDB['varUrlDB'])= "//10.17.24.30" + '\\' + "BAC_HOMO:1439"
		  }
		  else {
			  if (strUrl.contains('-qa.dguiaf-gcba.gov')) { //qa
				  //10.17.24.29\API_QA:1440
				  (mapDB['varServer'])= "10.17.24.29"
				  (mapDB['varPort'])= "1440"
				  (mapDB['varDBName'])= "API_QA"
				  (mapDB['varUser'])= "usrSEAC"
				  (mapDB['varPass'])= "u53r534c09"
				  (mapDB['varPassBase64'])= "dTUzcjUzNGMwOQ=="//pass:u53r534c09
				  (mapDB['varUrlDB'])= "//10.17.24.29" + '\\' + "API_QA:1440"
			  }
		  }
	   }
   }
}

return mapDB






