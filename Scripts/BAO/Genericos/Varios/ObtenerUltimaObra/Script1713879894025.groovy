import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

CustomKeywords.'tool.SqlOracleDB.conectarDB'(GlobalVariable.hostDB, GlobalVariable.puertoDB, GlobalVariable.serviceNameDB, GlobalVariable.userDB, GlobalVariable.passDB)

def query = 'SELECT * FROM (select * from slu.obp_dobra a order by a.o_obra desc) WHERE ROWNUM = 1'

ResultSet resultadoQuery = CustomKeywords.'tool.SqlOracleDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
   nroObra = resultadoQuery.getString("O_OBRA")
   GlobalVariable.nroObra = nroObra
   KeywordUtil.logInfo("Número obtenido: $nroObra")
   return nroObra
}
CustomKeywords.'tool.SqlOracleDB.cerrarConexionDB'()