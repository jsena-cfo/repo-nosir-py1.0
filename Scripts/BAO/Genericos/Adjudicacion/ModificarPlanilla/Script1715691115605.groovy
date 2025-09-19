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

WebUI.callTestCase(findTestCase('BAO/Genericos/Proceso de Contratacion/BuscarPC'), [('nroPC') : GlobalVariable.nroPC, ('user') : GlobalVariable.userSupervisor
        , ('pass') : GlobalVariable.pass, ('accion') : 'Completar Planilla', ('UE') : 'UOC: 558 - MINISTERIO DE EDUCACIÓN'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('BAO/Adjudicacion/btnModificarPlanilla'))

WebUI.setText(findTestObject('BAO/Adjudicacion/inpCodigo'), codigo)

WebUI.setText(findTestObject('BAO/Adjudicacion/inpDescripcion'), descripcion)

WebUI.setText(findTestObject('BAO/Adjudicacion/inpCantidad'), cantidad)

WebUI.selectOptionByLabel(findTestObject('BAO/Adjudicacion/selectUnidadMedida'), unidadMedida, false)

WebUI.setText(findTestObject('BAO/Adjudicacion/inpPrecioUnitario'), precio)

WebUI.click(findTestObject('BAO/Adjudicacion/btnAgregarItem'))

WebUI.click(findTestObject('BAO/Adjudicacion/btnFinalizar'))

WebUI.click(findTestObject('BAO/Adjudicacion/btnEnviarAAdj'))

