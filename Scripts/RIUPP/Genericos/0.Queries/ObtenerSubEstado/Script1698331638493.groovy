import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)
def query = """
SELECT eept.Estado
		FROM  [SEAC_CORE_ETAPA2_SADE].RPP.Tramite T 
		LEFT JOIN  [SEAC_CORE_ETAPA2_SADE].RPP.EvaluacionProveedorTramite ept on T.Id = ept.IdTramite  
		LEFT JOIN  [SEAC_CORE_ETAPA2_SADE].RPP.EstadoEvaluacionProveedorTramite eept on ept.EstadoEvaluacion = eept.Id 
		LEFT JOIN  [SEAC_CORE_ETAPA2_SADE].RPP.EstadoTramite et on T.EstadoTramite = et.Id 
		WHERE NumeroTramite = ${GlobalVariable.nroTramiteEval}
"""

ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	String estado = resultadoQuery.getString("Estado")
	KeywordUtil.logInfo("Estado obtenido: $estado")
	return estado
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
