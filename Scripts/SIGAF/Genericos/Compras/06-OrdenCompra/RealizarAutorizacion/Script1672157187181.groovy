import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

/**Ingreso solapa Datos Orden Compra**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOrdenCompra.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarAutorizar.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAdvertenciaRedeterminacion.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizacionRealizada.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalErrorHorario.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)


