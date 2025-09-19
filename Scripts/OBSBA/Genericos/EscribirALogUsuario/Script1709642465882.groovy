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

String cuitAfiliado = getBinding().getAt('varAfiliado').toString()

String cuitPrestador = getBinding().getAt('varPrestador').toString()

String cuitInterno = getBinding().getAt('varInterno').toString()

String cuitEmpleado = getBinding().getAt('varEmpleado').toString()

String cuitAdministrador = getBinding().getAt('varAdministrador').toString()

String textoCalculado = getBinding().getAt('varTexto').toString()

String valorTexto = ((((((((((((((((('\n' + '***Log: Usuarios Simples Generados: ') + '\n') + '***Log: -Registrar Usuario Afiliado: ') + cuitAfiliado) + '\n') + 
'***Log: -Registrar Usuario Prestador: ') + cuitPrestador) + '\n') + '***Log: -Registrar Usuario Interno: ') + cuitInterno) + '\n') + '***Log: -Registrar Usuario Empleado: ') + 
cuitEmpleado) + '\n') + '***Log: -Registrar Usuario Administrador: ') + cuitAdministrador) + '\n') + '***Log: -Pass: Automation1234 ' + '\n' + '***Log: -' + textoCalculado

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto'):valorTexto], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirMarkPassed'), [('varTexto'):valorTexto], FailureHandling.STOP_ON_FAILURE)

