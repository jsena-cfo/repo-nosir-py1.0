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

def tiposCarpetas= this.getBinding().getAt('varTiposCarpetas')

System.out.println("Arreglo tipos carpetas: " + tiposCarpetas)

String total= ''

String strTipo

String strTipoSinCorchetes

String strFormateado

for(tipo in tiposCarpetas) {
	    strTipo= ''
		strTipo= tipo.toString()		
		strTipoSinCorchetes= ''
		strTipoSinCorchetes= CustomKeywords.'tool.StringCK.quitarCorchetes'(strTipo)
        //quita substring XC_DESCRIPTOR:
		strFormateado= ''
		strFormateado= CustomKeywords.'tool.StringCK.quitarSubstringInicial'(strTipoSinCorchetes, 14)
        //System.out.println("String formateado: " + strFormateado)
		//si no es el ultimo tipo de carpeta
		//strTipo= strTipo + "\n"
		if(strFormateado!= "NOTA/OTROS") {
		   total= total + strFormateado + "\n"
		}
		else {
			total= total + strFormateado
		}   
	 }
	  
System.out.println("String formato total: " + total)
	  
return total