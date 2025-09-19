package tool

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class sqlServerDB {

	private static Connection connection = null;

	@Keyword
	def conectarDB(String host, String usuario, String pass) {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		if(connection != null && !connection.isClosed()) connection.close()

		String conn = "jdbc:sqlserver://" + host
		//Connection conn = DriverManager.getConnection("jdbc:sqlserver://BACAPISQLAB01\\API_QA","usrSEAC","u53r534c09");
		connection = DriverManager.getConnection(conn, usuario, pass)

		return connection
	}
	
	@Keyword
	def conectarDBSecure(String host, String usuario, String pass) {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		if(connection != null && !connection.isClosed()) connection.close()

		String conn = "jdbc:sqlserver://" + host + ";encrypt=true;trustServerCertificate=true;"
		//Connection conn = DriverManager.getConnection("jdbc:sqlserver://BACAPISQLAB01\\API_QA","usrSEAC","u53r534c09");
		connection = DriverManager.getConnection(conn, usuario, pass)

		return connection
	}

	@Keyword
	def ejecutarQuery(String queryString) {

		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def ejecutarUpdate(String updateString) {

		Statement stm = connection.createStatement()
		int rowsAffected = stm.executeUpdate(updateString)

		if (rowsAffected > 0) {
			System.out.println("La inserción fue exitosa.");
			//connection.commit();
		} else {
			System.out.println("No se pudo realizar la inserción.");
		}
	}

	@Keyword
	def cerrarConexionDB() {

		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}
	@Keyword
	def verEstadoProceso() {

		conectarDB(GlobalVariable.hostDB_Notificaciones, GlobalVariable.userDB, GlobalVariable.passDB)
		
		def queryBCiudad = "select e.NombreEstadoPliego from [SEAC_CORE_ETAPA2_SADE].pli.Pliego p inner join [SEAC_CORE_ETAPA2_SADE].pli.EstadoPliego e on p.EstadoPliego=e.IdEstadoPliego where NumeroPliego = '${GlobalVariable.nroPC}'"
		
		ResultSet resultadoQuery = ejecutarQuery(queryBCiudad)
		
		while(resultadoQuery.next()) {
			def NombreEstadoPliego = resultadoQuery.getString("NombreEstadoPliego")
			return NombreEstadoPliego
		}
		cerrarConexionDB()
		
		
	}
	
}

