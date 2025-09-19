import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String numeroContratacion= this.getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

String diaHoy= CustomKeywords.'tool.DateGenerator.today'()

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'inpTipo.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpTipo.png', 'ComprasAdjudicacion')

/**Tipo**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '27')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Numero**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, numeroContratacion)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Anio Ejercicio**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Fecha**/
CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Dependencia**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')

CustomKeywords.'tool.sikuli.keyTab'(screen)


CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpTipoSade.png', 'ComprasAdjudicacion')

/**Tipo SADE**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'DECRE')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Numero SADE**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, numeroContratacion)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ejercicio SADE**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Reparticion SADE**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'MGEYA')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Reparticion Usuario SADE**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'MGEYA')

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Fecha presentacion SADE**/
CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)
