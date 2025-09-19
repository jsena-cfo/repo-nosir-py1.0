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

String tipoBody = getBinding().getAt('varTipoBody').toString()

String textoCalculado = getBinding().getAt('varTextoCalculado').toString()

String url = getBinding().getAt('varUrl').toString()

String cuitAfiliado = getBinding().getAt('varCuilAfiliado').toString()

String cuitInterno = getBinding().getAt('varCuilInterno').toString()

String cuitEmpleado = getBinding().getAt('varCuilEmpleado').toString()

String cuitPrestador = getBinding().getAt('varCuilPrestador').toString()

String cuitAdministrador = getBinding().getAt('varCuilAdministrador').toString()

String htmlHead= '<!DOCTYPE html><html><head><style>mark {background-color: yellow; color: black;}</style></head><body>'

String body

String htmlEnd= '</body></html>'

def mapDatosAfiliado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosUsuarioBD'), [('varCuil') : cuitAfiliado
        , ('varRol') : 'Afiliado'], FailureHandling.STOP_ON_FAILURE)

def mapDatosInterno = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosUsuarioBD'), [('varCuil') : cuitInterno
        , ('varRol') : 'Interno'], FailureHandling.STOP_ON_FAILURE)

def mapDatosEmpleado = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosUsuarioBD'), [('varCuil') : cuitEmpleado
        , ('varRol') : 'Empleado'], FailureHandling.STOP_ON_FAILURE)

if (tipoBody == 'Simple') {
    def mapDatosPrestador = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosUsuarioBD'), [('varCuil') : cuitPrestador
            , ('varRol') : 'Prestador'], FailureHandling.STOP_ON_FAILURE)

    def mapDatosAdministrador = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerDatosUsuarioBD'), [('varCuil') : cuitAdministrador
            , ('varRol') : 'Interno'], FailureHandling.STOP_ON_FAILURE)

    body = WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodySimple'), [('varDatosAfiliado') : mapDatosAfiliado
            , ('varDatosInterno') : mapDatosInterno, ('varDatosEmpleado') : mapDatosEmpleado, ('varDatosPrestador') : mapDatosPrestador
            , ('varDatosAdministrador') : mapDatosAdministrador], FailureHandling.STOP_ON_FAILURE)
} else {
    if (tipoBody == 'Multiple') {
        body = WebUI.callTestCase(findTestCase('OBSBA/Genericos/GenerarEmailHtmlBodyMultiple'), [('varDatosAfiliado') : mapDatosAfiliado
                , ('varDatosInterno') : mapDatosInterno, ('varDatosEmpleado') : mapDatosEmpleado], FailureHandling.STOP_ON_FAILURE)
    }
}

String html= htmlHead + body + '<p><small>Entorno: ' + url + '</small></p><p><small>' + textoCalculado + '</small></p>' + htmlEnd

return html

