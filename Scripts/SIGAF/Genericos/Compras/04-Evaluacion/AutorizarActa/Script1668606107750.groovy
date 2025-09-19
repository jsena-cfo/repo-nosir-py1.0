import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizar.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSiAutorizar.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizado.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarAutorizado.png', 'ComprasEvaluacion')
