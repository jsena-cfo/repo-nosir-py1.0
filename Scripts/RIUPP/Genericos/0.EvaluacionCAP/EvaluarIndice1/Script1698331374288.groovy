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

switch (tipoProveedor) {
    case 'Persona jurídica extranjera sin sucursal':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionLegalAprobado'))

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtRazonSocial'), 
            0)

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtCorreoElectronico'), 
            0)

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/select_RegistroDeContribuyentesOtro'), 
            0)

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtIdentificadorTributario'), 
            0)

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtSitioWeb'), 
            0)

        WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/select_SeleccionarPais'), 
            0)

        break
    case 'Persona humana':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosPHAprobado'))
		
		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtNumeroCUIT'),
			0)

		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtSitioWeb'),
			0)
		
		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtCorreoElectronico'),
			0)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbIngresoBrutoAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionLegalAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionCABAAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbInteradministrativasAprobado'))

        break
    default:
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDatosBasicosAprobado'))
		
		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtRazonSocial'),
			0)

		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtNumeroCUIT'),
			0)

		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtCorreoElectronico'),
			0)

		WebUI.verifyElementPresent(findTestObject('RIUPP/Evaluacion CAP/0.EvaluacionCapValidaciones/input_DatosBasicosProveedortxtSitioWeb'),
			0)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbIngresoBrutoAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbConstitucionAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbOrgPublicoInscriptoAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionLegalAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbDireccionCABAAprobado'))

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbInteradministrativasAprobado'))

        if (tipoProveedor == 'Otra forma societaria') {
            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice1/rbEsUniversidadAprobado'))
        }
        
        break
}

WebUI.click(findTestObject('RIUPP/Evaluacion CAP/Indice1/btnSiguiente'))

