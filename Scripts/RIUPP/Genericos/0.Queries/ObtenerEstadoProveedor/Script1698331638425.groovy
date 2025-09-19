import java.sql.ResultSet

import internal.GlobalVariable as GlobalVariable


CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

def query = "SELECT ep.Descripcion FROM [SEAC_CORE_ETAPA2_SADE].[RPP].[Proveedor] P INNER JOIN [SEAC_CORE_ETAPA2_SADE].[RPP].[Empresa] E on P.IdEmpresa = E.IdEmpresa INNER JOIN [SEAC_CORE_ETAPA2_SADE].[RPP].[EstadoProveedor] ep on P.IdEstadoProveedor = ep.IdEstadoProveedor where E.RazonSocial = '${GlobalVariable.razonSocial}'"

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while (resultadoQuery.next()) {
	def estadoProveedor = resultadoQuery.getString('Descripcion')
	return estadoProveedor
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
