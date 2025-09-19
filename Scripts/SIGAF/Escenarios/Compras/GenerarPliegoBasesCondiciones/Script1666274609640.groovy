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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

String numeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAltRol'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

def mapHorarios = [:]

mapHorarios = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/SeleccionarProcedimientosHabilitados'), 
    [('varNumeroContratacion') : numeroContratacion], FailureHandling.STOP_ON_FAILURE)

System.out.println('Horario inicio: ' + (mapHorarios['HorarioInicio']))

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

String horarioActual = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

System.out.println('Horario actual: ' + horarioActual)

String segundosEntre = CustomKeywords.'tool.DateGenerator.secondsBetweenTimes'(mapHorarios['HorarioInicio'], horarioActual)

System.out.println('Segundos transcurridos desde el inicio del proceso: ' + segundosEntre)

String horarioPresentacionCompleto = (mapHorarios['HoraHastaPresentacion']).toString() + ':00'

horarioActual = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

segundosEntre = CustomKeywords.'tool.DateGenerator.secondsBetweenTimes'(horarioActual, horarioPresentacionCompleto)

System.out.println('Segundos que faltan para poder ingresar sobre: ' + segundosEntre)

String horarioAperturaCompleto = (mapHorarios['HoraApertura']).toString() + ':00'

horarioActual = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

segundosEntre = CustomKeywords.'tool.DateGenerator.secondsBetweenTimes'(horarioActual, horarioAperturaCompleto)

System.out.println('Segundos que faltan para que se ejecute la apertura: ' + segundosEntre)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/IngresarSobres'), [('varNumeroContratacion') : numeroContratacion
        , ('varHorarioPresentacion') : horarioPresentacionCompleto, ('varHorarioApertura') : horarioAperturaCompleto], FailureHandling.STOP_ON_FAILURE)

String estadoOcr

estadoOcr = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/VerificarEstados'), [('varEstadoObtenido') : estadoOcr.trim(), ('varEstadoIngresado') : 'AUTORIZADO'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '643', ('varY') : '170', ('varW') : '15', ('varH') : '8'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

