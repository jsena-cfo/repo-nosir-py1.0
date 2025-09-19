import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaProyOC.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaProyOC.png', 'ComprasAdjudicacion')

/**Guardar**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardar.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardar.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardarSinCambios.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)