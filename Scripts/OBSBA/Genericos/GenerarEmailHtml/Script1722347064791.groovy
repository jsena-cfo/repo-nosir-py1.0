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

/** Author: Jer **/
/** Script envia email automatico a la lista de destinatarios**/
String textoCalculado = getBinding().getAt('varTextoCalculado').toString()

//'OBSBA QA Automation - CFO'
String titulo = getBinding().getAt('varTitulo').toString()

//'Usuarios Registro Multiple'
String asunto = getBinding().getAt('varAsunto').toString()

String tipoBody = getBinding().getAt('varTipoBody').toString()

String cuitAfiliado = getBinding().getAt('varCuilAfiliado').toString()

String cuitInterno = getBinding().getAt('varCuilInterno').toString()

String cuitEmpleado = getBinding().getAt('varCuilEmpleado').toString()

String body

if (tipoBody == 'Simple') {
    String cuitPrestador = getBinding().getAt('varCuilPrestador').toString()

    String cuitAdministrador = getBinding().getAt('varCuilAdministrador').toString()

    body = WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBody'), [('varTipoBody') : 'Simple', ('varTextoCalculado') : textoCalculado
            , ('varUrl') : varUrl, ('varCuilAfiliado') : cuitAfiliado, ('varCuilEmpleado') : cuitEmpleado, ('varCuilInterno') : cuitInterno
            , ('varCuilPrestador') : cuitPrestador, ('varCuilAdministrador') : cuitAdministrador], FailureHandling.STOP_ON_FAILURE)
} else {
    if (tipoBody == 'Multiple') {
        body = WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBody'), [('varTipoBody') : 'Multiple', ('varTextoCalculado') : textoCalculado
                , ('varUrl') : varUrl, ('varCuilAfiliado') : cuitAfiliado, ('varCuilEmpleado') : cuitEmpleado, ('varCuilInterno') : cuitInterno
                , ('varCuilPrestador') : '', ('varCuilAdministrador') : ''], FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarMail'), [('varDestinatarios') : varListaDestinatarios, ('varTitulo') : titulo
        , ('varAsunto') : asunto, ('varBodyMail') : body, ('varEmailFrom') : varEmailFrom, ('varPass') : varPassEmailFrom], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarMailJakarta'), [('varDestinatarios') : varListaDestinatarios
        , ('varTitulo') : titulo, ('varAsunto') : asunto, ('varBodyMail') : body, ('varEmailFrom') : varEmailFrom, ('varPass') : varPassEmailFrom], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarMailSSL'), [('varDestinatarios') : varListaDestinatarios
        , ('varTitulo') : titulo, ('varAsunto') : asunto, ('varBodyMail') : body, ('varEmailFrom') : varEmailFrom, ('varPass') : varPassEmailFrom], 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/EnviarMailGroovy'), [('varDestinatarios') : varListaDestinatarios
        , ('varTitulo') : titulo, ('varAsunto') : asunto, ('varBodyMail') : body, ('varEmailFrom') : varEmailFrom, ('varPass') : varPassEmailFrom], 
    FailureHandling.STOP_ON_FAILURE)

