import java.sql.ResultSet

import com.kms.katalon.core.util.KeywordUtil

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

CustomKeywords.'tool.sqlServerDB.conectarDB'(GlobalVariable.hostDB_SADE, GlobalVariable.userDB, GlobalVariable.passDB)
//def estadoProveedor='Desactualizado Por Documentos Vencidos'
def query = """

SELECT top 1 E.RAZONSOCIAL, 
USS.LoweredUserName as Login
FROM [SEAC_CORE_ETAPA2_SADE].RPP.EMPRESA E
JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PROVEEDOR P ON E.IDEMPRESA = P.IDEMPRESA
JOIN [SEAC_CORE_ETAPA2_SADE].RPP.TIPOPROVEEDOR TP ON P.IDTIPOPROVEEDOR = TP.IDTIPOPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.Tramite TR ON TR.IdProveedor = P.IdProveedor

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.ESTADOPROVEEDOR EP ON P.IDESTADOPROVEEDOR = EP.IDESTADOPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].RPP.PERSONALEGAL PL ON P.IDPROVEEDOR = PL.IDPROVEEDOR

left JOIN [SEAC_CORE_ETAPA2_SADE].DBO.ASPNET_USERS USS ON PL.IDUSUARIO = USS.USERID

left join [SEAC_CORE_ETAPA2_SADE].ADM.Usuario U ON USS.UserId=U.UserId and PL.IdUsuario=u.UserId

WHERE pl.IdTipoPersonaLegal  in (1,2)

and TP.Descripcion = '${TipoProveedor}'
and P.HizoTramiteActualizacion=1
and U.Activo  = 1
and P.IdProveedor not in (SELECT IdProveedor from [SEAC_CORE_ETAPA2_SADE].rpp.tramite where EstadoTramite in (2,3,7))
and P.EsNuevoEsquema=0
and EP.Descripcion = 'Inscripto'
ORDER BY E.FechaCreacion desc

"""


ResultSet resultadoQuery = CustomKeywords.'tool.sqlServerDB.ejecutarQuery'(query)

while(resultadoQuery.next()) {
	String userProveedor = resultadoQuery.getString("login")
	String razonSocial = resultadoQuery.getString("RAZONSOCIAL")	
	KeywordUtil.logInfo("User Apoderado del proveedor: $userProveedor")
	KeywordUtil.logInfo("Razon Social: $razonSocial")
	
	return [userProveedor, razonSocial]
	
}
CustomKeywords.'tool.sqlServerDB.cerrarConexionDB'()
