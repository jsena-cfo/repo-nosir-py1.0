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

public class SqlQueriesBac {

	@Keyword
	queryUpdateFechaPrestacion(String numeroOca){
		String sql= "SELECT * FROM dbo.SolicitudProvision WHERE Numero LIKE '+ "'" + numeroOCA +"'" +'"
		return sql
	}

	//--reemplazás la fecha de FechaCreacion y número por los datos adecuado
	@Keyword
	queryUpdateFechaCreacion(String numeroOca, String fecha){
		String date= fecha + " 09:00:00.000"//2025-03-04 15:38:41.000
		String sql= "UPDATE [SEAC_CORE_ETAPA2_SADE].OC.OrdenCompraAbierta " +
				"SET FechaCreacion=" + "'" + fecha + "'" +
				" WHERE numero = " + "'" + numeroOca + "'"
		return sql
	}

	//--reemplazás la fecha de FechaInicio y número por los datos adecuados
	@Keyword
	queryUpdateFechaInicio(String numeroOca, String fecha){
		//String date= fecha + " 13:00:00.000"//2025-03-04 15:38:41.000
		String sql= "UPDATE [SEAC_CORE_ETAPA2_SADE].OC.OrdenCompraAbierta " +
				"SET FechaCreacion=" + "'" + fecha + "'" +
				" WHERE numero = " + "'" + numeroOca + "'"
		return sql
	}

	//--reemplazás la fecha de FechaInicio y número por los datos adecuados
	@Keyword
	queryUpdateFechasCronograma(String numeroOca, String fechaAyer, String fechaDentroVariosDias){
		//EJ: 2025-06-22 y 2025-06-30
		String sql= "UPDATE [SEAC_CORE_ETAPA2_SADE].OC.Cronogramaactualizacionprecios " +
				"SET fechaDesde = " + "'" + fechaAyer + "'" + ", FechaHasta= " + "'" + fechaDentroVariosDias + "' " +
				"WHERE id = (SELECT TOP 1 Id " +
				"FROM [SEAC_CORE_ETAPA2_SADE].OC.CronogramaActualizacionPrecios " +
				"WHERE FechaDesde<> " + "'" + fechaAyer  + "'" + " AND OCAID in (SELECT id " +
				"FROM [SEAC_CORE_ETAPA2_SADE].OC.OrdenCompraAbierta " +
				"WHERE numero= " + "'" + numeroOca + "'" + ") " +
				"ORDER BY Id ASC)"
		return sql
	}
	
	@Keyword
	queryUpdateFechasCronograma(String numeroOca, String hoy, String fechaAyer, String fechaDentroVariosDias){
		//EJ: 2025-06-22 y 2025-06-30
		String sql= "UPDATE [SEAC_CORE_ETAPA2_SADE].OC.Cronogramaactualizacionprecios " +
				"SET fechaDesde = " + "'" + fechaAyer + "'" + ", FechaHasta= " + "'" + fechaDentroVariosDias + "' " +
				"WHERE id = (SELECT TOP 1 Id " +
				"FROM [SEAC_CORE_ETAPA2_SADE].OC.CronogramaActualizacionPrecios " +
				"WHERE " + "'" + hoy + "'" + " NOT BETWEEN FechaDesde AND FechaHasta AND OCAID in (SELECT id " +
				"FROM [SEAC_CORE_ETAPA2_SADE].OC.OrdenCompraAbierta " +
				"WHERE numero= " + "'" + numeroOca + "'" + ") " +
				"ORDER BY Id ASC)"
		return sql
	}
}
