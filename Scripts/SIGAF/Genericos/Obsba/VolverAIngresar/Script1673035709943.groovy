import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import org.sikuli.script.*
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Screen screen = new Screen()

//CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optNuevoIngreso.png', 'ObsbaCarga', 10)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Obsba/IrAIngreso'), [:], FailureHandling.STOP_ON_FAILURE)

