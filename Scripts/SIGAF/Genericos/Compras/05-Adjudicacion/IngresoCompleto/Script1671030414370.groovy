import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIngresoCompleto.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarIngresarCompleto.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalErrorAdjudicacion.png', 'ComprasAdjudicacion', 5)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
}

if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalErrorEnabledAdjudicacion.png', 'ComprasAdjudicacion', 5)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
}

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalIngresoCompletoRealizado.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)