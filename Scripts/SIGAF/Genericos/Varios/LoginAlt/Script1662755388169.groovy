import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil

String varUsuario= this.getBinding().getVariables().getAt('varUsuario').toString()
String varPassword= this.getBinding().getVariables().getAt('varPassword').toString()
String varRol= this.getBinding().getVariables().getAt('varRol').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImgTarget'(screen, 'inpUsuario.png', 'MPLogin', -10, -2, 25)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpUsuario.png', 'MPLogin', -10, -2, varUsuario)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpPassword.png', 'MPLogin', -13, -4, varPassword)

System.out.println("****Rol: " + varRol)

if(varRol.equals('formulacion')) {
	System.out.println("****Ingreso al if")
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorEjecucionRol.png', 'MPLogin')
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorFormulacion.png', 'MPLogin')
}

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'ddlPerfil.png', 'MPLogin', 152, 0)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'optionOrganoRector.png', 'MPLogin')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'MPLogin')

