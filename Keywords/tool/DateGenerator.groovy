package tool
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.annotation.Keyword

import groovy.json.JsonSlurper

public class DateGenerator {
	/**
	 * Fecha actual en formato dd/MM/yyyy
	 */
	@Keyword
	def today(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		Date date = new Date()
		String today = dateFormat.format(date)
		return today
	}
	/**
	 * Fecha actual en formato yyyy-MM-dd
	 */

	@Keyword
	def tomorrow(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		Date date = new Date()
		String today = dateFormat.format(date.next())
		String tomorrow= today
		return tomorrow
	}
	/**
	 * Fecha actual en formato yyyy-MM-dd
	 */

	@Keyword
	def today2() {
		return new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date())
	}
	/**
	 * Fecha actual en formato parametrizado
	 */
	@Keyword
	def todayFormat(String format){
		DateFormat dateFormat = new SimpleDateFormat(format)
		Date date = new Date()
		String today = dateFormat.format(date)
		return today
	}

	/**
	 * Obtiene el siguiente dia valido sin contar sabado, domingos y feriados
	 */
	@Keyword
	def getNextValidWorkingDay(int n) {
		int currentYear = LocalDate.now().getYear()
		Set<LocalDate> holidays = fetchArgentineHolidays(currentYear)

		if (LocalDate.now().plusDays(n + 10).getYear() > currentYear) {
			holidays.addAll(fetchArgentineHolidays(currentYear + 1))
		}

		LocalDate date = LocalDate.now().plusDays(1)
		int addedDays = 0

		while (true) {
			if (isWorkingDay(date, holidays)) {
				addedDays++
				if (addedDays == n) {
					def formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
					return date.format(formatter)
				}
			}
			date = date.plusDays(1)
		}
	}
	def isWorkingDay(LocalDate date, Set<LocalDate> holidays) {
		DayOfWeek day = date.getDayOfWeek()
		return day != DayOfWeek.SATURDAY &&
				day != DayOfWeek.SUNDAY &&
				!holidays.contains(date)
	}

	def fetchArgentineHolidays(int year) {
		def url = new URL("https://api.argentinadatos.com/v1/feriados/${year}")
		def connection = url.openConnection()
		def response = connection.inputStream.withReader { new JsonSlurper().parse(it) }
		def formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

		Set<LocalDate> holidays = response.collect { item ->
			LocalDate.parse(item.fecha, formatter)
		} as Set

		return holidays
	}
	
	/**
	 * Suma dias laborales a la fecha ingresada por parametro
	 */
	@Keyword
	def addWorkingDays(String date, int days) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		LocalDate result = LocalDate.parse(date, formatter)
		int addedDays = 0
		while (addedDays < days) {
			result = result.plusDays(1)
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays
			}
		}
		return result.format(formatter)
	}
	
	/**
	 * Retorna el año actual como String
	 */
	@Keyword
	def currentYear() {
		String year = Calendar.getInstance().get(Calendar.YEAR)
		return year
	}

	/**
	 * Retorna el año actual como String
	 */
	@Keyword
	def nextYear() {
		def year = Calendar.getInstance()
		year.add(Calendar.YEAR, 1)
		String anioproximo = year.get(Calendar.YEAR)
		return anioproximo
	}

	/**
	 * Retorna la fecha dentro de un mes del dia de hoy
	 */
	@Keyword
	def dateTwoWeeksLaterToday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		LocalDate futureDate = LocalDate.now().plusWeeks(2) /**Trae la fecha dentro de dos semanas**/
		String fechaDentroDeDosSemanas= futureDate.format(formatter)
		return fechaDentroDeDosSemanas
	}

	@Keyword
	def dateNWeeksLaterToday(int n) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		LocalDate futureDate = LocalDate.now().plusWeeks(n) /**Trae la fecha dentro de n semanas**/
		String fechaDentroDeNSemanas= futureDate.format(formatter)
		return fechaDentroDeNSemanas
	}

	@Keyword
	def dateNDaysLaterToday(int n) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		LocalDate futureDate = LocalDate.now().plusDays(n) /**Trae la fecha dentro de n dias**/
		String fechaDentroDeNDias= futureDate.format(formatter)
		return fechaDentroDeNDias
	}

	@Keyword
	def dateNDaysLaterToday(int n, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format)
		LocalDate futureDate = LocalDate.now().plusDays(n) /**Trae la fecha dentro de n dias**/
		String fechaDentroDeNDias= futureDate.format(formatter)
		return fechaDentroDeNDias
	}

	@Keyword
	def dateNDaysBeforeToday(int n) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		LocalDate previousDate = LocalDate.now().minusDays(n) /**Trae la fecha anterior a n dias**/
		String fechaNDiasAntes= previousDate.format(formatter)
		return fechaNDiasAntes
	}


	@Keyword
	def timeNow() {
		LocalTime hora= LocalTime.now()
		String tiempo= hora.getHour().toString() + ':' + hora.getMinute().toString()
		return tiempo
	}

	@Keyword
	def timeNowComplete() {
		LocalTime hora= LocalTime.now()
		String tiempo= hora.toString()
		/**Aplica el formato HH:mm:ss al string**/
		String tiempoCompleto= tiempo.substring(0, 8)
		return tiempoCompleto
	}

	@Keyword
	def timeNowPlusMinutes(Long minutesToAdd) {
		LocalTime hora= LocalTime.now()
		LocalTime nuevaHora= hora.plusMinutes(minutesToAdd)
		String tiempo= nuevaHora.getHour().toString() + ':' + nuevaHora.getMinute().toString()
		return tiempo
	}

	@Keyword
	def timeNowPlusSeconds(Long secondsToAdd) {
		LocalTime horaAhora= LocalTime.now()
		LocalTime nuevaHora
		String nuevaHoraStr


		//if(horaAhora.getMinute() >= 30) {
		System.out.println("Segundos de horario: " + horaAhora.getSecond())
		if((horaAhora.getSecond() >= 35)&&(horaAhora.getSecond() < 59)) {
			nuevaHora= horaAhora.plusSeconds(secondsToAdd + 25)
		}
		else {
			nuevaHora= horaAhora.plusSeconds(secondsToAdd)
		}
		nuevaHoraStr= nuevaHora.toString()
		String tiempo= nuevaHoraStr.substring(0, 8) /**Aplica el formato HH:mm:ss al string**/
		return tiempo
	}

	@Keyword
	def secondsBetweenTimes(String time1, String time2) {
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss")
		Date date1 = simpleDateFormat.parse(time1)
		Date date2 = simpleDateFormat.parse(time2)
		// Calculating the difference in milliseconds
		long differenceInMilliSeconds= Math.abs(date2.getTime() - date1.getTime())
		long differenceInSeconds= (differenceInMilliSeconds / 1000) //% 60
		String diferenciaEnSegundos= differenceInSeconds.toString()
		System.out.println("Diferencias en segundos: " + diferenciaEnSegundos)
		return diferenciaEnSegundos
	}

	@Keyword
	def timeTruncateSecond(String horario) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
		LocalTime time = LocalTime.parse(horario, formatter)
		String tiempo= time.getHour().toString() + ':' + time.getMinute().toString()
		return tiempo
	}

	@Keyword
	def timeTruncateSecondStr(String horario) {
		String tiempo
		tiempo= horario.substring(0,5) /**Aplica el formato HH:mm al string**/
		return tiempo
	}
	@Keyword
	def dateAndTime() {
		def fechaHora = new Date().format("ddMMHHmmss")
		return fechaHora
	}

	@Keyword
	def dateYearAndTime() {
		def fechaHora = new Date().format("ddMMyyyyHHmmss")
		return fechaHora
	}

	/**
	 * Fecha actual en formato dd/MM/yyyy y hora
	 */
	@Keyword
	def todayAndTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
		Date date = new Date()
		String today = dateFormat.format(date)
		return today
	}

	/**
	 * Valida si una fecha esta dentro de un rango de fechas
	 */
	@Keyword
	def isDateBetweenDates(String fecha, String minFecha, String maxFecha){
		//boolean isBetween= false
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		Date dataFormateado = dateFormat.parse(fecha)
		Date dataFormateadoMin = dateFormat.parse(minFecha)
		Date dataFormateadoMax = dateFormat.parse(maxFecha)
		return dataFormateadoMin.compareTo(dataFormateado) * dataFormateado.compareTo(dataFormateadoMax) > 0
	}

	/**
	 * Fecha ayer en formato yyyy-MM-dd
	 */
	@Keyword
	def yerterday(String format){
		DateFormat dateFormat = new SimpleDateFormat(format) //ej: "dd/MM/yyyy"

		Calendar cal = Calendar.getInstance()
		cal.add(Calendar.DATE, -1)

		//Date date = new Date()
		String yesterday = dateFormat.format(cal.getTime())

		return yesterday
	}
}
