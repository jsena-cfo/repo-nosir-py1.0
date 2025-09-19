package adicionales

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


public class NumberRandomGenerator {
	@Keyword
	def generarNumeroAleatorioRango(int min, int max) {
		Random random = new Random()
		int numero = random.nextInt(max - min) + min
		return numero
	}

	@Keyword
	def generarNumeroDigitosAleatorio() {
		int numero = new Random().nextInt(99999 - 10000 + 1) + 10000
		return numero
	}

	//Genera un numero de mes random
	@Keyword
	def generarMesRandomAleatorio() {
		int min= 1
		int max= 12
		int numero
		numero= this.generarNumeroAleatorioRango(min, max)
		return numero
	}

	@Keyword
	def generarNumeroCelAleatorio() {
		int numero = new Random().nextInt(99999999 - 10000000 + 1) + 10000000
		int cel= 1500000000 + numero
		return cel
	}
}
