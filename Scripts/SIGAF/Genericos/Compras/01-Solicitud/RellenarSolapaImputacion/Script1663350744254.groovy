import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


String varOgto= this.getBinding().getAt('varOgto').toString()
String varActint= this.getBinding().getAt('varActint').toString()
String varFuente= this.getBinding().getAt('varFuente').toString()
String varMon= this.getBinding().getAt('varMon').toString()
String varUbicacion= this.getBinding().getAt('varUbicacion').toString()
String varImporte= this.getBinding().getAt('varImporte').toString()


Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaImputacion.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaImputacion.png', 'ComprasSolicitudGasto')

/**'295'**/
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inputOGto.png', 'ComprasSolicitudGasto', -4, 11, varOgto)
CustomKeywords.'tool.sikuli.keyTab'(screen)

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'()

CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**'AOQ'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varActint)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**'11'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varFuente)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**11**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varMon)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**11**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varUbicacion)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**162198.08**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varImporte)
CustomKeywords.'tool.sikuli.keyTab'(screen)