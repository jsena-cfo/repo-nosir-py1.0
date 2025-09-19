import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaImputacion.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaImputacion.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'inpOgtoConsulta.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpOgtoConsulta.png', 'ComprasSolicitudGasto', 6, 10)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnConsultarCredito.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnConsultarCredito.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'lblConsultaEjecucion', 'ComprasSolicitudGasto', 25)
if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'lblConsultaEjecucion', 'ComprasSolicitudGasto', 15)) {
	assert true
}
else {
	assert false
}



