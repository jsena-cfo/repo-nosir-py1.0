import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('BAC/Genericos/Proceso de Compra/BuscarPC'), [('nroPC') : nroPC, ('user') : GlobalVariable.userEvaluador2
//	, ('pass') : GlobalVariable.passEvaluador, ('accionPC') : 'Evaluar Ofertas'], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnRecomendarOferta'))

List<WebElement> listaRenglones = WebUI.findWebElements(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnIngresarCantidad'), 
    10)

cantRenglones = listaRenglones.size()

for (int renglon = 1; renglon <= cantRenglones; renglon++) {
    WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnIngresarCantidadParametrizado', [('renglon') : renglon.toString()]))

    List<WebElement> listaOfertas = WebUI.findWebElements(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/chkRecomendar'), 
        10)

    cantOfertas = listaOfertas.size()

    for (int oferta = 1; oferta <= cantOfertas; oferta++) {
        WebUI.check(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/chkRecomendarParametrizado', [('oferta') : oferta]))

        def cantOfertada = WebUI.getText(findTestObject('Object Repository/BAC/Pre Adjudicacion/Recomendar Oferta/txtCantidadOfertada', 
                [('oferta') : oferta]))

        WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/inpCantidadAAdquirir', [('oferta') : oferta]), 
            cantOfertada)
    }
    
    WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnGuardar y Volver'))
}

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/textareaJustificacion'), 'test')

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnSiguientePaso'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnFinalizar'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnIrAlescritorioMinuscula'))

