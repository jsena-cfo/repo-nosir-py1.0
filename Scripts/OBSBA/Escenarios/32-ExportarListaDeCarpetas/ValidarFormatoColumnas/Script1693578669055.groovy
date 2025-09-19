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
/**Script que valida el columna a columna el formato del xlsx que se exporta**/
/**Si se llegara a modificar el formato por requerimiento se debe actualizar 
 * el xlsx que utiliza para comparar el script**/

String path = '\\Xls\\obsba\\formatoXls\\formatoExpXls2003.xlsx'

def pathExcel = System.getProperty('user.dir') + path

def pathRelativo = pathExcel.replace('\\', '\\\\')

String dataFile = 'obsbaFormatoExpXls'

'Validar formato columnas'
TestData data = findTestData(dataFile)

int cantidadColumnas = data.columnNumbers

String[] columnas = data.columnNames

def mapBoolean= [:]

def mapString= [:]

boolean ingreso = false

mapString= ["0": nombreColumna01, "1": nombreColumna02, "2": nombreColumna03, 
	"3": nombreColumna04, "4": nombreColumna05, "5": nombreColumna06,
	"6": nombreColumna07, "7": nombreColumna08, "8": nombreColumna09,
	"9": nombreColumna10]

System.out.println('Imprimir todo: ' + columnas)

System.out.println('Cantidad columnas: ' + cantidadColumnas)

System.out.println('Mapa de strings: ' + mapString)

//String uno
//String dos
for (int i : (0..cantidadColumnas - 1)) {
	//uno= columnas[i]
	mapBoolean.put((i.toString()), false)
    System.out.println((('I: ' + i.toString()) + ' Nombre columna: ') + columnas[i])
	
	//dos= mapString[i.toString()]
	System.out.println("Segundo string: " + mapString[i.toString()])

	mapBoolean.put((i.toString()), columnas[i]== mapString[i.toString()])
	//uno= ""
	//dos= ""
}

System.out.println('Valor maps: ' + mapBoolean)

//Valida que el map boolean no contiene falsos
ingreso = !(mapBoolean.containsValue(false))

assert ingreso

