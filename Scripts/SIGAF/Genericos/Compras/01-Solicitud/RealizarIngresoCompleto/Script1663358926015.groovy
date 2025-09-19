import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIngresoCompleto.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIngresoCompleto.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalLimitacion.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLimitacion.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalLimitacionSigaf.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLimitacionSigaf.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacionCompleta.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'bntAceptarCompleta.png', 'ComprasSolicitudGasto')


