import java.sql.ResultSet

@Grab(group='org.jsoup', module='jsoup', version='1.14.3')
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import internal.GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration


def profilename = RunConfiguration.getExecutionProfile()

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_Notificaciones, GlobalVariable.userDB, GlobalVariable.passDB)

def queryBCiudad = ''

if(profilename == 'BAC_TEST' || profilename == 'BAC_HML') {
	queryBCiudad = "SELECT * FROM [API_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 621 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"
	
}
else if(profilename == 'BAC_QA'){
	queryBCiudad = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 621 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"	
}
else if(profilename == 'BAC_PRE'){
	queryBCiudad = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 621 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"
}

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(queryBCiudad)

while(resultadoQuery.next()) {
	cuerpoMail = resultadoQuery.getString("CuerpoMail")
	String nuevaDireccion = GlobalVariable.url_BAC
	String htmlModificado = obtenerEnlace(cuerpoMail, nuevaDireccion)
	
	println "Enlace de confirmacion:\n$htmlModificado"
	
	return htmlModificado
	
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()


String obtenerEnlace(String html, String nuevaDireccion) {
	Document doc = Jsoup.parse(html)
	def link = doc.select('a.linkazul')
	link.attr('href', link.attr('href').replaceFirst("https://www.buenosairescompras.gov.ar", nuevaDireccion))
	return doc.select('a.linkazul').attr('href')
}
