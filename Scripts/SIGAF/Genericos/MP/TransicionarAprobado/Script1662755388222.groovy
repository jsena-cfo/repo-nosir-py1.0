import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
//if validar estado ingresado con OCR
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAprobar.png', 'MPTransicionarAprobada', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAprobar.png', 'MPTransicionarAprobada')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAprobar.png', 'MPTransicionarAprobada', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarAprobar.png', 'MPTransicionarAprobada')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalOk.png', 'MPTransicionarAprobada', 25)
//validar leyenda modal ok con ocr  labelActualizacion.png
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarOk.png', 'MPTransicionarAprobada')
//salir entrar y validar estado pendiente fisica