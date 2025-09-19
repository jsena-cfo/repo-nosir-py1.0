package tool

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class File {
	String path= 'C:/Devs/Txt/estadisticas2022.txt'
	//C:\Devs\Txt
	//boolean agregarAlFinal= false  //si es false crear un archivo desde cero sino no
	//FileWriter writeEstadisticaOCR= new FileWriter(path, agregarAlFinal) //boolean append_to_file, agrega al final de archivo: si o no
	//PrintWriter lineaEstadisticaOCR= new PrintWriter(writeEstadisticaOCR)

	//File archivo = new File(path);


	@Keyword
	def agregarLineaEstadisticaOCR(String numero, String porcentaje){
		// lineaEstadisticaOCR.printf("%s" + "%n", "{")
		lineaEstadisticaOCR.printf('Numero: ' + numero + ' ' + 'Porcentaje: ' + porcentaje)
	}

	@Keyword
	def crearArchivo() {
		new File('C:/Devs/Txt','Example.txt').withWriter('utf-8') { writer ->
			writer.writeLine 'Hello World'
		}

	}

	@Keyword
	def crearArchivo(String pathName, String fileName) {
		//Ej path: 'C:/Devs/Txt'
		//Ej name: 'Example.txt'
		new File(pathName, fileName).withWriter('utf-8') { writer ->
			writer.writeLine 'Hello World'
		}
	}

	@Keyword
	def agregarLineaTexto(String numero, String porcentaje){
		// lineaEstadisticaOCR.printf("%s" + "%n", "{")
		lineaEstadisticaOCR.printf('Numero: ' + numero + ' ' + 'Porcentaje: ' + porcentaje)
	}
}
