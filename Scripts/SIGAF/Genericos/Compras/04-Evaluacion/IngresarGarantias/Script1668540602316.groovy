import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

/**Ingresar a garantias**/

CustomKeywords.'tool.sikuli.keyEnter'(screen)
CustomKeywords.'tool.sikuli.keyEnter'(screen) /**Ingresar garantias**/

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '20.00') /**monto garantia**/

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
