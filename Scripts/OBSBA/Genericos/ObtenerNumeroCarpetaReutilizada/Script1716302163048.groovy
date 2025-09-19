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
/**tipos: afiliadoCarSimple, afiliadoCarDoc, prestadorCarSimple, 
 * prestadorCarDoc, internoCarSimple, internoCarDoc**/

String tipo = getBinding().getAt('varTipo').toString()

String strUrl = getBinding().getAt('varUrl').toString()

String numero

System.out.println('Tipo carpeta: ' + tipo.toString())

System.out.println('Url entorno: ' + strUrl.toString())

//numero= WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaLeer'), [('varTipo') : tipo, ('varUrl') : strUrl], 
 //       FailureHandling.STOP_ON_FAILURE)

System.out.println("Numero AfiliadoCarSimple: " + GlobalVariable.afiliadoCarSimple)
System.out.println("Numero AfiliadoCarDoc: " + GlobalVariable.afiliadoCarDoc)
System.out.println("Numero prestadorCarSimple: " + GlobalVariable.prestadorCarSimple)
System.out.println("Numero prestadorCarDoc: " + GlobalVariable.prestadorCarDoc)
System.out.println("Numero internoCarSimple: " + GlobalVariable.internoCarSimple)
System.out.println("Numero internoCarDoc: " + GlobalVariable.internoCarDoc)

switch (tipo){
	case "afiliadoCarSimple":
	  numero= GlobalVariable.afiliadoCarSimple.toString()
	  break
	case "afiliadoCarDoc":
	  numero= GlobalVariable.afiliadoCarDoc.toString()
	  break
	case "prestadorCarSimple": 
	  numero= GlobalVariable.prestadorCarSimple.toString()
	  break
	case "prestadorCarDoc":
	  numero= GlobalVariable.prestadorCarDoc.toString()
	  break
	case "intCarSimple":
	  numero= GlobalVariable.internoCarSimple.toString()
	  break
	case "internoCarDoc":
	  numero= GlobalVariable.internoCarDoc.toString()
	  break
}

System.out.println("Numero carpeta obtenido: " + numero)

return numero

