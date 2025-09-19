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

WebUI.callTestCase(findTestCase('RIUPP/Genericos/GenerarNroGEDO'), [:], FailureHandling.OPTIONAL)

def fechaVencimiento = CustomKeywords.'tool.DateGenerator.addWorkingDays'(GlobalVariable.fechaActual, 20)

if ((tipoProveedor != 'Persona jurídica extranjera sin sucursal') && (tipoProveedor != 'Persona humana')) {
    WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbTamanoEmpresaAprobado'))

    WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputTamanoEmpresaFecha'), fechaVencimiento)

    WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbOtraInformacionAprobado'))

    WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputOtraInformacionFecha'), fechaVencimiento)
}

switch (tipoProveedor) {
    case 'Persona humana':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de identidad del Titular']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de identidad del Titular']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)
		
		WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        break
    case 'Sociedad anónima':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Acta de designación de autoridades']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Acta de designación de autoridades']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Sociedad de hecho':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad de los integrantes de la Sociedad de Hecho']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad de los integrantes de la Sociedad de Hecho']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Cooperativa':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Acta de designación de autoridades']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Acta de designación de autoridades']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Unión transitoria de empresas':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Contrato constitutivo de la UTE']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Contrato constitutivo de la UTE']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Instrumento donde conste la designación de representante/s legal/es']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Instrumento donde conste la designación de representante/s legal/es']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Taller protegido':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Acta de designación de autoridades']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Acta de designación de autoridades']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Constancia de inscripción en el Registro de Instituciones de Capacitación y Empleo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Constancia de inscripción en el Registro de Instituciones de Capacitación y Empleo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Sociedad responsabilidad limitada':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Acta de designación de autoridades']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Acta de designación de autoridades']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Otra forma societaria':
        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Acta de designación de autoridades']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Acta de designación de autoridades']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de Identidad del Apoderado o Representante Legal']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']))

        WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Estatuto Social o Contrato Constitutivo']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones']), 
            fechaVencimiento)

        WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

        not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)

        break
    case 'Persona jurídica extranjera sin sucursal':
        def esSimplificado = WebUI.getText(findTestObject('RIUPP/Evaluacion CAP/txtEsRegistroSimplificado'))

        if (esSimplificado == 'NO') {
            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Certificado de firmas']))

            WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Certificado de firmas']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Documento de la conformación de la empresa']))

            WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Documento de la conformación de la empresa']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Última Acta de designación de autoridades']))

            WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Última Acta de designación de autoridades']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Certificado de homologación de la empresa o producto']))

            not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Certificado de homologación de la empresa o producto']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

            not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)
        } else {
            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Certificado de firmas']))

            WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Certificado de firmas']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Certificado de residencia fiscal Apostillado']))

            WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Certificado de residencia fiscal Apostillado']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Certificado de homologación de la empresa o producto']))

            not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/inputfechaParametrizado', [('doc') : 'Certificado de homologación de la empresa o producto']), 
                fechaVencimiento)

            WebUI.check(findTestObject('RIUPP/Evaluacion CAP/Indice3/rbAprobadoParametrizado', [('doc') : 'Otros']))

            not_run: WebUI.setText(findTestObject('RIUPP/Evaluacion CAP/Indice3/Indice3/inputFechaOtrosDocs'), fechaVencimiento)
        }
        
        break
    default:
        break
}