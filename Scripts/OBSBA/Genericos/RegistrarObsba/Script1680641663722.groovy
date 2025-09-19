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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/**Author: JER**/
String cuil = getBinding().getAt('varCuil').toString()

String usuario = getBinding().getAt('varUsuario').toString()

String password = getBinding().getAt('varPassword').toString()

String perfil = getBinding().getAt('varPerfil').toString()

String email = getBinding().getAt('varEmail').toString()

String telefono = getBinding().getAt('varTelefono').toString()

String domicilio = getBinding().getAt('varDomicilio').toString()

String url = getBinding().getAt('varUrl').toString()

String cuilSinGuiones = cuil.replaceAll('-', '')

WebUI.callTestCase(findTestCase('OBSBA/Genericos/AbrirURL'), [('varUrl') : url], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_Registrar/h1_labelNoTenesCuenta'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickRegistrate'), [:], FailureHandling.STOP_ON_FAILURE)

if (perfil == 'Prestador') {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/RellenarDatosAfiliadoPrestador'), [('varUsuario') : usuario, ('varCuil') : cuilSinGuiones
            , ('varPassword') : password, ('varDomicilio') : domicilio, ('varTelefono') : telefono, ('varEmail') : email
            , ('varTipoPerfil') : 'prestador'], FailureHandling.STOP_ON_FAILURE)
} else if (perfil == 'Afiliado') {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/RellenarDatosAfiliadoPrestador'), [('varUsuario') : usuario, ('varCuil') : cuilSinGuiones
            , ('varPassword') : password, ('varDomicilio') : domicilio, ('varTelefono') : telefono, ('varEmail') : email
            , ('varTipoPerfil') : 'afiliado'], FailureHandling.STOP_ON_FAILURE)
} else if (perfil == 'Interno') {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/RellenarDatosInterno'), [('varUsuario') : usuario, ('varCuil') : cuilSinGuiones
            , ('varPassword') : password], FailureHandling.STOP_ON_FAILURE)
} else if (perfil == 'Empleado') {
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/SeleccionarTipoPerfil'), [('varTipoPerfil') : 'empleado'], FailureHandling.STOP_ON_FAILURE)
}

System.out.println('Numero cuil: ' + cuil)

boolean presente = false

boolean validacion = false

/**valida que no aparezca el mensaje de error al registrar 2 veces el mismo
 prestador con diferente mail **/
presente = WebUI.verifyElementPresent(findTestObject('Object Repository/ObsbaPortal/Page_ObSBA_MensajesRegistrar/h2_ErrorTitulo'), 
    1, FailureHandling.OPTIONAL)

System.out.println('Error presente: ' + presente.toString())

'No se muestra la ventana de error'

'registro con un cuil valido una vez'
if (presente == false) {
    System.out.println('Paso')

    WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ReviseBandeja'), 1)

    String mensaje = 'Revise su bandeja de correo electrónico para confirmar el registro'

    boolean encontro = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ReviseBandeja'), 
        mensaje)

    if (encontro == false) {
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error en registrar cuit'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.callTestCase(findTestCase('OBSBA/Genericos/ClickVolverRegistro'), [:], FailureHandling.STOP_ON_FAILURE)

    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    validacion = encontro //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert false
    // WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
    //WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)
    //assert true
} else {
    'Aparecio cartel de error'
    System.out.println('Ocurrio error')

    WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/div_ErrorUsuario'), 1)

    WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h2_ErrorTitulo'), 'Error')

    cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuil)

    WebUI.waitForElementPresent(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ErrorUsuarioMensaje'), 1)

    String textoModal = WebUI.getText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ErrorUsuarioMensaje'))

    System.out.println('Valor textoModal: ' + textoModal)

    String textoModalComparado = ('Usuario ' + cuilSinGuiones) + ' con perfil Prestador no puede tener otro perfil asignado'

    System.out.println('Valor textoModalComparado: ' + textoModalComparado)

/**
    if (textoModal == textoModalComparado) {
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error doble carga o carga otro perfil'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        System.out.println('Error al cargar Prestador con otro perfil')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    } else if (textoModal == 'La contraseña y el correo ingresado debe coincidir con la de su anterior perfil') {
        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : ('  ->Prueba Cargar mismo usuario ' + 
                perfil.toString()) + ' con otro mail', ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        System.out.println('Mensaje Se cargo mismo usuario con otro mail')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    } else if (textoModal == 'CUIT/CUIL inválido') {
        System.out.println('CUIT/CUIL inválido')

        cuilSinGuiones = cuil.replaceAll('-', '')

        WebUI.takeScreenshot(('Evidences/Obsba/screenshot' + cuilSinGuiones) + '.jpg')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->ERROR: Error ingreso cuil invalido!'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        KeywordUtil.markFailedAndStop('Error inesperado!')

        validacion = false
    } else if (textoModal == 'Usuario con perfil Interno ya tiene tres perfiles asignados') {
        System.out.println('Error usuario perfil interno con tres perfiles')
    } else if (textoModal == ('Error al insertar datos del usuario ' + cuilSinGuiones)) {
        System.out.println('Error al insertar datos del usuario ' + cuilSinGuiones)

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Cargar Interno ya cargado'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    } else if (textoModal == (('El usuario ' + cuilSinGuiones) + ' con perfil prestador no puede tener otro perfil asignado')) {
        System.out.println(('El usuario ' + cuilSinGuiones) + ' con perfil prestador no puede tener otro perfil asignado')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Afiliado Prestador Misma Pass'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    } else if (textoModal == (('El usuario ' + cuilSinGuiones) + ' no puede ser Prestador ya que cuenta con otros perfiles')) {
        System.out.println(('El usuario ' + cuilSinGuiones) + ' no puede ser Prestador ya que cuenta con otros perfiles')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Perfil no puede ser Prestador'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    } else if (textoModal == (('La contraseña ' + cuilSinGuiones) + ' no coincide con la contraseña de los perfiles activados')) {
        System.out.println(('La contraseña ' + cuilSinGuiones) + ' no coincide con la contraseña de los perfiles activados')

        WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Perfil Empleado Interno diferente pass'
                , ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

        validacion = true
    }else if (textoModal == 'El usuario ' + cuilSinGuiones + ' ya tiene perfil Afiliado') {
	    System.out.println(textoModal)
		
		WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Usuario Afiliado Dos Veces Email'
			, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

		validacion = true
	}else if (textoModal == 'El usuario ' + cuilSinGuiones + ' ya tiene perfil Interno') {
		System.out.println(textoModal)
		
		WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Usuario Interno Dos Veces Email'
			, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

		validacion = true
    }else if(textoModal == 'La contraseña y el correo del usuario ' + cuilSinGuiones + ' no coinciden con los datos ingresados') {
		System.out.println(textoModal)
		WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar La contraseña y el correo del usuario no coinciden con los datos ingresados'
			, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

		validacion = true
	}
**/
	
	switch(textoModal) {
		case textoModalComparado:
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error doble carga o carga otro perfil'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			System.out.println('Error al cargar Prestador con otro perfil')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			
			break
	
		case 'La contraseña y el correo ingresado debe coincidir con la de su anterior perfil':
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : ('  ->Prueba Cargar mismo usuario ' +
					perfil.toString()) + ' con otro mail', ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			System.out.println('Mensaje Se cargo mismo usuario con otro mail')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			
			break
			
		case 'CUIT/CUIL inválido':
			System.out.println('CUIT/CUIL inválido')
	
			cuilSinGuiones = cuil.replaceAll('-', '')
	
			WebUI.takeScreenshot(('Evidences/Obsba/screenshot' + cuilSinGuiones) + '.jpg')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->ERROR: Error ingreso cuil invalido!'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			KeywordUtil.markFailedAndStop('Error inesperado!')
	
			validacion = false
			
			break
			
		case 'Usuario con perfil Interno ya tiene tres perfiles asignados':
			System.out.println('Error usuario perfil interno con tres perfiles')
		
		case 'Error al insertar datos del usuario ' + cuilSinGuiones:
			System.out.println('Error al insertar datos del usuario ' + cuilSinGuiones)
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Cargar Interno ya cargado'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			
			break
		case 'El usuario ' + cuilSinGuiones + ' con perfil prestador no puede tener otro perfil asignado':
			System.out.println(('El usuario ' + cuilSinGuiones) + ' con perfil prestador no puede tener otro perfil asignado')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Afiliado Prestador Misma Pass'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			break
		case 'El usuario ' + cuilSinGuiones + ' no puede ser Prestador ya que cuenta con otros perfiles':
			System.out.println(('El usuario ' + cuilSinGuiones) + ' no puede ser Prestador ya que cuenta con otros perfiles')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Perfil no puede ser Prestador'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			break
		case 'La contraseña ' + cuilSinGuiones + ' no coincide con la contraseña de los perfiles activados':
			System.out.println(('La contraseña ' + cuilSinGuiones) + ' no coincide con la contraseña de los perfiles activados')
	
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Perfil Empleado Interno diferente pass'
					, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			break
		case 'El usuario ' + cuilSinGuiones + ' ya tiene perfil Afiliado':
			System.out.println(textoModal)
			
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Usuario Afiliado Dos Veces Email'
				, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			break
		case 'El usuario ' + cuilSinGuiones + ' ya tiene perfil Interno':
			System.out.println(textoModal)
			
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Usuario Interno Dos Veces Email'
				, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			
			break
		case 'La contraseña y el correo del usuario ' + cuilSinGuiones + ' no coinciden con los datos ingresados':
			System.out.println(textoModal)
			WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar La contraseña y el correo del usuario no coinciden con los datos ingresados'
				, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)
	
			validacion = true
			break
	    case 'Posee otro perfil activo con una dirección de correo diferente, por favor, contacte al equipo de Soporte del Portal':
		   WebUI.callTestCase(findTestCase('OBSBA/Genericos/EscribirATxt'), [('varText') : '  ->Prueba Error Registrar Empleado Interno con diferente pass'
			, ('varTextPath') : 'Txt/cuilUsed.txt'], FailureHandling.STOP_ON_FAILURE)

		   validacion = true
		   break
	}
	
}
WebUI.callTestCase(findTestCase('OBSBA/Genericos/CerrarNavegador'), [:], FailureHandling.STOP_ON_FAILURE)

assert validacion

