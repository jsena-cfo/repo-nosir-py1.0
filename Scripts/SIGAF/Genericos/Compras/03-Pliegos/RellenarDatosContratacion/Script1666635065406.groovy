import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

Screen screen = new Screen()

Long segundos

String horaAhora

//ingresa objeto de la contratacion
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'test')

CustomKeywords.'tool.sikuli.keyTab'(screen)

//ingresa lugar
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

//ingresa plazo y horario
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Lunes a viernes de 09 a 18')

CustomKeywords.'tool.sikuli.keyTab'(screen)

//lugar datos de apertura
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/** fechas datos de apertura **/
String diaHoy = CustomKeywords.'tool.DateGenerator.today'()

CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Cantidad de segundos previos a finalizar el ingreso de ofertas**/
segundos = 120

horaAhora = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

System.out.println('Hora ahora: ' + horaAhora)

/**Hora hasta de Presentacion de ofertas**/
String horaHastaPresentacion = CustomKeywords.'tool.DateGenerator.timeNowPlusSeconds'(segundos)

CustomKeywords.'tool.sikuli.delay'(1)

/**Cantidad de segundos previos a ejecutar la apertura de ofertas**/
segundos = 240

horaAhora = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

System.out.println('Hora ahora: ' + horaAhora)

/**Hora de Apertura de ofertas**/
String horaApertura = CustomKeywords.'tool.DateGenerator.timeNowPlusSeconds'(segundos)

System.out.println('HoraHastaPresentacion: ' + horaHastaPresentacion)

System.out.println('HoraApertura: ' + horaApertura)

/**hora datos de apertura**/
String horaAperturaSinSegundos = CustomKeywords.'tool.DateGenerator.timeTruncateSecondStr'(horaApertura)

System.out.println('Horario apertura sin segundos: ' + horaAperturaSinSegundos)

CustomKeywords.'tool.robot.type'(horaAperturaSinSegundos)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**lugar presentacion de ofertas**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**fecha hasta presentacion de ofertas**/
CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**hora hasta presentacion de ofertas**/
String horaHastaPresentacionSinSegundos = CustomKeywords.'tool.DateGenerator.timeTruncateSecondStr'(horaHastaPresentacion)

System.out.println('Horario hasta presentacion sin segundos: ' + horaHastaPresentacionSinSegundos)

CustomKeywords.'tool.robot.type'(horaHastaPresentacionSinSegundos)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**ingreso texto horario**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Lunes a viernes de 09 a 18')

CustomKeywords.'tool.sikuli.keyTab'(screen)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

def mapHorarios = [HoraHastaPresentacion: horaHastaPresentacionSinSegundos, HoraApertura: horaAperturaSinSegundos]

return mapHorarios