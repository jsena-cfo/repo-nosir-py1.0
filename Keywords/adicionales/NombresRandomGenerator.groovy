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

public class NombresRandomGenerator {
	@Keyword
	def obtenerNombreAleatorio() {
		def conjuntoNombres = [
			"Jon",
			"Mike",
			"Alexia",
			"Epaminondas",
			"Sofocles",
			"Obed",
			"Oliver",
			"Orson",
			"Ponce",
			"Prisco",
			"Privel",
			"Rafael",
			"Rei",
			"Rogan",
			"Sam",
			"Sean",
			"Stan",
			"Talor",
			"Teo",
			"Tico",
			"Unni",
			"Uriel",
			"Uwe",
			"Eudy",
			"Liyi",
			"Daela",
			"Eliz",
			"Yael",
			"Gia",
			"Tanit",
			"Laia",
			"Milu",
			"Max",
			"Muller",
			"Darlisa",
			"Alcairo",
			"Braider",
			"Eferson",
			"Kael",
			"Asaf",
			"Leam",
			"Emir",
			"Fais",
			"Egly",
			"Hohn",
			"Abisted",
			"Abeneiber",
			"Alfer",
			"Wali",
			"Ali",
			"Duvaam",
			"Yunior",
			"Masimiliano",
			"Abraham",
			"Giussepe",
			"Jesus",
			"Shimunkezhu",
			"Segundo",
			"Gaspar",
			"Patrocinio",
			"Williams",
			"Sekdxij",
			"Braidson",
			"Jairli",
			"Ainnys",
			"Javirck",
			"Kelly",
			"Rhiannis",
			"Yeilimar",
			"Dislexis",
			"Valloleidys",
			"Annastacia",
			"Ammilee",
			"Lis",
			"Kay",
			"Yariangelis",
			"Betsililiana",
			"Bunkwaneywin",
			"Nau",
			"Johendri",
			"Liannis",
			"Reinnibeth",
			"Eliu",
			"Juny",
			"Ryan",
			"Yaro",
			"Iam",
			"Davi",
			"Ian",
			"Jair",
			"Luis",
			"Yan",
			"Pool",
			"Eglimar",
			"Riuna",
			"Noema",
			"Eymi",
			"Lee",
			"Oilda",
			"Okari",
			"Onely"
		]

		def cantidadElementosCojunto = conjuntoNombres.size()
		def r = new Random()
		String nombreRandom= conjuntoNombres.get(r.nextInt(cantidadElementosCojunto))

		return nombreRandom
	}

	@Keyword
	def generarNombreDesdeCuit(String cuil) {
		String dni= cuil.substring(2,10)
		String cifrasFinales= dni.substring(4,7)
		String nombre= "REGRESION" + cifrasFinales
		return nombre
	}
}
