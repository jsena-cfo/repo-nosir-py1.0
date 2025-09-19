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

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DatosBasicosTxt'), 'DatosText01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbIngresoBrutoAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_IngresosBrutosTxt'), 'DatosTest01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbConstitucionAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_ConstitucionTxt'), 'DatosText01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbOrgPublicoInscriptoAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_OrganismoPublicoTxt'), 'DatosText01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionLegalAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DomicilioLegalTxt'), 'DatosText01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionCABAAprobado'))

WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DomicilioCABA'), 'DatosText01')

WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbInteradministrativasAprobado'))

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/btnSiguiente'))

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/btn_Anterior'))

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'), 'checked', 0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DatosBasicosTxt'), 'DatosText01')

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbIngresoBrutoAprobado'), 'checked', 0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_IngresosBrutosTxt'), 'DatosTest01')

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbConstitucionAprobado'), 'checked', 0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_ConstitucionTxt'), 'DatosText01')

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbOrgPublicoInscriptoAprobado'), 'checked', 
    0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_OrganismoPublicoTxt'), 'DatosText01')

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionLegalAprobado'), 'checked', 0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DomicilioLegalTxt'), 'DatosText01')

WebUI.verifyElementHasAttribute(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionCABAAprobado'), 'checked', 0)

WebUI.verifyElementText(findTestObject('RIUPP/Evaluacion CAP/Indice1/Indice1CuadrosTxt/input_DomicilioCABA'), 'DatosText01')



