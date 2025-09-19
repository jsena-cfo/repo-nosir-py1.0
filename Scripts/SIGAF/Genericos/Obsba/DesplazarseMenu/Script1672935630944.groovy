import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil

Screen screen = new Screen()


CustomKeywords.'tool.sikuli.esperarImg'(screen, 'optGastos.png', 'ObsbaCarga', 25)
//CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpUsuario.png', 'ObsbaCarga')
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optGastos.png', 'ObsbaCarga')

/**
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optFacturacionObsba.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optFacturacionDeudaFlotante.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optFacturacionDeudaFlotanteint.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'optingreso.png', 'ObsbaCarga')**/

CustomKeywords.'tool.sikuli.delay'(1)

/**Se posiciona en la opcion Facturacion OBSBA e ingresa**/

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Se posiciona en la opcion Factura Deuda Flotante e ingresa**/

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Se posiciona en la opcion Factura Deuda Flotante e ingresa**/

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Se posiciona en la opcion Ingreso e ingresa**/

CustomKeywords.'tool.sikuli.keyDown'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

