import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)
def query = """SELECT top 1 T.NumeroTramite 
FROM [SEAC_CORE_ETAPA2_SADE].RPP.Tramite T  
LEFT JOIN [SEAC_CORE_ETAPA2_SADE].RPP.EvaluacionProveedorTramite ept on T.Id = ept.IdTramite 
LEFT JOIN [SEAC_CORE_ETAPA2_SADE].RPP.EstadoEvaluacionProveedorTramite eept on ept.EstadoEvaluacion = eept.Id  
LEFT JOIN [SEAC_CORE_ETAPA2_SADE].RPP.EstadoTramite et on T.EstadoTramite = et.Id 
WHERE IdProveedor = 	(select top 1 IdProveedor from [SEAC_CORE_ETAPA2_SADE].RPP.Proveedor P 
INNER JOIN [SEAC_CORE_ETAPA2_SADE].RPP.Empresa E on P.IdEmpresa = E.IdEmpresa 
where E.RazonSocial ='${GlobalVariable.razonSocial}' order by FechaPreInscripcion desc) 
order by FechaCreacion desc"""

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	String tramite = resultadoQuery.getString("NumeroTramite")
	GlobalVariable.nroTramiteEval = tramite
	KeywordUtil.logInfo("Número obtenido: $tramite")
	return tramite
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()

