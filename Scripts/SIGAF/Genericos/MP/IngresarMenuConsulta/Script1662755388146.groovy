import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optConsulta.png', 'MPIngresarMenuPresupuesto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'optConsulta.png', 'MPIngresarMenuPresupuesto')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'menuIngresar.png', 'MPIngresarMenuPresupuesto')