import java.sql.ResultSet as ResultSet
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration


def profilename = RunConfiguration.getExecutionProfile()

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_Notificaciones, GlobalVariable.userDB, GlobalVariable.passDB)

def queryBCiudad = ''

if(profilename == 'BAC_TEST' || profilename == 'BAC_HML') {
	queryBCiudad = "SELECT * FROM [API_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 113 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"	
}
else if(profilename == 'BAC_QA'){
	queryBCiudad = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 113 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"
}
else if(profilename == 'BAC_PRE'){
	queryBCiudad = "SELECT * FROM [BAC_NOTIFICACIONES].[dbo].[NotificacionMensajeria] where tipoCorreo = 113 and Destinatario = '${GlobalVariable.emailAdminLeg}' order by FechaCreacion desc"
}

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(queryBCiudad)

while (resultadoQuery.next()) {
    cuerpoMail = resultadoQuery.getString('CuerpoMail')

    def credenciales = obtenerCredenciales(cuerpoMail)
    def usuario = credenciales[0]
    def contrasena = credenciales[1]

    println("Nombre de usuario: $usuario")
    println("Contraseña: $contrasena")
	
	return credenciales
}

CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()

def obtenerCredenciales(String texto) {
    def usuarioMatcher = texto =~ 'Nombre de usuario: <strong>([^<]+)</strong>'
    def contrasenaMatcher = texto =~ 'Contraseña: <strong>([^<]+)</strong>'

    def usuario = usuarioMatcher.find() ? usuarioMatcher.group(1) : null
    def contrasena = contrasenaMatcher.find() ? contrasenaMatcher.group(1) : null

    return [usuario, contrasena]
}