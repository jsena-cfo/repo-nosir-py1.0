import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_CompletarDatos'))

WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/select_Seleccionar'), 
    '401 - MINISTERIO DE SALUD', false)

//ssimonetta - Silvana Simonetta
//cservente - Carlos Servente
//svarela - Sandra Monica Varela
WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Silvana Simonetta']))

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Carlos Servente']))

WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/chkEvaluador', [('variable') : 'Sandra Monica Varela']))

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_Agregar'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador1'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador2'))

subirDeclaracionJurada(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/button_AccionesEvaluador3'))

WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/IngresarActoAdministrativoEvaluadores'), [('tipoDocumento') : 'Disposición'
        , ('anio') : '2024', ('reparticion') : 'DGGDOC', ('numero') : '00195688'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_GuardarYVolver'))

def subirDeclaracionJurada(TestObject btnAcciones) {
    WebUI.click(btnAcciones)

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/li_SubirDeclaracion'))

    WebUI.selectOptionByLabel(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/select_TipoDocumento'), 
        tipoDoc, false)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_AnioDocumento'), anio)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_Numero'), numero)

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/input_Reparticion'), reparticion)

    WebUI.check(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/check_NumeroSADE'))

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Evaluadores/btn_Ingresar'))
}

