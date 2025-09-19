import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
//if validar estado ingresado con OCR
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnPendienteFisica.png', 'MPTransicionarPendienteFisica', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnPendienteFisica.png', 'MPTransicionarPendienteFisica')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalPendiente.png', 'MPTransicionarPendienteFisica', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'MPTransicionarPendienteFisica')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalOk.png', 'MPTransicionarPendienteFisica', 25)
//validar leyenda modal ok con ocr  labelActualizacion.png
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarActualizacion.png', 'MPTransicionarPendienteFisica')
//salir entrar y validar estado pendiente fisica
