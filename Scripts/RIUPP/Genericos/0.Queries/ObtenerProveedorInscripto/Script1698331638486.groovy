import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)
//def estadoProveedor='Desactualizado Por Documentos Vencidos'
def query = """
SELECT TR.NumeroTramite, E.RAZONSOCIAL,
USS.LoweredUserName as Login

FROM [SEAC_CORE_ETAPA2_SADE].RPP.EMPRESA E

JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PROVEEDOR P ON E.IDEMPRESA = P.IDEMPRESA

JOIN [SEAC_CORE_ETAPA2_SADE].RPP.TIPOPROVEEDOR TP ON P.IDTIPOPROVEEDOR = TP.IDTIPOPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.Tramite TR ON TR.IdProveedor = P.IdProveedor

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.ESTADOPROVEEDOR EP ON P.IDESTADOPROVEEDOR = EP.IDESTADOPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PERSONALEGAL PL ON P.IDPROVEEDOR = PL.IDPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].DBO.ASPNET_USERS USS ON PL.IDUSUARIO = USS.USERID

left join [SEAC_CORE_ETAPA2_SADE].ADM.Usuario U ON USS.UserId=U.UserId and PL.IdUsuario=u.UserId

WHERE pl.IdTipoPersonaLegal  in (2)

and TP.IdTipoProveedor in  (2,3,4,5,6,7,8)

and U.Activo  = 1

and P.IdProveedor not in (SELECT IdProveedor from [SEAC_CORE_ETAPA2_SADE].rpp.tramite where EstadoTramite in (2,3,7))

and USS.LoweredUserName like ('%qa%')
and e.RazonSocial not in ('test')

and EP.Descripcion = 'Inscripto'

ORDER BY E.FechaCreacion desc

"""

print query
ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	String userProveedor = resultadoQuery.getString("login")
	String razonSocial = resultadoQuery.getString("RAZONSOCIAL")	
	KeywordUtil.logInfo("User Apoderado del proveedor: $userProveedor")
	KeywordUtil.logInfo("Razon Social: $razonSocial")
	
	return [userProveedor, razonSocial]
	
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
