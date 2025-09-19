import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIngresoCompleto.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIngresoCompleto.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarIngresoCompleto.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSiIngresoCompleto.png', 'ComprasEvaluacion')

/**Si aparece el error de ingreso completo**/
if(CustomKeywords.'tool.sikuli.existeImg'(screen,  'modalErrorIngresoCompleto.png', 'ComprasEvaluacion', 5)) {
	System.out.println("Se desplego el modal de error de ingreso completo")
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarModalErrorIngreso.png', 'ComprasEvaluacion')
}

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalIngresada.png', 'ComprasEvaluacion', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarIngresada.png', 'ComprasEvaluacion')

