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

boolean present = false

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Tipo de carpeta'))

//WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/ul_tipoDeCarpeta2'), 
//  'Keys.DOWN')
String tipos = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/ul_tipoDeCarpeta2'))

//String tiposLista = ((((((((((((((('Bien Salud' + '\n') + 'Direccion Accion Soc') + '\n') + 'Fondo Compensador') + '\n') + 
//'Fondos Permanentes') + '\n') + 'F Con Cargos A Rend.') + '\n') + 'Nota/otros') + '\n') + 'Prestador Común') + '\n') + 'Reintegro') + 
//'\n') + 'Subsidio'
/**
String tiposLista = "Direccion Accion Soc" + "\n" +
"Fondo Compensador" + "\n" +
"Fondos Permanentes" + "\n" +
"F Con Cargos A Rend." + "\n" +
"G.A. Legales" + "\n" +
"Pagos Varios" + "\n" +
"Prestador Común" + "\n" +
"Reintegro" + "\n" +
"Sanatorio" + "\n" +
"Bien Salud" + "\n" +
"Subsidio" + "\n" +
"Nota/Otros"
**/
String tiposListaBD= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerListadoTipoCarpetaBD'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Tipos: ' + tipos)

System.out.println('Tipos cantidad: ' + tipos.length().toString())

System.out.println('Tipos Lista BD: ' + tiposListaBD)

System.out.println('Tipos Lista cantidad BD: ' + tiposListaBD.length().toString())


//if (tipos == tiposListaBD) {
//el listado del combo esta en minuscula y el de la BD viene en mayuscula
//se usa equalsIgnoreCase
if(tipos.equalsIgnoreCase(tiposListaBD)) {
    present = true
}

WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/svg_Tipo de carpeta'))

assert present

return present

