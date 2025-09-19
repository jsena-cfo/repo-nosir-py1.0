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

/**Registra y activa un usuario con rol Interno**/
/**Toma la informacion de carga del xls usuariosInternos.xlsx**/
/**Ejecutar la suite de RegistroUsr y RegistroMultiple, cargan en los xls interno 
 * y empleado: 7 internos y 5 empleados**/
//String path = '\\Xls\\obsba\\usersSigafXls\\' + fileXlsUsuarios
//def pathExcel = System.getProperty('user.dir') + path
//def pathRelativo2 = pathExcel.replace('\\', '\\\\')
///**Ej: C:/Devs/Projects/Katalon/NOSIR**/
String pathLocation = CustomKeywords.'tool.UploadFile.pathRelativeProject'()

def pathRelativo = (pathLocation + '/Xls/obsba/usersSigafXls/') + fileXlsUsuarios

System.out.println('Path relativo: ' + pathRelativo)

String dataFile = dataFileUsuarios

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

'rango de la planilla de usuarios internos'
def rangoMinCuitPlanilla

//rangoMinCuitPlanilla = rangoMin

String dniIntMin= (mapRangos['dniIntMin']).toString()

rangoMinCuitPlanilla = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniIntMin)

def rangoMaxCuitPlanilla 

//rangoMaxCuitPlanilla = rangoMax

String dniIntMax= (mapRangos['dniIntMax']).toString()

//rangoMaxCuitPlanilla = ((mapRangos['rangoCuitIntMax']) as int)

rangoMaxCuitPlanilla= CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniIntMax)



System.out.println('Rango min: ' + rangoMinCuitPlanilla.toString())

System.out.println('Rango max: ' + rangoMaxCuitPlanilla.toString())

mapData = WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/ObtenerUserSiguienteInsertIntBD'), [
        ('varRangoCuitMin') : rangoMinCuitPlanilla, ('varRangoCuitMax') : rangoMaxCuitPlanilla], FailureHandling.STOP_ON_FAILURE)

System.out.println('Map de datos: ' + mapData)

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

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : usuario, ('varCuil') : cuit
            , ('varPassword') : password, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

    def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
        false, FailureHandling.OPTIONAL)

    if (registroSatisfactorio == true) {
		boolean activado= false
		
        String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

        token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], FailureHandling.STOP_ON_FAILURE)

        activado= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token], FailureHandling.STOP_ON_FAILURE)

        String cantRegDisponibles = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRegistrosDisponibles'), [('varDni') : dni
                , ('varCuitMax') : rangoMaxCuitPlanilla.toString()], FailureHandling.STOP_ON_FAILURE)

        System.out.println('Cantidad Registros disponible: ' + cantRegDisponibles)

        String txtRegistrado = (((('Se registro y activo usuario: ' + usuario) + ' dni: ') + dni) + ' cuit: ') + cuit

        String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

        String reg = '  ->Registro Perfil Interno en entorno ' + url

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Interno Registrado: '], 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'Cantidad Registros disponible: ' + 
                cantRegDisponibles], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
                , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

        //if (paramRetorno.equals(1)) {
        //retorna el cuit
        String cuitReturn= cuit.toString() //retorna el cuit y el usuario
        //} else if (paramRetorno.equals(2)) {
        //def mapDatos = [('cuil') : cuitDisponible, ('usuario') : UserSigaf]
        //return mapDatos
        //break  
		if(activado== false) {
			cuilReturn= 'error'
		}
		return cuitReturn
    } //KeywordUtil.logInfo('Estado del usuario: ' + estado)
    else {
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : 'El usuario no fue registrado'], 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.takeScreenshot()
    }
} else {
    String log = 'No se encontro usuario a registrar. Puede que los usuarios dentro del rango ya hayan sido utilizados'

    WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : log], FailureHandling.STOP_ON_FAILURE)

    WebUI.takeScreenshot()
}

