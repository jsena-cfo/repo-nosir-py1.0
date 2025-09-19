import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('BAC/Home/dropdown_usuario'))

def opcionCambiarUEEstaPresente = WebUI.verifyElementPresent(findTestObject('BAC/Home/btnCambiar Unidad Ejecutora'), 3, FailureHandling.OPTIONAL)

if (opcionCambiarUEEstaPresente) {
    def UEActual = WebUI.getText(findTestObject('BAC/Home/spanUnidadEjecutora'))

    if (UEActual != nombreUE) {
        WebUI.click(findTestObject('BAC/Home/btnCambiar Unidad Ejecutora'))

        WebUI.selectOptionByLabel(findTestObject('BAC/Home/select_UnidadEjecutora'), nombreUE, false)

        WebUI.click(findTestObject('BAC/Home/btn_Cambiar'))
    } else {
        KeywordUtil.logInfo('UE deseada ya se encuentra seleccionada')

        WebUI.click(findTestObject('BAC/Home/dropdown_usuario'))
    }
} else {
    KeywordUtil.logInfo('Usuario actual no puede cambiar de UE')
}

