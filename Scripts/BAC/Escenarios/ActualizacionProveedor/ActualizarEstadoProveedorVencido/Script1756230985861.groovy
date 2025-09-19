import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def mapData = [('desactualizado') : false, ('nroCuit') : '']

mapData = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ValidarProveedorDesactualizado'), [('varUser') : GlobalVariable.userProveedor
        , ('varPass') : GlobalVariable.passProveedor], FailureHandling.STOP_ON_FAILURE)

if ((mapData['desactualizado']) == true) {
    System.out.println('Estado Desactualizado')

    CustomKeywords.'tool.Logger.print'('Estado Desactualizado')

    WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ActualizarEstadoProveedor'), [('userVar') : GlobalVariable.userProveedor
            , ('passVar') : GlobalVariable.passProveedor], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/EvaluarModificacionProveedorCAP'), [('userVar') : 'fciorcia'
            , ('passVar') : '12345678', ('varCuit') : (mapData['nroCuit']).toString()], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/EvaluarModificacionProveedorRIUPP'), [('userVar') : 'fciorcia'
            , ('passVar') : '12345678', ('varCuit') : (mapData['nroCuit']).toString()], FailureHandling.STOP_ON_FAILURE)

    mapData = WebUI.callTestCase(findTestCase('BAC/Genericos/ActualizacionProveedor/ValidarProveedorDesactualizado'), [('varUser') : GlobalVariable.userProveedor
            , ('varPass') : GlobalVariable.passProveedor], FailureHandling.STOP_ON_FAILURE)
} else {
    System.out.println('Estado Actualizado')

    CustomKeywords.'tool.Logger.print'('Estado Actualizado')
}

assert !(mapData['desactualizado'])

