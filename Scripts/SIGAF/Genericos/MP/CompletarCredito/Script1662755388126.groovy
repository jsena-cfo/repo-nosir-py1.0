import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import org.sikuli.script.*
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import internal.GlobalVariable as GlobalVariable

Screen screen = new Screen()

screen.wait(new Pattern(pathImagen('inpActInt.png')).similar(0.90).targetOffset(2, 10), 30)

screen.type(new Pattern(pathImagen('inpActInt.png')).similar(0.90).targetOffset(2, 10), '609')

screen.click(new Pattern(pathImagen('inpInciso.png')).similar(0.89).targetOffset(1, 12))

screen.type('2' + Key.F9)

screen.wait(pathImagen('btnOk.png'))

screen.click(pathImagen('btnOk.png'))

screen.type(new Pattern(pathImagen('inpImporte.png')).targetOffset(-4, 11), '100')

screen.click(pathImagen('btnGuardar.png'))

screen.click(pathImagen('btnSi.png'))

screen.click(pathImagen('btnAceptar.png'))


def pathImagen(String nombreimagen) {
    def path = System.getProperty('user.dir') + '\\Image Repository\\MPCompletarCredito\\'

    nombreimagen = (path + nombreimagen)

    KeywordUtil.logInfo('ruta imagen: ' + nombreimagen)

    return nombreimagen
}

