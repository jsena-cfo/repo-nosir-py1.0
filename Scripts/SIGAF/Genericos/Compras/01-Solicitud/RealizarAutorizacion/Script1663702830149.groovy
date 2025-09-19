import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalLimitacionAutorizar.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLimitacionAutorizar.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalLimitacionComprasAutorizar.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLimitacionCompra.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizarRealizada.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarAutorizarRealizada.png', 'ComprasSolicitudGasto')

