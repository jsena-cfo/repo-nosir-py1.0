import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()
/**Ingreso solapa Datos del dictamen Cont**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosDictamenCont.png', 'ComprasEvaluacion')

/**Ingreso solapa Items**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItemsDictamen.png', 'ComprasEvaluacion')

/**Ingreso de orden de merito para oferta**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'barraTitulos.png', 'ComprasEvaluacion', 25)

/**Carga informacion en el selector**/
//CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorEstado3.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyUp'(screen)

//CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Presiona boton Traer todas las ofertas**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnTraerTodasOfertas.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnTraerTodasOfertas.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpOrdenMerito.png', 'ComprasEvaluacion', 1, 14)

//CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpOrdenMerito.png', 'ComprasEvaluacion', 1, 14)

if (CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalErrorDictamen.png', 'ComprasEvaluacion', 5)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
}

if (CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalDetalleItem.png', 'ComprasEvaluacion', 5)) {
	CustomKeywords.'tool.sikuli.keyEnter'(screen)
}

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpOrdenMerito.png', 'ComprasEvaluacion', 1, 14)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, "1") /**Valor orden merito**/

CustomKeywords.'tool.sikuli.delay'(2)

/**Ingreso solapa Datos del dictamen**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosDelDictamen.png', 'ComprasEvaluacion')