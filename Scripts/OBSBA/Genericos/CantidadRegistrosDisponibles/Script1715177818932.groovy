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
String cuitInterno= this.getBinding().getAt('varCuitInterno').toString()

String cuitEmpleado= this.getBinding().getAt('varCuitEmpleado').toString()

String rangoDniIntMax= this.getBinding().getAt('varRangoDniIntMax').toString()

String rangoDniEmpMax= this.getBinding().getAt('varRangoDniEmpMax').toString()

String dniInt = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuitInterno)

String rangoIntMax= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', rangoDniIntMax)

String calculoInt = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRegistrosDisponibles'), [('varDni') : dniInt
		, ('varCuitMax') : rangoIntMax], FailureHandling.STOP_ON_FAILURE)

String dniEmp = CustomKeywords.'adicionales.CuilRandomGenerator.get_dni_fromCuil'(cuitEmpleado)

String rangoEmpMax= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', rangoDniEmpMax)

String calculoEmp = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRegistrosDisponibles'), [('varDni') : dniEmp
		, ('varCuitMax') : rangoEmpMax], FailureHandling.STOP_ON_FAILURE)

String textoCalculado = (('Calculo disponibles *Restan internos: ' + calculoInt) + ' *Restan empleados: ') + calculoEmp

String logTexto= '***Log: ' + textoCalculado

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : logTexto], FailureHandling.STOP_ON_FAILURE)

System.out.println(textoCalculado)

return textoCalculado