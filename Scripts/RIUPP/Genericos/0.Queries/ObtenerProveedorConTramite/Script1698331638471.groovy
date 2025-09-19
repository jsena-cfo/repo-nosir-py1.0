import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)
//def query2 = "SELECT TOP 1 USS.LoweredUserName as Login, TR.NumeroTramite FROM []RPP.EMPRESA E JOIN RPP.PROVEEDOR P ON E.IDEMPRESA = P.IDEMPRESA JOIN RPP.TIPOPROVEEDOR TP ON P.IDTIPOPROVEEDOR = TP.IDTIPOPROVEEDOR left JOIN RPP.Tramite TR ON TR.IdProveedor = P.IdProveedor left JOIN RPP.ESTADOPROVEEDOR EP ON P.IDESTADOPROVEEDOR = EP.IDESTADOPROVEEDOR left JOIN RPP.PERSONALEGAL PL ON P.IDPROVEEDOR = PL.IDPROVEEDOR left JOIN DBO.ASPNET_USERS USS ON PL.IDUSUARIO = USS.USERID left join ADM.Usuario U ON USS.UserId=U.UserId and PL.IdUsuario=u.UserId WHERE pl.IdTipoPersonaLegal = 2 and TP.IdTipoProveedor in  (2,3,4,5,6,7,8) and U.Activo  = 1 ORDER BY E.FechaCreacion desc "

def query = """
SELECT TOP 1 USS.LoweredUserName as Login, TR.NumeroTramite FROM [SEAC_CORE_ETAPA2_SADE].RPP.EMPRESA E
JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PROVEEDOR P ON E.IDEMPRESA = P.IDEMPRESA
JOIN [SEAC_CORE_ETAPA2_SADE].RPP.TIPOPROVEEDOR TP ON P.IDTIPOPROVEEDOR = TP.IDTIPOPROVEEDOR
left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.Tramite TR ON TR.IdProveedor = P.IdProveedor
left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.ESTADOPROVEEDOR EP ON P.IDESTADOPROVEEDOR = EP.IDESTADOPROVEEDOR
left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PERSONALEGAL PL ON P.IDPROVEEDOR = PL.IDPROVEEDOR
left JOIN [SEAC_CORE_ETAPA2_SADE].DBO.ASPNET_USERS USS ON PL.IDUSUARIO = USS.USERID
left join [SEAC_CORE_ETAPA2_SADE].ADM.Usuario U ON USS.UserId=U.UserId and PL.IdUsuario=u.UserId
left join [SEAC_CORE_ETAPA2_SADE].RPP.EvaluacionProveedorTramite EPT ON TR.Id = EPT.IdTramite
WHERE pl.IdTipoPersonaLegal = 2
and TP.IdTipoProveedor in  (2,3,4,5,6,7,8)
and TR.EstadoTramite = 6
and EPT.EstadoEvaluacion in (3, 4, 5) 
and U.Activo  = 1
and USS.LoweredUserName like 'qa%'
ORDER BY NumeroTramite desc

"""
ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	userLogin = resultadoQuery.getString("Login")
	nroTramite = resultadoQuery.getString("NumeroTramite")
	def resultado = [userLogin, nroTramite]
	println resultado
	return resultado
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
