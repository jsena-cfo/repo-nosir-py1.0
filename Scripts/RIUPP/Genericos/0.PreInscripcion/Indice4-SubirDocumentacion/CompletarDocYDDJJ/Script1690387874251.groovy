import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

switch (tipoProveedor) {
    case 'SociedadAnonima':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Estatuto Social o Contrato Constitutivo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'SociedadHecho':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad de los integrantes de la Sociedad de Hecho'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Cooperativas':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Estatuto Social o Contrato Constitutivo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'UnionTransitoria':

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Contrato constitutivo de la UTE'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Instrumento donde conste la designación de representante/s legal/es'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TalleresProtegidos':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Constancia de inscripción en el Registro de Instituciones de Capacitación y Empleo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Estatuto Social o Contrato Constitutivo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'SociedadResponsabilidadLtda':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Estatuto Social o Contrato Constitutivo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'OtrasFormasSocietarias':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Estatuto Social o Contrato Constitutivo'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'JuridicoExtranjero':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Certificado de firmas'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de la conformación de la empresa'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Última Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Acta de designación de autoridades'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        break
    case 'JuridicoExtranjeroSimplificado':
        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Certificado de firmas'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Certificado de residencia fiscal Apostillado'
                , ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)
    default:
        break
}

if ((tipoProveedor == 'JuridicoExtranjero') || (tipoProveedor == 'JuridicoExtranjeroSimplificado')) {
    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptacionUsoSistema'))

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkDDJJDatosReales'))

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkDeclaracionCorreo'))

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/a_Siguiente'))
}
else if(tipoProveedor == 'PersonaHumana'){
	WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de Identidad del Apoderado o Representante Legal'
		, ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Documento de identidad del Titular'
		, ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('RIUPP/Genericos/0.PreInscripcion/Indice4-SubirDocumentacion/SubirDocumentacion'), [('tipoDoc') : 'Poder con facultad para intervenir en todo el proceso de Licitaciones y Contrataciones'
		, ('nombreArchivo') : 'test.pdf'], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptoDDJJ'))
	
	WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbPymeNo'))
	
	WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbDiscapacidadNo'))
	
	WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/a_Siguiente'))
	
} else {
    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/chkAceptoDDJJ'))

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbDiscapacidadNo'))

    WebUI.verifyElementNotVisible(findTestObject('RIUPP/Page_BAC - Indice 4/inpFileOtraInfo'), FailureHandling.STOP_ON_FAILURE)
	
	KeywordUtil.logInfo('Se valida que la carga de archivo de otra info no esta disponible al seleccionar OTRA INFO NO')

    def pathArchivo = System.getProperty('user.dir') + '\\test.pdf'

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbPymeSI'))

    WebUI.selectOptionByLabel(findTestObject('RIUPP/Page_BAC - Indice 4/selectTipoPyme'), 'Mediana', false)

    WebUI.uploadFile(findTestObject('RIUPP/Page_BAC - Indice 4/inpFilePyme'), pathArchivo)

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/btnSubirPyme'))

    WebUI.check(findTestObject('RIUPP/Page_BAC - Indice 4/rbDiscapacidadSi'))

    WebUI.uploadFile(findTestObject('RIUPP/Page_BAC - Indice 4/inpFileOtraInfo'), pathArchivo)

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/btnSubirOtraInfo'))

    WebUI.click(findTestObject('RIUPP/Page_BAC - Indice 4/a_Siguiente'))
}

