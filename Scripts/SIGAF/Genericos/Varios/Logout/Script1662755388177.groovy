import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImgTarget'(screen, 'btnLogout.png', 'MPLogout', 0, 0, 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnLogout.png', 'MPLogout')
