import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizar.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarAutorizar.png', 'ComprasSolicitudGasto')

