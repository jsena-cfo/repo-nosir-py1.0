import java.sql.ResultSet;

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


def profilename = RunConfiguration.getExecutionProfile()

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_Notificaciones, GlobalVariable.userDB, GlobalVariable.passDB)

def query = ''

if(profilename == 'BAC_TEST' || profilename == 'BAC_HML') {
	query = "SELECT * FROM [API_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 536  and Destinatario = '${GlobalVariable.emailProveedor}' order by FechaCreacion desc"
	println query
}
else if(profilename == 'BAC_QA'){
	query = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 536  and Destinatario = '${GlobalVariable.emailProveedor}' order by FechaCreacion desc"
}

else if(profilename == 'BAC_PRE'){
	query = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 536  and Destinatario = '${GlobalVariable.emailProveedor}' order by FechaCreacion desc"
}

WebUI.delay(5)

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	cuerpoMail = resultadoQuery.getString("CuerpoMail")
	String numero = obtenerNumeroEntreTagsB(cuerpoMail)
	GlobalVariable.nroTramite = numero
	KeywordUtil.logInfo("Número obtenido: $numero")
	return numero
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()


def obtenerNumeroEntreTagsB(String texto) {
	def matcher = (texto =~ /<b>(\d+)<\/b>/)
	if (matcher.find()) {
		return matcher.group(1)
	} else {
		return null
	}
}
