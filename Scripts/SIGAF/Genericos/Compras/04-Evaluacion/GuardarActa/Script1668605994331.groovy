import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnGuardarActa.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardarActa.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarDatos.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSi.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacion.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarActualizacion.png', 'ComprasEvaluacion')


