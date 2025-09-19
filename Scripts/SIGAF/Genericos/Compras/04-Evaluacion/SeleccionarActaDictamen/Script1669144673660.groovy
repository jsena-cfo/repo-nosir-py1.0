import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


String varNumeroContratacion = this.getBinding().getAt('varNumeroContratacion').toString()

String varNumeroActa = this.getBinding().getAt('varNumeroActa').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

String decreto= "Decreto N° 433/16"

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'()

//%2022%Decreto N° 433/16%numeroContratacion%2022%numeroActa%1

String filtro= "%" + anioActual + "%" + decreto + "%" + varNumeroContratacion + "%" + anioActual + "%" + varNumeroActa + "%" + "1"

//CustomKeywords.'tool.sikuli.ingresarInput'(screen, filtro)

CustomKeywords.'tool.robot.type'(filtro)

CustomKeywords.'tool.sikuli.keyEnter'(screen)
CustomKeywords.'tool.sikuli.delay'(2)
CustomKeywords.'tool.sikuli.keyEnter'(screen)


