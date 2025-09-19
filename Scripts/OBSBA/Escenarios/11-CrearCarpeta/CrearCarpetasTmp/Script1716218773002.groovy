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
String userAfiliado = getBinding().getAt('varUserAfiliado').toString()

String userPrestador = getBinding().getAt('varUserPrestador').toString()

String userInterno = getBinding().getAt('varUserInterno').toString()

String pass = getBinding().getAt('varPass').toString()

String url = getBinding().getAt('varUrl').toString()

String numeroCarpeta

String numeroCarpetaDoc

'Crea una carpeta simple para un afiliado'
numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : userAfiliado
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'afiliadoCarSimple', ('varNumeroCarpeta') : numeroCarpeta
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

numeroCarpetaDoc = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : userAfiliado
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'afiliadoCarDoc', ('varNumeroCarpeta') : numeroCarpetaDoc
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

'Crea una carpeta simple para un prestador'
numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : userPrestador
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'prestadorCarSimple', ('varNumeroCarpeta') : numeroCarpeta
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

numeroCarpetaDoc = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : userPrestador
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'prestadorCarDoc', ('varNumeroCarpeta') : numeroCarpetaDoc
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

'Crea una carpeta simple para un interno'
numeroCarpeta = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaSimple'), [('varUsuario') : userInterno
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

System.out.println('Numero carpeta interno previo: ' + numeroCarpeta)

String numeroCarpetaAlt = numeroCarpeta

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'intCarSimple', ('varNumeroCarpeta') : numeroCarpetaAlt
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

numeroCarpetaDoc = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearGenerarCarpetaDoc'), [('varUsuario') : userInterno
        , ('varPass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistroTmpCarpetaGuardar'), [('varTipo') : 'internoCarDoc', ('varNumeroCarpeta') : numeroCarpetaDoc
        , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

