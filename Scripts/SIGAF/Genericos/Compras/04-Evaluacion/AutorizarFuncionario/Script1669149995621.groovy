import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizarFuncionario.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizarFuncionario.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizarFuncionario.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalFuncionarioAutorizado.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)


