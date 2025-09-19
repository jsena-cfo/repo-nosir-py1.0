import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizar.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizacionRealizada.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

