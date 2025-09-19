import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String opcion= this.getBinding().getAt('varOpcion').toString()

Screen screen = new Screen()

System.out.println("Opcion ingresada: " + opcion)

switch(opcion) {
	case 'adjudicacion':
	  CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasAdjudicacion', 25)
	
	  CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optCompras.png', 'ComprasAdjudicacion')
	
	  CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optAdjudicacion.png', 'ComprasAdjudicacion')
	
	  CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optIngresodeOriginales.png', 'ComprasAdjudicacion')
    
	  break
	case 'protocolizacion':
	   CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optCompras.png', 'ComprasAdjudicacion', 25)
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optCompras.png', 'ComprasAdjudicacion')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optAdjudicacion.png', 'ComprasAdjudicacion')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optAutorizarAutoridad.png', 'ComprasAdjudicacion')
	   
	   CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optAutorizarActoAdjudicacion.png', 'ComprasAdjudicacion')
	   
	   break
 }

