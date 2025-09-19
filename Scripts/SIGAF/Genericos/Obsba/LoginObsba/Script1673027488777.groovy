import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil

String varUsuario= this.getBinding().getVariables().getAt('varUsuario').toString()
String varPassword= this.getBinding().getVariables().getAt('varPassword').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'labelingreso.png', 'ObsbaCarga', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpUsuario.png', 'ObsbaCarga')
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varUsuario)

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.ingresarInput'(screen, varPassword)

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarLogin.png', 'ObsbaCarga')



/**
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpUsuario.png', 'MPLogin', varUsuario)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpPassword.png', 'MPLogin', varPassword)

System.out.println("****Rol: " + varRol)

if(varRol.equals('formulacion')) {
	System.out.println("****Ingreso al if")
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorEjecucionRol.png', 'MPLogin')
	CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorFormulacion.png', 'MPLogin')
}

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'ddlPerfil.png', 'MPLogin', 152, 0)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'optionOrganoRector.png', 'MPLogin')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'MPLogin')**/
