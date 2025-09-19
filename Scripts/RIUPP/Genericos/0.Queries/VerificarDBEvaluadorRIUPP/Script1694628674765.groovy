import java.sql.ResultSet

import internal.GlobalVariable

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)

def query = "SELECT * FROM [SEAC_CORE_ETAPA2_SADE].[RPP].[Tramite] where NumeroTramite = $nroTramite.toString()"

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

String evaluador

while (resultadoQuery.next()) {
    evaluador = resultadoQuery.getString('idEvaluadorRIUPP')
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()

println(evaluador)

assert evaluador == '38467' : 'Evaluador Francisco Ciorciari no encontrado.'
