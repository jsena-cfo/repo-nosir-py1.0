import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnConfirmarOferta.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnConfirmarOferta.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarOferta.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.keyEnter'(screen)

//CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmadaOferta.png', 'ComprasEvaluacion', 25)
//CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalOfertaCoincidirMonto.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalOfertaConfirmada.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.keyEnter'(screen)