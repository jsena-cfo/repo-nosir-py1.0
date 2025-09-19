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
/**Se generan recibos para un grupo de usuarios son:**/
/**Usuarios empleados:
20120042514
20120042522
20120042530
20120042549
20120042557
20120042565
**/

def mapCuils
mapCuils = [('1') : '20120042514', ('2') : '20120042522',
	        ('3') : '20120042530', ('4') : '20120042549',
			('5') : '20120042557', ('6') : '20120042565' ]

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['1'])], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['2'])], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['3'])], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['4'])], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['5'])], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarReciboBD'), [('varCuil') : (mapCuils['6'])], FailureHandling.STOP_ON_FAILURE)


