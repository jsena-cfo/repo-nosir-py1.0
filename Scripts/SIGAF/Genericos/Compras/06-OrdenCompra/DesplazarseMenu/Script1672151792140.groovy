import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

String opcion= this.getBinding().getAt('varOpcion').toString()

switch(opcion) {
	case "ordenCompra":
	   println("Menu Orden Compra")
	   CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasOrdenCompra', 25)
	   
	   CustomKeywords.'tool.sikuli.clickImg'(screen, 'optCompras.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optOrdenCompra.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optIngreso.png', 'ComprasOrdenCompra')
	   
	   break
	case "perfeccionamientoEnvio":
	   println("Menu Perfeccionamiento Envio")
	   
	   CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasOrdenCompra', 25)
	   
	   CustomKeywords.'tool.sikuli.clickImg'(screen, 'optCompras.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optOrdenCompra.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optPendientesEnvioProv.png', 'ComprasOrdenCompra')
	   
	   break
	   
	case "perfeccionamientoRespuesta":
	   println("Menu Perfeccionamiento Respuesta")
	   
	   CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasOrdenCompra', 25)
	   
	   CustomKeywords.'tool.sikuli.clickImg'(screen, 'optCompras.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optOrdenCompra.png', 'ComprasOrdenCompra')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optPendienteRespuestaProv.png', 'ComprasOrdenCompra')
	   
	   break
	   
	case "partePercepcionDefinitiva":
	   println("Menu Parte Percepcion Definitiva")
	
	   CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasOrdenCompra', 25)
	
	   CustomKeywords.'tool.sikuli.clickImg'(screen, 'optCompras.png', 'ComprasOrdenCompra')
	
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optParteRecepcion.png', 'ComprasOrdenCompra')
	
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optIngreso.png', 'ComprasOrdenCompra')
	
	   break
}


