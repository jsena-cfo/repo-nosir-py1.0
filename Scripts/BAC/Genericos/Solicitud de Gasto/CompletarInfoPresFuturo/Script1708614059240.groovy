import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('BAC/Genericos/Solicitud de Gasto/BuscarSG'), [('nroSG') : solicitudGasto, ('user') : GlobalVariable.userAnalista
        , ('pass') : GlobalVariable.passAnalista, ('accionSG') : 'Editar Solicitud'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAC/Home/btn_CompletarDatosInfoPres'))

def cantElementos = WebUI.findWebElements(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/tblObjetosDeGasto'), 
    10)

KeywordUtil.logInfo('Cantidad de filas encontradas: ' + cantElementos.size())

for (int i = 1; i <= cantElementos.size(); ++i) {
    def monto = WebUI.getText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/tr_MontoAImputar', 
            [('variable') : i]))

    WebUI.click(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/selectObjetoGasto'), FailureHandling.STOP_ON_FAILURE)

    def option = WebUI.getText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/optionObjetoGasto', 
            [('variable') : i]))

    WebUI.selectOptionByLabel(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/selectObjetoGasto'), 
        option, false)

    def anioProximo = CustomKeywords.'tool.DateGenerator.nextYear'()

    WebUI.selectOptionByValue(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/selectEjercicio'), 
        anioProximo, false)

    WebUI.click(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/btn_BuscarPartidas'))

    WebUI.setText(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/input_MontoPrimerPartida'), 
        monto)

    WebUI.check(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/chk_SeleccionarPrimerPartida'))

    WebUI.click(findTestObject('BAC/Solicitud de Gasto/Page_BAC - Completar info presupuestaria/btn_IngresarImputacion'))
}

WebUI.click(findTestObject('BAC/Home/btn_Guardar y Volver'))