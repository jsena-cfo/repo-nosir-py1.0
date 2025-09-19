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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Iniciar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/LoginAltRol'), [('varUsuario') : varUsuario, ('varPassword') : varPassword
        , ('varRol') : 'ejecucion'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/DesplazarseMenu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RellenarYGuardarSolicitud'), [('varUnidadEjecutora') : findTestData(
            'comprasSolicitudGastoTD').getValue('colUnidadEjecutora', 1), ('varDelegacion') : findTestData('comprasSolicitudGastoTD').getValue(
            2, 1), ('varOficinaCompras') : findTestData('comprasSolicitudGastoTD').getValue(3, 1), ('varUnidadSolicitante') : findTestData(
            'comprasSolicitudGastoTD').getValue(4, 1), ('varObjSolicitud') : findTestData('comprasSolicitudGastoTD').getValue(
            5, 1), ('varRubro') : findTestData('comprasSolicitudGastoTD').getValue(6, 1), ('varActuadoDelegacion') : findTestData(
            'comprasSolicitudGastoTD').getValue(7, 1), ('varActuadoTipo') : findTestData('comprasSolicitudGastoTD').getValue(
            8, 1), ('varActuadoNumero') : findTestData('comprasSolicitudGastoTD').getValue(9, 1), ('varSadeTipo') : findTestData(
            'comprasSolicitudGastoTD').getValue(10, 1), ('varSadeNumero') : findTestData('comprasSolicitudGastoTD').getValue(
            11, 1), ('varRepActuado') : findTestData('comprasSolicitudGastoTD').getValue(12, 1), ('varRepUsuario') : findTestData(
            'comprasSolicitudGastoTD').getValue(13, 1), ('varProcSeleccion') : findTestData('comprasSolicitudGastoTD').getValue(
            14, 1), ('varClase') : findTestData('comprasSolicitudGastoTD').getValue(15, 1), ('varModalidad') : findTestData(
            'comprasSolicitudGastoTD').getValue('colModalidad', 1)], FailureHandling.STOP_ON_FAILURE)

String numero = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerNumeroOCR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '161', ('varY') : '158', ('varW') : '63', ('varH') : '14'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

String resultado1 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

String estadoObtenido1 = resultado1.toString().trim()

System.out.println('Estado1 obtenido: ' + estadoObtenido1)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ValidarEstadoModificado'), [('varEstadoObtenido') : estadoObtenido1
        , ('varEstadoIngresado') : 'INGRESO PARCIAL'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '580', ('varY') : '156', ('varW') : '156'
        , ('varH') : '16'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RellenarSolapaItemsYLugarEntrega'), [('varCatalogoN1') : findTestData(
            'comprasSolicitudGastoTD').getValue('colCatalogoN1', 1), ('varCatalogoN2') : findTestData('comprasSolicitudGastoTD').getValue(
            'colCatalogoN2', 1), ('varCatalogoN3') : findTestData('comprasSolicitudGastoTD').getValue('colCatalogoN3', 1)
        , ('varCantidad') : findTestData('comprasSolicitudGastoTD').getValue('colCantidad', 1), ('varPrecioUnitario') : findTestData(
            'comprasSolicitudGastoTD').getValue('colPrecioUnitario', 1)], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RellenarSolapaImputacion'), [('varOgto') : findTestData(
            'comprasSolicitudGastoTD').getValue('colOgto', 1), ('varActint') : findTestData('comprasSolicitudGastoTD').getValue(
            'colActint', 1), ('varFuente') : findTestData('comprasSolicitudGastoTD').getValue('colFuente', 1), ('varMon') : findTestData(
            'comprasSolicitudGastoTD').getValue('colMon', 1), ('varUbicacion') : findTestData('comprasSolicitudGastoTD').getValue(
            'colUbicacion', 1), ('varImporte') : findTestData('comprasSolicitudGastoTD').getValue('colImporte', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RealizarIngresoCompleto'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

String resultado2 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

String estadoObtenido2 = resultado2.toString().trim()

System.out.println('Estado2 obtenido: ' + estadoObtenido2)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ValidarEstadoModificado'), [('varEstadoObtenido') : estadoObtenido2
        , ('varEstadoIngresado') : 'INGRESADO'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '580', ('varY') : '156', ('varW') : '156'
        , ('varH') : '16'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RealizarAutorizacionParcial'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

//not_run: System.out.println('Estado obtenido: ' + estadoObtenido)
//String resultado3 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)
String resultado3 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

String estadoObtenido3 = resultado3.toString().trim()

System.out.println('Estado3 obtenido: ' + estadoObtenido3)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ValidarEstadoModificado'), [('varEstadoObtenido') : estadoObtenido3
        , ('varEstadoIngresado') : 'AUTORIZACION PARCIAL'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '580', ('varY') : '156', ('varW') : '156'
        , ('varH') : '16'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/RealizarAutorizacion'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

//String resultado4 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/02-Parametros/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)
String resultado4 = WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ObtenerEstadoOCR'), [:], FailureHandling.STOP_ON_FAILURE)

String estadoObtenido4 = resultado4.toString().trim()

System.out.println('Estado4 obtenido: ' + estadoObtenido4)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ValidarEstadoModificado'), [('varEstadoObtenido') : estadoObtenido4
        , ('varEstadoIngresado') : 'AUTORIZADO'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Enfocar'), [('varX') : '580', ('varY') : '156', ('varW') : '156'
        , ('varH') : '16'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/ConsultarCredito'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('SIGAF/Genericos/Compras/01-Solicitud/GuardaNumeroSolicitudXls'), [('varNumero') : numero], 
    FailureHandling.STOP_ON_FAILURE)

def mapDatos = [('numeroSolicitud') : numero]

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/GuardarDatosXlsUnico'), [('varPathXls') : 'Xls/datosXls.xlsx', ('varHoja') : 'Hoja1SG'
        , ('varDatos') : mapDatos], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Salir'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Esperar'), [('varTiempo') : '3'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SIGAF/Genericos/Varios/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

return numero

