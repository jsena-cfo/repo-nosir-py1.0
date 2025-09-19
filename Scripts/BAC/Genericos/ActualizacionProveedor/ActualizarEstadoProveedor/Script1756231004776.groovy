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

String usuario = getBinding().getAt('userVar').toString()

String pass = getBinding().getAt('passVar').toString()

int numeroCel

boolean estadoActualizado= false

numeroCel = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroCelAleatorio'()

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Login'), [('user') : usuario, ('password') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/AccederMenuAdministrarEstado'), [('varOpcion') : 'ModificarDatosProveedor'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ClickEditarInformacionBasicaYDomicilio'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero telefono: ' + numeroCel.toString())

WebUI.setText(findTestObject('BAC/ActualizacionProveedor/input_Nmero de telfono'), numeroCel.toString())

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ClickGuardar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ClickEnviarModificacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ClickConfirmar'), [:], FailureHandling.STOP_ON_FAILURE)

estadoActualizado= WebUI.verifyElementPresent(findTestObject('BAC/ActualizacionProveedor/label_msjExito'), 2)

WebUI.callTestCase(findTestCase('BAC/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

assert estadoActualizado
