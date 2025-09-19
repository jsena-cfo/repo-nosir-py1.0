import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

WebUI.delay(10)
def query = "SELECT et.Estado FROM [SEAC_CORE_ETAPA2_SADE].RPP.Tramite T LEFT JOIN [SEAC_CORE_ETAPA2_SADE].RPP.EstadoTramite et on T.EstadoTramite = et.Id WHERE T.NumeroTramite = ${GlobalVariable.nroTramiteEval}"
ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	String estado = resultadoQuery.getString("Estado")
	KeywordUtil.logInfo("Estado obtenido: $estado")
	return estado
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
