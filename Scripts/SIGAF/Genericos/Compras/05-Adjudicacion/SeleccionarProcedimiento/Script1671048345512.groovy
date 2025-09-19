import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String numeroContratacion= this.getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'selectorProcedimientos.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

String anio= CustomKeywords.'tool.DateGenerator.currentYear'()

String filtro= '230%' + numeroContratacion + '%'+ anio +'%'+ 'Decreto N° 433/16'

CustomKeywords.'tool.robot.type'(filtro)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)