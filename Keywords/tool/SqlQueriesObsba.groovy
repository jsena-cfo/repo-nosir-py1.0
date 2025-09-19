package tool

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class SqlQueriesObsba {

	/**#### Para BD ORACLE: Para BD de Usuarios y archivos ###**/
	//De test case DarRolAdministradorBD
	@Keyword
	queryInsertarAdministrador(String usuario){
		String sql= "INSERT INTO SLU.AUSUARIO_ROL(C_USER, C_ROL_USUARIO, FH_BAJA, FH_ALTA, FHU_ACTUALIZ, C_USUARIO) VALUES(" + usuario + ", 'OSBA_PERSONA_ADMIN', NULL, TIMESTAMP '2023-07-31 10:33:06.000000', TIMESTAMP '2023-07-31 10:33:06.000000', 'DEPLOY')"
		return sql
	}

	@Keyword
	queryInsertarAdministrador2(String usuario){
		String sql= "INSERT INTO SLU.AUSUARIO_ROL(C_USER, C_ROL_USUARIO, FH_BAJA, FH_ALTA, FHU_ACTUALIZ, C_USUARIO) VALUES(" + usuario + ", 'OSBA_PERSONA_ADMIN', NULL, TIMESTAMP '2023-07-31 10:33:06.000000', TIMESTAMP '2023-07-31 10:33:06.000000', 'DEPLOY')"
		return sql
	}

	@Keyword
	queryObtenerUsuarioAdministrador(String usuario){
		String sql= "SELECT * FROM SLU.AUSUARIO_ROL a WHERE a.c_user LIKE " + usuario
		return sql
	}

	@Keyword
	queryObtenerUsuarioAdministrador2(String usuario){
		String sql= "SELECT * FROM SLU.AUSUARIO_ROL a WHERE a.c_user LIKE " + usuario
		return sql
	}

	//De test case ObtenerTokenBD
	@Keyword
	queryObtenerTokenUsuarioPortal(String cuilSinGuiones){
		String sql= 'SELECT * FROM (SELECT a.c_guid FROM slu.busuario_portal a WHERE a.n_documento= ' + cuilSinGuiones + ' ORDER BY a.fh_alta DESC) WHERE ROWNUM = 1'
		return  sql
	}

	//De test case InsertarUsuariosSigafBD
	@Keyword
	queryObtenerBUsuario(String primerCuit){
		String sql = ('SELECT * FROM slu.busuario a WHERE a.c_user LIKE \'%REGRE%\' AND a.xc_user LIKE ' + primerCuit)
		return sql
	}

	@Keyword
	queryInsertarBUsuario(String usuario, String email, String n, String tipoDoc, String dniS){
		String query = (((((((((((('INSERT INTO SLU.BUSUARIO (C_USER,XC_USER,XL_EMAIL,M_ES_PRIVILEGIADO,N_MAX_DIAS_EXPIRA_PWD,N_MAX_DIAS_EXPIRA_CTA,N_INTENTOS_FALLIDOS_ING,T_DOCUMENTO,N_DOCUMENTO) VALUES (' +
				usuario) + ',') + usuario) + ',') + email) + ',') + n) + ',100,100,100,') + tipoDoc) + ',') + dniS) + ')')
		return query
	}

	//De test case ValidarBDPathAlmacenamiento
	@Keyword
	queeryObtenerBDocumentoParaCarpetaCuil(String numeroCarpeta, String cuil){
		String sql
		String partSql1= 'SELECT b.O_DOCUMENTO , b.fh_alta, t.O_USUARIO , t.O_CARPETA, t.O_USUARIO, t.O_CARPETA, b.R_RUTA '
		String partSql2= 'FROM slu.BDOCUMENTO b '
		String partSql3= 'INNER JOIN slu.ACARPETA_DOCUMENTO ad ON ad.O_DOCUMENTO = b.O_DOCUMENTO '
		String partSql4= 'INNER JOIN slu.TCARPETA t ON t.O_CARPETA = ad.O_CARPETA '
		String partSql5= 'INNER JOIN slu.busuario_portal p ON p.O_USUARIO= t.O_USUARIO '
		String partSql6= 'WHERE t.O_CARPETA= ' + numeroCarpeta + 'AND p.n_documento= ' + cuil + ' '
		String partSql7= 'ORDER BY b.fh_alta DESC'

		sql= partSql1 + partSql2 + partSql3 + partSql4 + partSql5 + partSql6 + partSql7

		return sql
	}

	@Keyword
	queryObtenerBDocumentoParaCarpetaCuil(String numeroCarpeta, String cuil){
		String sql
		String partSql1= 'SELECT b.O_DOCUMENTO , b.fh_alta, t.O_USUARIO , t.O_CARPETA, t.O_USUARIO, t.O_CARPETA, b.R_RUTA '
		String partSql2= 'FROM slu.BDOCUMENTO b '
		String partSql3= 'INNER JOIN slu.ACARPETA_DOCUMENTO ad ON ad.O_DOCUMENTO = b.O_DOCUMENTO '
		String partSql4= 'INNER JOIN slu.TCARPETA t ON t.O_CARPETA = ad.O_CARPETA '
		String partSql5= 'INNER JOIN slu.busuario_portal p ON p.O_USUARIO= t.O_USUARIO '
		String partSql6= 'WHERE t.O_CARPETA= ' + numeroCarpeta + 'AND p.n_documento= ' + cuil + ' '
		String partSql7= 'ORDER BY b.fh_alta DESC'

		sql= partSql1 + partSql2 + partSql3 + partSql4 + partSql5 + partSql6 + partSql7

		return sql
	}

	//De script ValidarBDUltimoDocSubidoNoNull
	@Keyword
	queryObtenerBDocumentoUltimoNoNull(String varUsuario){
		String sql= 'SELECT * FROM (SELECT * FROM slu.bdocumento INNER JOIN slu.busuario_portal ON bdocumento.o_usuario = busuario_portal.o_usuario WHERE busuario_portal.n_documento = ' + varUsuario + ' ORDER BY bdocumento.fh_alta DESC) WHERE ROWNUM = 1'
		return sql
	}

	//Retorna ultimo documento subido por un usuario
	@Keyword
	queryObtenerBDocumentoUltimoCargadoUsuario(String varUsuario){
		String sql= 'SELECT * FROM (SELECT * FROM slu.bdocumento INNER JOIN slu.busuario_portal ON bdocumento.o_usuario = busuario_portal.o_usuario WHERE busuario_portal.n_documento = ' + varUsuario + ' ORDER BY bdocumento.fh_alta DESC) WHERE ROWNUM = 1'
		return sql
	}

	@Keyword
	queryObtenerUsuarioCuilSinGuiones(String cuilSinGuiones){
		String sql= 'SELECT * FROM (SELECT a.c_guid FROM slu.busuario_portal a WHERE a.n_documento= ' + cuilSinGuiones + ' ORDER BY a.fh_alta DESC) WHERE ROWNUM = 1'
		return sql
	}

	//De script ValidarBDValorNull
	@Keyword
	queryObtenerBDocumentoNull(){
		String sql= 'SELECT * FROM( SELECT * FROM slu.bdocumento WHERE bdocumento.r_ruta LIKE ' + "'" + '%null%' + "'" + ') WHERE ROWNUM = 1'
		return sql
	}


	@Keyword
	queryObtenerBDocumentoNull2(){
		String sql= 'SELECT * FROM( SELECT * FROM slu.bdocumento WHERE bdocumento.r_ruta LIKE ' + "'" + '%null%' + "'" + ') WHERE ROWNUM = 1'
		return sql
	}

	//De script ValidarCambiosAdministrarUsuarioBD
	//De script ValidarFHBajaBD
	@Keyword
	queryObtenerBUsuarioPortal(String cuil){
		String sql= 'SELECT * FROM slu.busuario_portal a WHERE a.n_documento= ' + cuil //20120040899
		return sql
	}

	@Keyword
	queryObtenerBUsuarioNombre(String usuario){
		//Ej: SELECT * FROM slu.busuario a WHERE a.c_user LIKE '%REGRESION4080%'
		String sql= 'SELECT * FROM slu.busuario a WHERE a.c_user LIKE ' + "'%" + usuario + "%'"
		return sql
	}

	@Keyword
	queryObtenerBUsuarioNombreUsuario(String usuario, String nombreUsuario){
		String sql= 'SELECT * FROM slu.busuario a WHERE a.c_user LIKE ' + "'%" + usuario + "'%" + ' AND a.xc_user LIKE ' + "'%" + nombreUsuario + "%'"
		return sql
	}

	//Retorna el listado de tipo de carpeta que se encuentra en la BD
	@Keyword
	queryObtenerListadoTipoCarpeta(){
		String sql= 'SELECT b.XC_DESCRIPTOR FROM SLU.BDESCRIPTOR b WHERE b.C_ENTIDAD = ' + "'" + 'T_CARPETA_GESTION' + "'" + 'AND b.xc_descriptor NOT LIKE ' + "'" + 'DEUDA FLOTANTE' + "'"
		return sql
	}

	//Retorna los datos asociados a un usuario para su cuil y rol
	@Keyword
	queryObtenerDatosUsuarioCuilRol(String cuil, String rol){
		String sql= 'SELECT * ' +
				'FROM slu.busuario_portal a ' +
				'WHERE a.n_documento= ' + cuil +
				' AND a.t_perfil LIKE ' + "'" + '%' + rol + '%' + "'"
		return sql
	}

	//Retorna el proximo usuario interno a registrar
	@Keyword
	queryObtenerUsuarioSiguienteInsertado(String usuarioMin, String usuarioMax){
		String sql= 'SELECT * FROM (' +
				'SELECT a.c_user, a.n_documento FROM slu.busuario a WHERE NOT EXISTS ' +
				'(SELECT bp.c_user ' +
				'FROM slu.BUSUARIO_PORTAL bp ' +
				'WHERE bp.c_user LIKE ' + "'" + '%REGRE%' + "'"  + ' AND a.c_user = bp.c_user) ' +
				'AND a.c_user LIKE ' + "'" + '%REGRE%' + "' " +
				'AND a.c_user BETWEEN ' + "'"  + usuarioMin + "'"  + ' AND ' + "'" + usuarioMax + "'" +
				' ORDER BY a.c_user) WHERE ROWNUM = 1'

		//String sql= partSql1 + partSql2 + partSql3 + partSql4 + partSql5 + partSql6 + partSql7

		return sql
	}

	//Retorna el proximo usuario empleado a registrar
	@Keyword
	queryObtenerUsuarioSiguienteInsertadoEmpleado(String usuarioMin, String usuarioMax){
		String sql= 'SELECT * FROM (' +
				'SELECT a.xc_user, a.n_documento FROM slu.busuario a ' +
				'WHERE NOT EXISTS (SELECT bp.xc_user FROM slu.BUSUARIO_PORTAL bp ' +
				'WHERE bp.xc_user LIKE ' + "'" + '%REGRE%' + "'" + ' AND a.xc_user = bp.xc_user AND bp.t_perfil LIKE ' + "'" + '%Empleado%' + "'" +
				') AND a.xc_user LIKE ' + "'" +'%REGRE%' + "'" + ' AND a.xc_user BETWEEN ' + "'" + usuarioMin + "'" + ' AND ' + "'" + usuarioMax + "'" +
				'ORDER BY a.xc_user) WHERE ROWNUM = 1'

		return sql
	}



	/**##########################################**/
	/**#### Para BD SQL SERVER: BD de Recibos ###**/
	//Para BD de SQL Server
	@Keyword
	queryGenerarReciboEmpleadoCuil(String cuilParam){
		//'INSERT INTO Empleados.dbo.Recibo (idRecibo, periodoMes, periodoAnio, tipo, cuil, urlStorage, fechaAlta, fechaActualizacion) ' +'VALUES (0, 9, 2022, ' + "'" + 'RECIBO' + "'" + ', ' + cuilParam + ', ' + "'" + pathFile + "'"  + ', NULL, NULL)'
		String pathFile= 'salary/destino/27295011217/27295011217-SEP-2022-0.pdf'
		String sql= 'INSERT INTO Empleados.dbo.Recibo (idRecibo, periodoMes, periodoAnio, tipo, cuil, urlStorage, fechaAlta, fechaActualizacion) ' +
				'VALUES (0, 9, 2022, ' + "'" + 'RECIBO' + "'" + ', ' + cuilParam + ', ' + "'" + pathFile + "'"  + ',NULL, NULL)'

		return sql
	}

	@Keyword
	queryGenerarReciboEmpleadoCuilParam(String cuilParam, String pathFile, String numMes, String anio){
		//'INSERT INTO Empleados.dbo.Recibo (idRecibo, periodoMes, periodoAnio, tipo, cuil, urlStorage, fechaAlta, fechaActualizacion) ' +'VALUES (0, 9, 2022, ' + "'" + 'RECIBO' + "'" + ', ' + cuilParam + ', ' + "'" + pathFile + "'"  + ', NULL, NULL)'
		//String pathFile= 'salary/destino/27295011217/27295011217-SEP-2022-0.pdf'
		String sql= 'INSERT INTO Empleados.dbo.Recibo (idRecibo, periodoMes, periodoAnio, tipo, cuil, urlStorage, fechaAlta, fechaActualizacion) ' +
				'VALUES (0,' + numMes + ', ' + anio + ', ' + "'" + 'RECIBO' + "'" + ', ' + cuilParam + ', ' + "'" + pathFile + "'"  + ',NULL, NULL)'

		return sql
	}

	@Keyword
	queryObtenerReciboEmpleadoCuil(String cuilParam){
		String sql= 'SELECT * '+
				'FROM Empleados.dbo.Recibo a '
		'WHERE a.cuil= ' + "'" + cuilParam + "'" +
				' AND a.fechaActualizacion IS NULL'
		return sql
	}

	//Retorna un cuil del ultimo empleado al que se le creo un recibo
	@Keyword
	queryObtenerEmpleadoConRecibo(){
		String dniMin= '20120042514'
		String dniMax= '20120042565'
		String sql= 'SELECT TOP 1 id, idRecibo, periodoMes, tipo, cuil, urlStorage ' +
				'FROM Empleados.dbo.Recibo a '
		'WHERE a.cuil BETWEEN ' + "'" + dniMin + "'" + ' AND ' + "'" + dniMax + "'" + ' AND ' +
				'a.fechaActualizacion IS NULL ' +
				'ORDER BY a.cuil DESC'
		return sql
	}
}
