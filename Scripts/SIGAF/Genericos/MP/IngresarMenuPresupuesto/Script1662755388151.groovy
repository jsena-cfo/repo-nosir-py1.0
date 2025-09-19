import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImgTarget'(screen, 'menuPresupuesto.png', 'MPIngresarMenuPresupuesto', 0, 0, 25)
CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'menuPresupuesto.png', 'MPIngresarMenuPresupuesto', 0, 0)
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optMP.png', 'MPIngresarMenuPresupuesto')
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optIngresoYModifReq.png', 'MPIngresarMenuPresupuesto')

