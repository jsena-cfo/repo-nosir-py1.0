import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**Entorno Produccion**/
//String produccion= "jnlp://oraformsab02.hacienda-gcba.gov.ar:9001/forms/frmservlet?config=SIGQACFO"

/**Entorno Preproduccion**/
//String preproduccion= "jnlp://oraformsab02.hacienda-gcba.gov.ar:9001/forms/frmservlet?config=preprod"

/**Entorno QA Automation**/
Process p = Runtime.getRuntime().exec('cmd /c start iexplore "jnlp://oraformsab02.hacienda-gcba.gov.ar:9001/forms/frmservlet?config=SIGQACFO"')

/**Entorno Preproduccion**/
//Process p = Runtime.getRuntime().exec('cmd /c start iexplore "jnlp://oraformsab02.hacienda-gcba.gov.ar:9001/forms/frmservlet?config=preprod"')
