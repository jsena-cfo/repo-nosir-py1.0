import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnGuardarDictamen.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardarDictamen.png', 'ComprasEvaluacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalConfirmarGuardarDictamen.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacionGuardarDictamen.png', 'ComprasEvaluacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

