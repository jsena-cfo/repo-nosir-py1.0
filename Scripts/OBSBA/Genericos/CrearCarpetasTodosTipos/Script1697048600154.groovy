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

String user = getBinding().getAt('varUser')

String pass = getBinding().getAt('varPass')

boolean present= false

def mapBoolean

mapBoolean = [('0') : false, ('1') : false, ('2') : false,
	('3') : false, ('4') : false, ('5') : false, 
	('6') : false, ('7') : false, ('8') : false]


'Loguea como afiliado'
WebUI.callTestCase(findTestCase('OBSBA/Genericos/Login'), [('Usuario') : user, ('Contrasena') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/EsperarGifProgresoCircular'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

//def tipoCarpeta = ['DireccionAccionSoc', 'PagosVarios', 'PrestadorComun', 
//	'FondoCompensador', 'FondosPermanentes', 'FConCargosARend',
//	'Sanatorio', 'BienSalud', 'Subsidio', 'NotaOtros', 'Reintegro']
//def tipoCarpeta = ['DireccionAccionSoc', 'NotaOtros', 'Reintegro']
def tipoCarpeta = ['DireccionAccionSoc', 'PagosVarios', 'PrestadorComun', 
	'FondoCompensador', 'Sanatorio', 'BienSalud', 
	'Subsidio', 'NotaOtros', 'Reintegro']

int num = 0

for (def tipo : tipoCarpeta) {
    System.out.println('Tipo de carpeta: ' + tipo)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

    (mapBoolean[num.toString()])= WebUI.callTestCase(findTestCase('OBSBA/Genericos/CrearNuevaCarpetaConPagoParam'), [('varCuil') : user, ('varTipoCarpeta') : tipo], 
        FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolver'), [:], FailureHandling.STOP_ON_FAILURE)

    num = (num + 1)
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

/**
boolean todosCreados = false

if (num == tipoCarpeta.size()) {
    todosCreados = true
}
**/

System.out.println('Cantidad carpetas creadas: ' + num.toString())

WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

System.out.println('Valor maps: ' + mapBoolean)

present = !(mapBoolean.containsValue(false))

assert present

