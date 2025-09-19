import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
//if validar estado ingresado con OCR
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnPendiente.png', 'MPTransicionarPendiente', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnPendiente.png', 'MPTransicionarPendiente')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalPreguntaPendiente.png', 'MPTransicionarPendiente', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'MPTransicionarPendiente')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalOk.png', 'MPTransicionarPendiente', 25)
//validar leyenda modal ok con ocr  labelActualizacion.png
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarOk.png', 'MPTransicionarPendiente')
//salir entrar y validar estado pendiente fisica