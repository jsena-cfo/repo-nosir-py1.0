package adicionales

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
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

public class CuilRandomGenerator{
	@Keyword
	def get_cuil(String gender, String document_number) {
		String AB
		String C
		int rest
		def i
		//gender = gender.toUpperCase()
		if(gender=="Masculino")
			AB = '20'

		else if (gender =="Femenino")
			AB = '27'
		else
			AB = '30'

		def a=AB.substring(0, 1).toInteger()
		def b=AB.substring(1).toInteger()
		//println a
		//println b
		def multipliers = [3, 2, 7, 6, 5, 4, 3, 2]
		def calculation = (a * 5) + (b * 4)
		int digit
		for (i=0;i<8;i++) {
			digit=document_number.substring(i,(i+1)).toInteger()
			//println document_number.substring(i, i+1)
			calculation= calculation + (digit * multipliers[i])
		}
		rest = calculation % 11
		println rest

		if ((gender=="Masculino"|| gender=="Femenino") && rest == 1) {
			if(gender=="Masculino")
				C = '9'
			else
				C = '4'
			AB = '23'
		}
		else if (rest == 0) {
			C = '0'
		}
		else {
			C = (11 - rest)
			if((C == '10' || C == '11') &&  gender !="Femenino"  && gender != "Masculino") {
				C = '9'
				AB = '33'
			}
		}

		//println(AB+document_number+C)
		String cuitGenerado= (AB+ document_number+ C)

		return cuitGenerado
	}

	@Keyword
	def get_cuil_conGuiones(String gender, String document_number) {
		String cuilFormato
		String cuil= get_cuil(gender, document_number)
		String genero= cuil.substring(0,2)
		String dni= cuil.substring(2,10)
		String validar= cuil.substring(10)
		cuilFormato= genero + '-' + dni + '-' + validar

		return cuilFormato
	}

	@Keyword
	def quitarGuionesyBlancos(String cuitDisponible) {
		String cuilSinBlancos = cuitDisponible.replaceAll('\\s', '')

		String cuilSinGuionesNiBlancos = cuilSinBlancos.replaceAll('-', '')

		return cuilSinGuionesNiBlancos
	}

	@Keyword
	def get_dni_fromCuil(String cuil) {
		String dni
		dni= cuil.substring(2,10)
		return dni
	}

	@Keyword
	def agregarGuionesCuil(String cuil) {
		String cuilConGuiones= cuil.substring(0,2) + '-' + cuil.substring(2,10) + '-' + cuil.substring(10,11)
		return cuilConGuiones
	}

	@Keyword
	def generarNombreUsuarioConCuilSinGuiones(String cuilSinGuiones) {
		String nombre = "REGRESION" + cuilSinGuiones.substring(6,10)
		return nombre
	}

	@Keyword
	def generarNombreUsuarioParamConCuilSinGuiones(String nombre, String cuilSinGuiones) {
		String nombreCompuesto = nombre + cuilSinGuiones.substring(6,10)
		return nombreCompuesto
	}

	@Keyword
	def obtenerUltimos4DigitosDni(String dni) {
		String ultimos4 = dni.substring(4,8)
		return ultimos4
	}
}
