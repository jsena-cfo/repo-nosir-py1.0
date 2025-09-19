import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String numeroContratacion = getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnEjecutarConsulta.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, numeroContratacion //ingres el numero de contratacion
    )

CustomKeywords.'tool.sikuli.keyF8'(screen //ejecuta consulta con F8
    )

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarTilde.png', 'ComprasPliegos')

