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

def mapCuils = getBinding().getAt('varMapCuils')
//afiliado (mapCuils['1']), prestador (mapCuils['2']), interno (mapCuils['3'])
//empleado (mapCuils['4']), administrador (mapCuils['5'])

Map auxMap = mapCuils

def mapRegistradosBD

def mapRegistradosBDPortal

boolean todosValidados1= false

boolean todosValidados2= false

boolean validado= false

//afiliado: 1, prestador: 2, interno: 4, empleado: 5, administrador: 5
//para validar afiliado y prestador solo se usa la query portal
//registrados en BD oracle
mapRegistradosBD = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false]
//registrados en BD oracle portal
mapRegistradosBDPortal = [('1') : false, ('2') : false, ('3') : false, ('4') : false, ('5') : false]

int val = auxMap.size()

for (int i : (1..val)) {
    String index = i.toString()

    System.out.println('Index: ' + index)

    String cuil = mapCuils[index]

    System.out.println('Valor cuil MapCuils: ' + cuil)
	
	String nombreUsuario
	
	nombreUsuario= CustomKeywords.'adicionales.CuilRandomGenerator.generarNombreUsuarioConCuilSinGuiones'(cuil)

    mapRegistradosBDPortal[index]= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarUsuarioEstaRegistradoEnBDPortal'), [('varCuil') : cuil], FailureHandling.STOP_ON_FAILURE)
	
	'si es afiliado o prestador, el registro en la BD usuarios no se contempla'
	if((i== 1)||(i== 2)) {
		mapRegistradosBD[index]= true
	}    
	else {
		mapRegistradosBD[index]= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ValidarUsuarioEstaRegistradoEnBD'), [('varUsuario') : nombreUsuario], FailureHandling.STOP_ON_FAILURE)
	}
}

todosValidados1= !(mapRegistradosBDPortal.containsValue(false))

todosValidados2= !(mapRegistradosBD.containsValue(false))

System.out.println('Valor maps activados BD Portal: ' + mapRegistradosBDPortal)

System.out.println('Valor maps activados BD: ' + mapRegistradosBD)

'si el registro salio true en todos los casos, validado es true'
if((todosValidados1== true)&&(todosValidados2== true)){
	validado= true
}

return validado

