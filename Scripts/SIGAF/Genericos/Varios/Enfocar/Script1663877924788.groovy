import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

int varX = this.getBinding().getAt('varX').toString().toInteger()
int varY = this.getBinding().getAt('varY').toString().toInteger()
int varW = this.getBinding().getAt('varW').toString().toInteger()
int varH = this.getBinding().getAt('varH').toString().toInteger()

Screen screen = new Screen()
CustomKeywords.'tool.sikuli.enfocar'(screen, varX, varY, varW, varH)