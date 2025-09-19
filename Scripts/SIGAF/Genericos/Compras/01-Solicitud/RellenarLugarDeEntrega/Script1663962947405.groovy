import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String varLugarEntrega = getBinding().getAt('varLugarEntrega').toString()
String varCantidadEntrega = getBinding().getAt('varCantidadEntrega').toString()
String varObservaciones = getBinding().getAt('varObservaciones').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnLugarEntrega.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnLugarEntrega.png', 'ComprasSolicitudGasto')

/**1**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varLugarEntrega)
CustomKeywords.'tool.sikuli.keyTab'(screen)

String fechaDentroDosSemanas = CustomKeywords.'tool.DateGenerator.dateNWeeksLaterToday'(2)
System.out.println('****Fecha dentro de dos semanas: ' + fechaDentroDosSemanas)

CustomKeywords.'tool.robot.type'(fechaDentroDosSemanas)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.delay'(1)

if (CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalFechaDiaHabil.png', 'ComprasSolicitudGasto', 5)) {
    System.out.println('***Es dia habil')
    CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnFechaDiaHabil.png', 'ComprasSolicitudGasto')
} else {
    System.out.println('***No es dia habil')
}

/**1**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varCantidadEntrega)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**'Texto observacion'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varObservaciones)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLugarEntrega.png', 'ComprasSolicitudGasto')

