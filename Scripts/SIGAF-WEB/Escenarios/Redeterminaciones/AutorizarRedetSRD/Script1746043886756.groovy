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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

int number = CustomKeywords.'adicionales.NumberRandomGenerator.generarNumeroDigitosAleatorio'()

def mapBoolean = [('guardada') : false, ('textoValido') : false]

String comentario = 'Carga comentario ' + number.toString()

boolean guardada = false

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederMenuOCA'), [('varOpcion') : 'AdministrarSolicitudes'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EsperarGifCarga'), [:], FailureHandling.STOP_ON_FAILURE)

String numOCASRD = WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ObtenerNumOCASRD'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/EscribirLogStr'), [('varStr') : 'Numero OCA: ' + numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarNumeroOCA'), [('varNumOCA') : numOCASRD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/IngresarEstado'), [('varOpcion') : 'ingresado'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickBuscar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ScreenZoom'), [('varZoom') : '80%'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/AccederPrimerDetalle'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(1)

WebUI.callTestCase(findTestCase('SIGAF-WEB/Genericos/ClickAutorizar'), [:], FailureHandling.STOP_ON_FAILURE)

String numero = WebUI.getText(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/label_numero'))

WebUI.setText(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/input_text_Numero'), numero)

String ejercicio = WebUI.getText(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/label_Ejercicio'))

WebUI.setText(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/input_text_Ejercicio'), ejercicio)

WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/div__col q-input-fecha'))

String today = CustomKeywords.'tool.DateGenerator.today'()

String dayToday = CustomKeywords.'tool.StringCK.getSubstring'(today, 0, 2)

Integer integerNum = ((dayToday) as Integer)

String strIntegerNum = integerNum.toString()

String xpath = ((((((('//div[(text() = ' + '\'') + strIntegerNum) + '\'') + ' or . = ') + '\'') + strIntegerNum) + '\'') + 
')]'

System.out.println('Dia de hoy: ' + strIntegerNum)

TestObject auxTestObject 

auxTestObject= new TestObject()

auxTestObject.addProperty('tag', ConditionType.EQUALS, 'div')

auxTestObject.addProperty('text', ConditionType.EQUALS, strIntegerNum)

auxTestObject.addProperty('xpath', ConditionType.EQUALS, xpath)

//WebUI.click(findTestObject(auxTestObject))
int index = 1

boolean noVisible = false

boolean clickeable= false

while (!(noVisible)) {
    String xpath2 
	
	//xpath2= ('//div[5]/div/div[2]/div/div[2]/div[3]/div[' + index.toString()) + ']'

	xpath2= '/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div['+ index.toString() + ']'
	
    auxTestObject = new TestObject()

    //auxTestObject.addProperty('tag', ConditionType.EQUALS, 'div')

    //auxTestObject.addProperty('text', ConditionType.EQUALS, strIntegerNum)

    auxTestObject.addProperty('xpath', ConditionType.EQUALS, xpath2)

    clickeable= WebUI.verifyElementClickable(findTestObject(auxTestObject), FailureHandling.CONTINUE_ON_FAILURE)
    
	//clickeable= WebUI.verifyElementPresent(findTestObject(auxTestObject), 2, FailureHandling.CONTINUE_ON_FAILURE)
	
	//clickeable= WebUI.verifyElementVisible(findTestObject(auxTestObject), FailureHandling.CONTINUE_ON_FAILURE)
	
	if(clickeable) {    
	  WebUI.click(findTestObject(auxTestObject))
    }
	else {
		index= index+1
	}
    
    if (WebUI.verifyElementVisible(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/i_cancel'), FailureHandling.CONTINUE_ON_FAILURE)){ 
            noVisible = true
    }
}


//WebUI.click(findTestObject('SIGAF-WEB/Page_sigaf-redet-autorizar/div_fecha')