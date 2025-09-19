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

/**Author: JER**/
/** Este era el prototipo de script inicial, tenia todos los usuarios y 
 * los webUi para cargar los objetos, antes el problema con la carpeta quedo 
 * asi inconcluso **/
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varCuilInterno, ('Contrasena') : varPassword], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpeta'), [('varAnio') : '', ('varNumeroCarpeta') : '', ('varFechaDesde') : ''
        , ('varFechaHasta') : '', ('varCuil') : GlobalVariable.cuitInterno], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpetaAvanzado'), [('varAnio') : '', ('varNumeroCarpeta') : ''
        , ('varFechaDesde') : fechaHoy, ('varFechaHasta') : fechaHoy, ('varCuil') : varUser, ('varTipoCarpeta') : '', ('varEstadoCarpeta') : ''], 
    FailureHandling.STOP_ON_FAILURE)

/**
WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()
**/

'Se loguea como usuario afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varCuilAfiliado, ('Contrasena') : varPassword], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpeta'), [('varAnio') : '2023', ('varNumeroCarpeta') : '', ('varFechaDesde') : '12062023'
        , ('varFechaHasta') : '05072023', ('varCuil') : ''], FailureHandling.STOP_ON_FAILURE)

'Se loguea como usuario prestador'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : varCuilPrestador, ('Contrasena') : varPassword], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ConsultarCarpeta'), [('varAnio') : '2023', ('varNumeroCarpeta') : '', ('varFechaDesde') : '12062023'
        , ('varFechaHasta') : '05072023', ('varCuil') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ByPassMensajes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpeta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

