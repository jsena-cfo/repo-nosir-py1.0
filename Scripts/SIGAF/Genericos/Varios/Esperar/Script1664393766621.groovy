import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String tiempo= this.getBinding().getAt('varTiempo').toString()

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.delay'(tiempo.toInteger())

