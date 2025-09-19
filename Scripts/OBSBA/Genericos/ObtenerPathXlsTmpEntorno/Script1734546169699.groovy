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
String tipo= this.getBinding().getAt('varTipo').toString()
String pathXls

if (strUrl.contains('obsba-preprod.dguiaf-gcba.gov')) {
     pathXls= '/Xls/obsba/usersSigafXls/' + tipo + 'TmpPre.xlsx'
}
else {
    if (strUrl.contains('obsba-test.dguiaf-gcba.gov')) {
		  pathXls= '/Xls/obsba/usersSigafXls/' + tipo + 'TmpTest.xlsx'
	}
	else {
	   if (strUrl.contains('obsba-desa.dguiaf-gcba.gov')) {
			pathXls= '/Xls/obsba/usersSigafXls/' + tipo + 'TmpDesa.xlsx'
	   }
	}
}
 
/** 
 * if (strUrl.contains('obsba-preprod.dguiaf-gcba.gov')) {
    path = (dirName + '/Xls/obsba/usersSigafXls/usuariosTmpPre.xlsx')
} else {
    if (strUrl.contains('obsba-test.dguiaf-gcba.gov')) {
        path = (dirName + '/Xls/obsba/usersSigafXls/usuariosTmpTest.xlsx')
    } else {
        if (strUrl.contains('obsba-desa.dguiaf-gcba.gov')) {
            path = (dirName + '/Xls/obsba/usersSigafXls/usuariosTmpDesa.xlsx')
        }
    }
}

  if (strUrl.contains('obsba-preprod.dguiaf-gcba.gov')) {
	  path= dirName + 
	}
	else {
		if (strUrl.contains('obsba-test.dguiaf-gcba.gov')) {
			path= dirName + '/Xls/obsba/usersSigafXls/carpetasTmpTest.xlsx'
		}
		else {
			if (strUrl.contains('obsba-desa.dguiaf-gcba.gov')) {
				path= dirName + '/Xls/obsba/usersSigafXls/carpetasTmpDesa.xlsx'
			}
		}
	}
 **/
  
 return pathXls