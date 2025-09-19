import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String varNumero = getBinding().getVariables().getAt('varNumero').toString()
String varEjercicio = getBinding().getVariables().getAt('varEjercicio').toString()

System.out.println('Numero recibido: ' + varNumero)
System.out.println('Numero ejercicio' + varEjercicio)

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImgTarget'(screen, 'inpEjercicio.png', 'MPIngresarMenuPresupuesto', 32, 0, 25)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpEjercicio.png', 'MPIngresarMenuPresupuesto', 32, 0, varEjercicio)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen,'inpRequeri.png', 'MPIngresarMenuPresupuesto', 17, 0, varNumero)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'optConsulta.png', 'MPIngresarMenuPresupuesto')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'menuEjecutar.png', 'MPIngresarMenuPresupuesto')

WebUI.delay(3)


//labelImporte es un input que contiene el valor 100 y pregunta por este
//if (screen.find(new Pattern(CustomKeywords.'tool.sikuli.pathImg'('labelImporte.png', 'IngresarMenuPresupuesto'))) != null) {
if(CustomKeywords.'tool.sikuli.encontrar'(screen, 'labelImporte.png', 'MPIngresarMenuPresupuesto')!= null) {
    System.out.println('Lo encontro')
    assert true
} else {
    System.out.println('No lo encontro')
	assert false
}

