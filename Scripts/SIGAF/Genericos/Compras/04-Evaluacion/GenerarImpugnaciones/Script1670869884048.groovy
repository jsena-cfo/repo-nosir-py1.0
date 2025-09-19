import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String varNumeroDictamen= this.getBinding().getAt('varNumeroDictamen').toString()

Screen screen = new Screen()
/**Ingreso solapa Datos del dictamen Cont**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaImpugnaciones.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnCerrarEtapaImp.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnCerrarEtapaImp.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalCerrarEtapaImp.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalingresoActoSimplificado.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.delay'(2)

/**Ingreso tipo: Decreto**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '27') 

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ingreso numero dictamen**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varNumeroDictamen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

/**Ingreso anio**/
String anio= CustomKeywords.'tool.DateGenerator.currentYear'()

CustomKeywords.'tool.sikuli.ingresarInput'(screen, anio)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ingreso fecha hoy**/
String diaHoy= CustomKeywords.'tool.DateGenerator.today'()

CustomKeywords.'tool.robot.type'(diaHoy)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Presiona aceptar**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarIngresoActo.png', 'ComprasEvaluacion')

/**Cerrar modal**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalEtapaCerrada.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)
