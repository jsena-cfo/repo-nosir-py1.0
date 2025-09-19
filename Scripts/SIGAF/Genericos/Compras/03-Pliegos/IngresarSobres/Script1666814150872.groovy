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

String numeroContratacion= this.getBinding().getAt('varNumeroContratacion').toString()

String horarioHastaPresentacionCompleto= this.getBinding().getAt('varHorarioPresentacion').toString()

String horarioAperturaCompleto= this.getBinding().getAt('varHorarioApertura').toString()

String horarioActual

String segundosEntre

int tiempo

Screen screen = new Screen()

horarioActual = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

segundosEntre = CustomKeywords.'tool.DateGenerator.secondsBetweenTimes'(horarioActual, horarioHastaPresentacionCompleto)

System.out.println("Segundos restantes para presentar ofertas: " + segundosEntre)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'opcionIngresoSobres.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'opcionIngresoSobres.png', 'ComprasPliegos')

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/03-Pliegos/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '%' + numeroContratacion)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'proveedor uno')

CustomKeywords.'tool.sikuli.keyTab'(screen)

String fechaHoy= CustomKeywords.'tool.DateGenerator.today'()

CustomKeywords.'tool.robot.type'(fechaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)

//seguir

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'listProveedor01.png', 'ComprasPliegos', -166, 7)

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'listProveedor02.png', 'ComprasPliegos', -166, -12)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnImprimirConstancia.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacion.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarModal.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalTecla.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnTeclaOK.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalSalida.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnPantalla.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.delay'(7)

CustomKeywords.'tool.sikuli.keyAltPlusF4'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacion.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarModal.png', 'ComprasPliegos')

//seguir

horarioActual = CustomKeywords.'tool.DateGenerator.timeNowComplete'()

segundosEntre = CustomKeywords.'tool.DateGenerator.secondsBetweenTimes'(horarioActual, horarioAperturaCompleto)

System.out.println("Hora actual: " + horarioActual)

System.out.println("Segundos restantes para apertura de ofertas: " + segundosEntre)

tiempo= Integer.parseInt(segundosEntre)

System.out.println("Cargando...")

CustomKeywords.'tool.sikuli.keyOpenTime'(screen)

CustomKeywords.'tool.sikuli.delay'(tiempo)

CustomKeywords.'tool.sikuli.keyOpenTime'(screen)

CustomKeywords.'tool.sikuli.delay'(2)
