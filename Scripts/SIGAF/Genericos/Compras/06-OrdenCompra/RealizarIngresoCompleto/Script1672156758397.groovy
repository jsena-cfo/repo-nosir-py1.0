import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

/**Ingreso solapa Datos Orden Compra**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOrdenCompra.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIngresoCompleto.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIngresoCompleto.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarActualizacion.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalingresoCompleto.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

