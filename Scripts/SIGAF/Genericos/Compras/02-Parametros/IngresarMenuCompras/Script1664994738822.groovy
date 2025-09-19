import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'menuCompras.png', 'ComprasParametros', 25)
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'menuCompras.png', 'ComprasParametros')