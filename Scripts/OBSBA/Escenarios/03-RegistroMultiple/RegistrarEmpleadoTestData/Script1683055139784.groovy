import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

def pathExcel = System.getProperty('user.dir') + '\\Xls\\obsba\\EmpleadosObsba.xlsx'

def pathRelativo = pathExcel.replace('\\', '\\\\')

row_control = findTestData('empleadosObsba').getRowNumbers()

for (int i = 1; i <= row_control; i++) {
    def estado = findTestData('empleadosObsba').getValue('Estado', i)

    if (estado == '') {
        def cuitDisponible = findTestData('empleadosObsba').getValue('CUIT', i)

        KeywordUtil.logInfo('Proximo cuit disponible en excel es: ' + cuitDisponible)

        WebUI.openBrowser(GlobalVariable.URL_OBSBA)

        WebUI.maximizeWindow()

        WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_REGISTRATE'))

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'empleado'], FailureHandling.STOP_ON_FAILURE)

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nombre y apellido  Razon social_fullName'), 
            'Test Test')

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_CUITCUIL_idInpCUIT'), cuitDisponible)

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Correo electrnico_idInpEmail'), email)

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita correo electrnico_idInpEmailRep'), 
            email)

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Telfono_idInpTelefono'), '1122334455')

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Domicilio legal_idInpDomicilio'), 'test')

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Nueva contrasea_password'), password)

        WebUI.setText(findTestObject('ObsbaPortal/Page_ObSBA_RegistrarExterno/input_Repita contrasea_idInpRepeatPassword'), 
            password)

        not_run: WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/button_Registrar'))

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrar'), [:], FailureHandling.STOP_ON_FAILURE)

        def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
            false, FailureHandling.OPTIONAL)

        if (registroSatisfactorio == true) {
            String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuitDisponible)

            String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuitDisponible, ('varToken') : token], 
                FailureHandling.STOP_ON_FAILURE)

            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 2, i, 'Registrado')

            return cuitDisponible
            
            break
        } else {
            WebUI.takeScreenshot()

            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 2, i, 'Usuario registrado previamente o invalido')
        }
    } else {
        KeywordUtil.logInfo('Estado del usuario: ' + estado)
    }
}

