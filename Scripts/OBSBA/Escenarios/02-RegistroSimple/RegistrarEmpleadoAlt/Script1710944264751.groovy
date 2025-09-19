import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/**Author: JER**/
/**Version mejorada de RegistrarEmpelado**/
/**Registra y activa un usuario con rol Empleado**/
/**Toma la informacion de carga del xls usuariosEmpleados.xlsx**/
//String path = '\\Xls\\obsba\\usersSigafXls\\' + fileXlsUsuarios
//def pathExcel = System.getProperty('user.dir') + path
//System.out.println("Path home: " + System.getProperty('user.dir').toString())
//def pathRelativoAux = pathExcel.replace('\\', '\\\\')
//System.out.println("Path relativo: " + pathRelativoAux)
///**Ej: C:/Devs/Projects/Katalon/NOSIR**/
String pathLocation = CustomKeywords.'tool.UploadFile.pathRelativeProject'()

def pathRelativo = (pathLocation + '/Xls/obsba/usersSigafXls/') + fileXlsUsuarios

System.out.println('Path relativo: ' + pathRelativo)

//String dataFile = 'obsbaEmpleadosAlt'
//String dataFile = 'obsbaEmpleadosAltPre'
String dataFile = dataFileUsuarios

'Registra empleado'
row_control = findTestData(dataFile).getRowNumbers()

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

'busca un usuario en la planilla que no ha sido insertado'
System.out.println('Se busca usuario en la planilla que se pueda usar')

boolean encontroSinUsar = false

int index = 1

def estadoVal

String usuarioVal

boolean usuarioNoEstaRegistrado = false

def mapData

mapData = [('1') : null, ('2') : null]

'se calculan los rangos'
def mapRangos

mapRangos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRangosDni'), [('varRangoCuitIntMin') : rangoMin], FailureHandling.STOP_ON_FAILURE)

'rango de la planilla de usuarios empleados'
def rangoMinCuitPlanilla

//rangoMinCuitPlanilla = rangoMin
//rangoMinCuitPlanilla = ((mapRangos['rangoCuitEmpMin']) as int)
String dniEmpMin = (mapRangos['dniEmpMin']).toString()

rangoMinCuitPlanilla = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniEmpMin)

def rangoMaxCuitPlanilla

//rangoMaxCuitPlanilla = rangoMax
//rangoMaxCuitPlanilla = ((mapRangos['rangoCuitEmpMax']) as int)

String dniEmpMax = (mapRangos['dniEmpMax']).toString()

rangoMaxCuitPlanilla = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniEmpMax)


System.out.println('Rango min: ' + rangoMinCuitPlanilla.toString())

System.out.println('Rango max: ' + rangoMaxCuitPlanilla.toString())

'obtiene usuario de la BD porque el empleado no se registra en sigaf, el interno si'
mapData = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/ObtenerUserSiguienteInsertEmpBD'), [
        ('varRangoCuitMin') : rangoMinCuitPlanilla, ('varRangoCuitMax') : rangoMaxCuitPlanilla], FailureHandling.STOP_ON_FAILURE)

'falta validar en que BD se almacenan los empleados'
System.out.println('Map de datos: ' + mapData)

/**
while ((encontroSinUsar == false) && (index <= row_control)) {
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Buscando usuario a insertar en BD'], 
    //    FailureHandling.STOP_ON_FAILURE)

    estadoVal = findTestData(dataFile).getValue('Estado', index)

    usuarioVal = findTestData(dataFile).getValue('UserSigaf', index).toString()

    //System.out.println('Usuario validado en BD: ' + usuarioVal)

    //usuarioNoEstaRegistrado = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/ValidarUsuarioPortalNoInsertadoBD'), 
    //    [('varUsuarioValidar') : usuarioVal.toString()], FailureHandling.STOP_ON_FAILURE)

    if ((estadoVal.toString() == '') && ((mapData['1']) == usuarioVal)) {
	//if ((estadoVal.toString() == '') ) {
        System.out.println('No esta registrado usuario: ' + usuarioVal)

        encontroSinUsar = true
    }
    
    index = (index + 1)
}

'encontro un usuario para usar'
//if ((encontroSinUsar == true) && (usuarioNoEstaRegistrado == true)) {
if ((encontroSinUsar == true) && ((mapData['1']) == usuarioVal)) {
//if ((encontroSinUsar == true)) {
    System.out.println('Encontro un usuario para usar')

    //for (int i = 1; i <= row_control; i++) {
    for (int i = index - 1; i <= row_control; i++) {
        def estado = findTestData(dataFile).getValue('Estado', i)

        if (estado == '') {
            String cuitDisponible = findTestData(dataFile).getValue('CUIT', i)

            String userSigaf = findTestData(dataFile).getValue('UserSigaf', i)

            KeywordUtil.logInfo('Proximo cuit disponible en excel es: ' + cuitDisponible)

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('varEmail') : email, ('varPassword') : password
                    , ('varCuit') : cuitDisponible, ('varUser') : userSigaf, ('varTelefono') : telefono, ('varDireccion') : direccion
                    , ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

            def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
                false, FailureHandling.OPTIONAL)

            if (registroSatisfactorio == true) {
                //String cuilSinBlancos = cuitDisponible.replaceAll('\\s', '')
                //String cuilSinGuiones = cuilSinBlancos.replaceAll('-', '')
                String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuitDisponible)

                String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], 
                    FailureHandling.STOP_ON_FAILURE)

                WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuilSinGuiones, ('varToken') : token], 
                    FailureHandling.STOP_ON_FAILURE)

                //CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 2, i, 'Registrado')
                'columna Estado'
                CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 3, i, 'Registrado')

                'columna FechaUsado'
                CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 4, i, hoy)

                String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

                String reg = '  ->Registro Perfil Empleado en entorno ' + url

                WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
                        , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

                return cuitDisponible.toString()
                
                break
            } else {
                WebUI.takeScreenshot()

                'columna Estado'
                CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 3, i, 'Usuario registrado previamente o invalido')

                'columna FechaUsado'
                CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 4, i, hoy)
            }
        } else {
            KeywordUtil.logInfo('Estado del usuario: ' + estado)
        }
    }
} else {
    if (index > row_control) {
        System.out.println('Planilla completa. No quedan usuario por usar')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Planilla completa. No se encontro usuario!'], 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirMarkFailed'), [('varTexto') : 'Planilla completa. No se encontro usuario!'], 
            FailureHandling.STOP_ON_FAILURE)
    } else {
        //if(usuarioNoEstaRegistrado == false) {
		if((mapData['1']) != usuarioVal) {
		//if(userSigaf != usuarioVal) {
            String mensajeBD = 'Todos los usuarios de la BD estan registrados!'

            System.out.println(mensajeBD)

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : mensajeBD], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirMarkFailed'), [('varTexto') : mensajeBD], FailureHandling.STOP_ON_FAILURE)
        }
    }
}
**/
String usuario

String dni

String cuit

if (((mapData['1']) != null) && ((mapData['2']) != null)) {
    usuario = (mapData['1']).toString()

    dni = (mapData['2']).toString()

    cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dni)

    String txtIntento = (((('Se intenta registrar usuario: ' + usuario) + ' dni: ') + dni) + ' cuit: ') + cuit

    System.out.println('Usuario: ' + usuario)

    System.out.println('Dni: ' + dni)

    System.out.println('Cuit: ' + cuit)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtIntento], FailureHandling.STOP_ON_FAILURE)

    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : usuario, ('varCuil') : cuit
    //	, ('varPassword') : password, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)
    String emailMayus = CustomKeywords.'tool.StringCK.pasarAMayuscula'(emailHotmail)

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosEmpleadoAlt'), [('varEmail') : emailMayus, ('varPassword') : password
            , ('varCuit') : cuit, ('varUser') : usuario, ('varTelefono') : telefono, ('varDireccion') : direccion, ('varUrl') : url], 
        FailureHandling.STOP_ON_FAILURE)

    def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
        false, FailureHandling.OPTIONAL)

    if (registroSatisfactorio == true) {
		boolean activado= false
		
        String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

        token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

        activado= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

        String txtRegistrado = (((('Se registro y activo usuario: ' + usuario) + ' dni: ') + dni) + ' cuit: ') + cuit

        String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

        String reg = '  ->Registro Perfil Empleado en entorno ' + url

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Empleado Registrado: '], 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
                , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

        //if (paramRetorno.equals(1)) {
        //retorna el cuit
        //return cuit.toString() //retorna el cuit y el usuario
        //} else if (paramRetorno.equals(2)) {
        //def mapDatos = [('cuil') : cuitDisponible, ('usuario') : UserSigaf]
        //return mapDatos
        //break
        //KeywordUtil.logInfo('Estado del usuario: ' + estado)
		String cuitReturn= cuit.toString()
		if(activado== false) {
			cuilReturn= 'error'
		}
		return cuitReturn
    } else {
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'El usuario no fue registrado'], 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.takeScreenshot()
    }
} else {
    String log = 'No se encontro usuario a registrar. Puede que los usuarios dentro del rango ya hayan sido utilizados'

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : log], FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot()

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirMarkFailed'), [('varTexto') : log], FailureHandling.STOP_ON_FAILURE)
}

