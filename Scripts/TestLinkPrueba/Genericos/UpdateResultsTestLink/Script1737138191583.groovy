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

import testlink.api.java.client.TestLinkAPIResults

//CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testcasename, exception, results)
/**testcaseName - The test case name on testlink.
 exception - The exception message if any
 results - The result of the test case**/

String testCaseName= this.getBinding().getAt('varTestCaseName').toString()
String exception= this.getBinding().getAt('varException').toString()
String results= this.getBinding().getAt('varResults').toString()

switch(results) {
	case "TEST_PASSED":
	   CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testCaseName, exception, TestLinkAPIResults.TEST_PASSED)
	   break
	case "TEST_FAILED":
	   CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testCaseName, exception, TestLinkAPIResults.TEST_FAILED)
		break
	case "TEST_BLOCKED":
	  CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testCaseName, exception, TestLinkAPIResults.TEST_BLOCKED)
	   break
	case "TEST_DEPARTED":
	   CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testCaseName, exception, TestLinkAPIResults.TEST_DEPARTED)
		break
    case "TEST_WRONG":
		 CustomKeywords.'com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults'(testCaseName, exception, TestLinkAPIResults.TEST_WRONG)
		  break
}