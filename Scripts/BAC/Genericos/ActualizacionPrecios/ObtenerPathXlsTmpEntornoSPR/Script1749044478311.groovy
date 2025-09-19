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


String strUrl= this.getBinding().getAt('varUrl').toString()
String tipoXls= this.getBinding().getAt('varTipoXls').toString()
String pathXls

if (strUrl.contains('-preprod.dguiaf-gcba.gov')) { //https://bac-test.dguiaf-gcba.gov.ar/
     pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpPre.xlsx'
}
else {
    if (strUrl.contains('-test.dguiaf-gcba.gov')) {
		  pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpTest.xlsx'
	}
	else {
	   if (strUrl.contains('-desa.dguiaf-gcba.gov')) {
			pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpDesa.xlsx'
	   }
	   else {
		   if (strUrl.contains('-homo.dguiaf-gcba.gov')) {
				pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpHomo.xlsx'
		   }
		   else {
			   if (strUrl.contains('-qa.dguiaf-gcba.gov')) {
					pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpQa.xlsx'
			   }
		   }
		}
	}
}

/**
switch (strUrl) {
	case strUrl.contains('-preprod.dguiaf-gcba.gov'):
	  pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpPre.xlsx'
	  break;
	case strUrl.contains('-test.dguiaf-gcba.gov'):
	  pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpTest.xlsx'
	  break;
	case strUrl.contains('-desa.dguiaf-gcba.gov'):
	  pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpDesa.xlsx'
	  break;
	case strUrl.contains('-homo.dguiaf-gcba.gov'):
	  pathXls= '/Xls/bac/numerosTmpXls/' + tipoXls + 'TmpHomo.xlsx'
	  break;
	default:
	  pathXls= "Error: Doesn't work!"
  }
 **/ 
return pathXls