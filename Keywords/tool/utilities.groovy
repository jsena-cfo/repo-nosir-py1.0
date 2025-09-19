package tool

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class utilities {
	@Keyword
	def zoom(def porcentaje) {
		WebUI.executeJavaScript('document.body.style.zoom=\''+porcentaje.toString()+'%\'', null)
	}
	@Keyword
	def capitalize(def text) {
		text = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase()
		return text
	}
	@Keyword
	def getRowCounts(def xpathTable, def xpathRows) {
		WebElement Table = DriverFactory.getWebDriver().findElement(By.xpath(xpathTable))
		List<WebElement> table_row = Table.findElements(By.xpath(xpathRows))
		int rows_count = table_row.size()
		return rows_count
	}

	@Keyword
	def cuitRandom() {

		String AB
		String C
		int rest
		def i
		String gender = obtenerGeneroAleatorio()
		String dni = generarDNIRandom()

		if(gender=="Masculino")
			AB = '20'

		else if (gender =="Femenino")
			AB = '27'
		else
			AB = '30'

		def a=AB.substring(0, 1).toInteger()
		def b=AB.substring(1).toInteger()
		def multipliers = [3, 2, 7, 6, 5, 4, 3, 2]
		def calculation = (a * 5) + (b * 4)
		int digit
		for (i=0;i<8;i++) {
			digit=dni.substring(i,(i+1)).toInteger()

			calculation= calculation + (digit * multipliers[i])
		}
		rest = calculation % 11

		if ((gender=="Masculino"|| gender=="Femenino") && rest == 1) {
			if(gender=="M")
				C = '9'
			else
				C = '4'
			AB = '23'
		}
		else if (rest == 0) {
			C = '0'
		}
		else {
			C = 11 - rest
		}
		String cuitGenerado= (AB+ dni+ C)

		return cuitGenerado
	}
	def obtenerGeneroAleatorio() {
		def conjuntoGeneros = ["Masculino", "Femenino"]

		def cantidadElementosCojunto = conjuntoGeneros.size()
		def r = new Random()
		String nombreRandom= conjuntoGeneros.get(r.nextInt(cantidadElementosCojunto))

		return nombreRandom
	}

	def generarDNIRandom() {
		int dniRandomInt = new Random().nextInt(45999999 - 20000000 + 1) + 10000000
		return dniRandomInt
	}
}
