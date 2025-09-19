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


String msj= this.getBinding().getAt('varTexto').toString()

boolean validar= false

switch(msj) {
	//validar mensaje login logout, pantalla login
	case 'CUIT/CUIL Inválido':
	validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/p_CuitCuil Invlido'), 
    'CUIT/CUIL Inválido', FailureHandling.OPTIONAL)
    break
	
	case 'CUIT/CUIL inválido':
     validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/p_CuitCuil Invlido'), 
    'CUIT/CUIL inválido', FailureHandling.OPTIONAL)
     break
	 
	 case 'La contraseña debe ser alfanumérica y tener al menos 8 dígitos y una mayúscula':
     validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_ValidadorContrasea/p_mensajeContraseaErrorSesion'), 
    'La contraseña debe ser alfanumérica y tener al menos 8 dígitos y una mayúscula', FailureHandling.OPTIONAL)
     break

	//'Validar mensaje modal Cerrar sesion timeout'
	case 'Ha excedido el tiempo de inactividad en la plataforma.':
	  validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajeInformacion/h2_msjTiempoExcedido'),
	'Ha excedido el tiempo de inactividad en la plataforma.', FailureHandling.OPTIONAL)
	  break
	  
    case 'Vuelva a iniciar sesión':
	  validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajeInformacion/p_msjTiempoExcedido'),
		  'Vuelva a iniciar sesión', FailureHandling.OPTIONAL)
	  break
	  
	//Reporte cuenta corriente beneficiario. Validar modal sin deuda registrada
	case '¡Atención!': 
	   validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajeInformacion/h2_Atencin'), '¡Atención!')
	   break
	   
	case 'No tiene deuda registrada.':
	   validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajeInformacion/p_msjNoDeudaRegistrada'),
		  'No tiene deuda registrada.')
	   break
	   
	//Genericos 
	//Activar usuario
	case 'Gracias por su Registro':
	   validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/h1_RegistroExitoso'), 'Gracias por su Registro')
	   break
	
	//Bloquear Usuario Intentos fallidos      
	case 'Usuario bloqueado por superar intentos fallidos':
	   validar = WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_Login/p_msjUsuarioBloqueadoIntentosFallidos'),
	    'Usuario bloqueado por superar intentos fallidos', FailureHandling.STOP_ON_FAILURE)
	  break
	 
	//confirmar registro
	/**  
	case 'Revise su bandeja de correo electrónico para confirmar el registro':
	   validar= WebUI.verifyTextPresent('Revise su bandeja de correo electrónico para confirmar el registro', false, FailureHandling.OPTIONAL)
	  break
	 **/
	case 'Revise su bandeja de correo electrónico para confirmar el registro':
	  validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_MensajesRegistrar/p_ReviseBandeja'),
		msj)
	  break
	    
	//Crear Carpeta
	case 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!':
	  validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_CrearCarpeta/p_CarpetaCreadaExito'), 'Estimado usuario, le informamos que su carpeta ha sido guardada con éxito. Si desea agregar documentación, por favor diríjase a Carpeta > Nuevo Documento. ¡Gracias por su colaboración!')
	  break
	  
	//Enviar carpeta
	case 'La documentación se ha enviado exitosamente':
	  validar= WebUI.verifyElementText(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpeta/h2_msjDocumentoEnviado'), msj, FailureHandling.OPTIONAL)
	  break
}

WebUI.callTestCase(findTestCase('OBSBA/Genericos/DobleClickPantalla'), [:], FailureHandling.STOP_ON_FAILURE)

return validar
