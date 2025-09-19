import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaDatosContratacion.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosContratacion.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizar.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizar.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarAutorizar.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSiAutorizar.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizacionActualizada.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizacionAceptar.png', 'ComprasPliegos')

