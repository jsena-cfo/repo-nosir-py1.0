import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

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

        def cantSolicitada = WebUI.getText(findTestObject('Object Repository/BAC/Pre Adjudicacion/Recomendar Oferta/txtCantidadSolicitada', 
                [('oferta') : oferta]))

        def mitadCantidad = cantSolicitada.substring(0, cantSolicitada.lastIndexOf(',')).toInteger() / cantOfertas

        WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/inpCantidadAAdquirir', [('oferta') : oferta]), 
            mitadCantidad.toString())
    }
    
    WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnGuardar y Volver'))
}

WebUI.setText(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/textareaJustificacion'), 'test')

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnSiguientePaso'))

WebUI.click(findTestObject('BAC/Pre Adjudicacion/Recomendar Oferta/btnFinalizar'))

WebUI.closeBrowser()

