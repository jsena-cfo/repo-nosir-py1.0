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

public class StringCK {

	@Keyword
	def quitarCorchetes(String str) {

		String strSinCorcheteIzq= str.substring(1)

		String strSinCorcheteDer = strSinCorcheteIzq.replaceAll(']', '')

		return strSinCorcheteDer
	}

	@Keyword
	def quitarBlancos(String str) {
		String strSinBlancos = str.replaceAll('\\s', '')

		return strSinBlancos
	}

	@Keyword
	def quitarGuionesyBlancos(String str) {
		String strSinBlancos = str.replaceAll('\\s', '')

		String strSinGuionesNiBlancos = strSinBlancos.replaceAll('-', '')

		return strSinGuionesNiBlancos
	}

	@Keyword
	def quitarCaracteres(String str, String character) {
		String strSinChar = str.replaceAll(character, '')

		return strSinChar
	}

	@Keyword
	def quitarSubstringInicial(String str, int index) {
		String strModificado = str.substring(index)

		return strModificado
	}

	@Keyword
	def reemplazarSubstring(String str, String subString, String c) {
		String strModificado = str.replaceAll(subString, c)

		return strModificado
	}

	@Keyword
	def pasarAMayuscula(String str) {
		String strMayus= str.toUpperCase()
		return strMayus
	}

	@Keyword
	def pasarAMinuscula(String str) {
		String strMayus= str.toLowerCase()
		return strMayus
	}

	//Retorna un substring del string que recibe como parametro (str) dentro
	//del beginIndex y el endIndex
	//Ej: String a = "HelloWorld" =>  println(a.substring(4,8)) => oWor
	@Keyword
	def getSubstring(String str, int beginIndex, int endIndex) {
		String substring
		substring= str.substring(beginIndex, endIndex)
		return substring
	}

	//Retorna un substring del string que recibe como parametro (str)
	//desde el principio del str al endIndex
	//Ej: String a = "HelloWorld" => println(a.substring(4)) => oWorld
	@Keyword
	def getSubstring(String str, int endIndex) {
		String substring
		substring= str.substring(endIndex)
		return substring
	}
}
