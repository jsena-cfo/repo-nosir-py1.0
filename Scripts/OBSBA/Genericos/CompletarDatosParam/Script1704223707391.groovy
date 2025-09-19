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

String email = getBinding().getAt('varEmail').toString()

String password = getBinding().getAt('varPassword').toString()

String cuit = getBinding().getAt('varCuit').toString()

String user = getBinding().getAt('varUser').toString()

String telefono = getBinding().getAt('varTelefono').toString()

String direccion = getBinding().getAt('varDireccion').toString()

String url = getBinding().getAt('varUrl').toString()

String tipoPerfil = getBinding().getAt('varTipoPerfil').toString()

//WebUI.openBrowser(GlobalVariable.URL_OBSBA)
//WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_REGISTRATE'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrate'), [:], FailureHandling.STOP_ON_FAILURE)

switch (tipoPerfil) {
    case 'afiliado':
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosYRegistrar'), [('cuit') : '', ('nombre') : '', ('pass') : ''
                , ('perfil') : '', ('telefono') : '1122334455', ('email') : 'test@test.com', ('domicilio') : 'test', ('varUrl') : url], 
            FailureHandling.STOP_ON_FAILURE)

        break
    case 'empleado':
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('email') : '', ('password') : ''
                , ('cuit') : ''], FailureHandling.STOP_ON_FAILURE)

        break
    case 'interno':
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : '', ('varCuil') : '', ('varPassword') : ''
                , ('varUrl') : ''], FailureHandling.STOP_ON_FAILURE)

        break
    case 'prestador':
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosYRegistrar'), [('cuit') : '', ('nombre') : '', ('pass') : ''
                , ('perfil') : '', ('telefono') : '1122334455', ('email') : 'test@test.com', ('domicilio') : 'test', ('varUrl') : url], 
            FailureHandling.STOP_ON_FAILURE)

        break
}

not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_Registrar'))

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrar'), [:], FailureHandling.STOP_ON_FAILURE)

