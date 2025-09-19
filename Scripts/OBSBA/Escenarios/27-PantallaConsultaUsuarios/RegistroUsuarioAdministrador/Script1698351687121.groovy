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

/**Author: Jer**/
/**Script crea un usuario con rol interno Administrador**/
//def pathExcel = System.getProperty('user.dir') + '\\Xls\\obsba\\UsuariosSigaf.xls'
//String path= '\\Xls\\obsba\\usersSigafXls\\UsuariosSigaf.xlsx'
//String path = '\\Xls\\obsba\\usersSigafXls\\usuariosInternos.xlsx'
//String path = '\\Xls\\obsba\\usersSigafXls\\usuariosInternosPre.xlsx'
String path = '\\Xls\\obsba\\usersSigafXls\\' + fileXlsUsuarios

def pathExcel = System.getProperty('user.dir') + path

def pathRelativo = pathExcel.replace('\\', '\\\\')

//String dataFile= 'UsuariosSigaf'
//String dataFile = 'obsbaInternosAlt'
//String dataFile = 'obsbaInternosAltPre'
String dataFile = dataFileUsuarios

row_control = findTestData(dataFile).getRowNumbers()

String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

def mapData

mapData = [('1') : null, ('2') : null]

'se calculan los rangos'
def mapRangos

mapRangos = WebUI.callTestCase(findTestCase('OBSBA/Genericos/CalcularRangosDni'), [('varRangoCuitIntMin') : rangoMin], FailureHandling.STOP_ON_FAILURE)

def rangoMinCuitPlanilla

//rangoMinCuitPlanilla= rangoMin

String dniIntMin= (mapRangos['dniIntMin']).toString()

rangoMinCuitPlanilla = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniIntMin)


def rangoMaxCuitPlanilla 

//rangoMaxCuitPlanilla= rangoMax

String dniIntMax= (mapRangos['dniIntMax']).toString()

rangoMaxCuitPlanilla = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'('Masculino', dniIntMax)




System.out.println("Rango min: " + rangoMinCuitPlanilla.toString())

System.out.println("Rango max: " + rangoMaxCuitPlanilla.toString())

mapData= WebUI.callTestCase(findTestCase('OBSBA/Escenarios/00-ConfiguracionInicial/ObtenerUserSiguienteInsertIntBD'), [('varRangoCuitMin') : rangoMinCuitPlanilla
	, ('varRangoCuitMax') : rangoMaxCuitPlanilla], FailureHandling.STOP_ON_FAILURE)

System.out.println("Map de datos: " + mapData)

/**
for (int i = 1; i <= row_control; i++) {
    def estado = findTestData(dataFile).getValue('Estado', i)

    if (estado == '') {
        String cuitDisponible = findTestData(dataFile).getValue('CUIT', i)

        String UserSigaf = findTestData(dataFile).getValue('UserSigaf', i)

        KeywordUtil.logInfo('Proximo cuit disponible en excel es: ' + cuitDisponible)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : UserSigaf, ('varCuil') : cuitDisponible
                , ('varPassword') : password, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

        def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', 
            false, FailureHandling.OPTIONAL)

        if (registroSatisfactorio == true) {
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

            //String cuilSinBlancos = cuitDisponible.replaceAll('\\s', '')
            //String cuilSinGuiones = cuilSinBlancos.replaceAll('-', '')
            String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.todayAndTime'()

            String reg = '  ->Registro Perfil Interno Administrador en entorno ' + url

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
                    , ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('OBSBA/Escenarios/27-PantallaConsultaUsuarios/DarRolAdministradorBD'), [('varUsuario') : UserSigaf], 
                FailureHandling.STOP_ON_FAILURE)

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
**/

String usuario

String dni

String cuit

if (((mapData['1']) != (null)) && ((mapData['2']) != (null))) {
	usuario = mapData['1'].toString()

	dni = mapData['2'].toString()

	cuit = CustomKeywords.'adicionales.CuilRandomGenerator.get_cuil'("Masculino", dni)
	
	String txtIntento= "Se intenta registrar usuario: " + usuario + " dni: " + dni + " cuit: " + cuit
	
	System.out.println("Usuario: " + usuario)
	
	System.out.println("Dni: " + dni)
	
	System.out.println("Cuit: " + cuit)
	
	WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtIntento], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('OBSBA/Genericos/CompletarDatosInterno'), [('varUser') : usuario, ('varCuil') : cuit
		, ('varPassword') : password, ('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

   def registroSatisfactorio = WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro',
	 false, FailureHandling.OPTIONAL)

   if (registroSatisfactorio == true) {
	  boolean activado= false
	   
	  String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuit)

	  token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones],
		FailureHandling.STOP_ON_FAILURE)

	  activado= WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuit, ('varToken') : token],
		FailureHandling.STOP_ON_FAILURE)
	  
	  String txtRegistrado=  "Se registro y activo usuario: " + usuario + " dni: " + dni + " cuit: " + cuit

	  String fecha = '  ->Fecha: ' + CustomKeywords.'tool.DateGenerator.today'()

	  String reg = '  ->Registro Perfil Interno Administrador en entorno ' + url
	  
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : '***Usuario Interno Registrado: '], FailureHandling.STOP_ON_FAILURE)
		   
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : txtRegistrado], FailureHandling.STOP_ON_FAILURE)
	  
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : fecha], FailureHandling.STOP_ON_FAILURE)
	  
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : reg], FailureHandling.STOP_ON_FAILURE)
	  
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxtSalida'), [('varCuil') : cuilSinGuiones, ('varFecha') : fecha
			, ('varRegistro') : reg], FailureHandling.STOP_ON_FAILURE)
			
	  WebUI.callTestCase(findTestCase('OBSBA/Escenarios/27-PantallaConsultaUsuarios/DarRolAdministradorBD'), [('varUsuario') : usuario],
				FailureHandling.STOP_ON_FAILURE)

	  //return cuit.toString()
	  String cuitReturn= cuit.toString()
	  if(activado== false) {
		  cuilReturn= 'error'
	  }
	  return cuitReturn
   }
   else {
	  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : "El usuario no fue registrado"], FailureHandling.STOP_ON_FAILURE)
	  WebUI.takeScreenshot()
   }
}
else {
  //KeywordUtil.logInfo('Estado del usuario: ' + estado)
  String log= "No se encontro usuario a registrar. Puede que los usuarios dentro del rango ya hayan sido utilizados"
  WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirALog'), [('varTexto') : log], FailureHandling.STOP_ON_FAILURE)
  WebUI.takeScreenshot()
  }



