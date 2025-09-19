import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnAutorizarAutCom.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAutorizarAutCom.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizarAutCom.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAutorizadaParcialmente2.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)


