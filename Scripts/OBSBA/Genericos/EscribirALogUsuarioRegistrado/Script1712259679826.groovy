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

String usuario= this.getBinding().getAt('varUsuario').toString()

String dni= this.getBinding().getAt('varDni').toString()

String cuit= this.getBinding().getAt('varCuit').toString()

String url= this.getBinding().getAt('varUrl').toString()

String perfil= this.getBinding().getAt('varPerfil').toString()

String cantRegDisponibles= this.getBinding().getAt('varCantRegDisponibles').toString()


String txtRegistrado=  "->Se registro y activo usuario: " + usuario + " dni: " + dni + " cuit: " + cuit

String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

String reg = '  ->Registro Perfil ' + perfil + ' en entorno ' + url
	  
WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Registrado: '], FailureHandling.STOP_ON_FAILURE)
		   
WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)
	  
WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)
	  
WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)
	  
WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Cantidad Registros disponible: ' + cantRegDisponibles], FailureHandling.STOP_ON_FAILURE)
