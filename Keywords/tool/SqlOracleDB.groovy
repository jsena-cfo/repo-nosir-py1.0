package tool

import java.sql.Connection
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kms.katalon.core.annotation.Keyword
//import com.kms.katalon.core.annotation.Keyword


public class SqlOracleDB {

	private static Connection connection = null;

	@Keyword
	def conectarDB(String host, int puerto, String serviceName, String usuario, String pass) {
		Class.forName("oracle.jdbc.driver.OracleDriver")

		if(connection != null && !connection.isClosed()) connection.close()
		def conn = "jdbc:oracle:thin:@" + host + ":" + puerto + "/" + serviceName;

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
	def ejecutarUpdate(String queryString) {

		Statement stm = connection.createStatement()
		int rowsAffected = stm.executeUpdate(queryString)

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

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */
	@Keyword
	def connectDB(String dataFile){
		//Load driver class for your specific database type
		Class.forName("oracle.jdbc.driver.OracleDriver")
		String connectionString = "jdbc:sqlite:" + dataFile
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(connectionString)
		return connection
	}

	@Keyword
	def connectDB(){
		//jdbc:oracle:<drivertype>:<user>/<password>@<database>
		//ex: jdbc:oracle:thin:scott/tiger@host:1521:xe
		Class.forName("oracle.jdbc.driver.OracleDriver")
		//String connectionString = "jdbc:oracle:thin:username/password@ipaddress:port/servicename"
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		//String connection= "jdbc:oracle:thin:username/password@ipaddress:port/servicename"
		String connection= "jdbc:oracle:thin:USU_OBSBA/OBSBA2022@oradbpreprod02.hacienda-gcba.gov.ar:1521/OBSBAPRE"
		String username= "USU_OBSBA"
		String password= "OBSBA2022"
		//encode password to Base64: https://www.base64encode.org/
		String passwordBase64= 'T0JTQkEyMDIy'
		connection = DriverManager.getConnection(connection, username, passwordBase64)
		return connection
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */
	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	@Keyword
	def execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}
}
