import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnGuardarOC.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardarOC.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardarOC.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacion.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)
