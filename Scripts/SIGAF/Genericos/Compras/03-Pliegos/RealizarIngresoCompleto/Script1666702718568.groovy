import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaDatosContratacion.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosContratacion.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIngresoCompleto.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIngresoCompleto.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmacion.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnConfirmarAceptar.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizado.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'ComprasPliegos')

