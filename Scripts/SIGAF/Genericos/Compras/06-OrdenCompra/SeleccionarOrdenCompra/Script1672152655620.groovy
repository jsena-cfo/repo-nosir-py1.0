import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String numeroContratacion= this.getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

//CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btningresar2.png', 'ComprasOrdenCompra', 25)

//CustomKeywords.'tool.sikuli.clickImg'(screen, 'btningresar2.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.keyF7'(screen) /**tecla de ingreso**/

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, numeroContratacion)

CustomKeywords.'tool.sikuli.keyF8'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnV.png', 'ComprasOrdenCompra')


/**Ingreso solapa Datos OC Cont**/

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaDatosOCCont.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOCCont.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'inpCondicionPago.png', 'ComprasOrdenCompra', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpCondicionPago.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '30') /**Ingreso dias**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorCondicionPago.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpDetalle.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto detalle') /**Ingreso detalle**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorDelegacion.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpLugar.png', 'ComprasOrdenCompra')

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1') /**Valor lugar entrega**/

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Lunes a viernes 09 a 18 hs') /**Plazo de entrega y horario**/

/**Ingreso solapa Items**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItems.png', 'ComprasOrdenCompra')

/**Ingreso solapa Bonificaciones**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaBonificaciones.png', 'ComprasOrdenCompra')

/**Ingreso solapa Imp Presupuestarias**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaImpPresupuestarias.png', 'ComprasOrdenCompra')

/**Ingreso solapa Redeterminacion**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaRedeterminacion.png', 'ComprasOrdenCompra')

/**Ingreso solapa Datos Orden Compra**/

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosOrdenCompra.png', 'ComprasOrdenCompra')
