import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.DateFormat as DateFormat
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

def fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))

def fechaPublicacion = CustomKeywords.'tool.DateGenerator.getNextValidWorkingDay'(5)

def fechaInicio = CustomKeywords.'tool.DateGenerator.getNextValidWorkingDay'(6)

def fechaFin = CustomKeywords.'tool.DateGenerator.getNextValidWorkingDay'(7)

def hora = '05:00'

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/btn_Completar datos'))

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaEstimadaPublicacion'), fechaPublicacion)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraEstimadaPublicacion'), hora)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaInicioConsultas'), fechaInicio)

WebUI.sendKeys(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraInicioConsultas'), hora)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaFinalConsultas'), fechaInicio)

WebUI.sendKeys(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraFinalConsultas'), hora)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaActoApertura'), fechaInicio)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraActoApertura'))

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraActoApertura'), hora)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaInicioSoporte'), fechaInicio)

WebUI.sendKeys(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraInicioSoporte'), hora)

WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpFechaFinalSoporte'), fechaInicio)

WebUI.sendKeys(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraFinalSoporte'), hora)

WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/btn_Guardar y Volver'))
/**
try {
    WebUI.delay(3)

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraActoApertura'))

    WebUI.setText(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/inpHoraActoApertura'), hora)

    WebUI.click(findTestObject('BAC/Page_BAC - Proceso de Compra/Page_BAC - Cronograma/btn_Guardar y Volver'))
}
catch (Exception e) {
    println(e)
}
**/