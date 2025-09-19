import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String numeroContratacion= this.getBinding().getAt('varNumeroContratacion').toString()

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.keyTab'(screen)

String anio= CustomKeywords.'tool.DateGenerator.currentYear'()

CustomKeywords.'tool.sikuli.ingresarInput'(screen, anio)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.robot.type'(numeroContratacion)

CustomKeywords.'tool.sikuli.keyF8'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnV.png', 'ComprasAdjudicacion')

/**Ingresar selector Prov**/
//CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectProv.png', 'ComprasAdjudicacion')

//CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectProvAlt.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectProvAlt2.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'checkRequierePolizaNo.png', 'ComprasAdjudicacion')

/**Ingresar en solapa Datos Asig Cont**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosAsigCont.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'selectorPeriodicidad.png', 'ComprasAdjudicacion', 86, -1)

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpDuracionContrato.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '365')

/**Ingresar en solapa Items**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItems.png', 'ComprasAdjudicacion')

//CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorRP.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.clickImg'(screen, 'selectorRPAlt.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Ingresar solapa imputacion**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaImpPresupuestaria.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'inpFechaImputacion.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen,  'inpFechaImputacion.png', 'ComprasAdjudicacion')

String fechaHoy= CustomKeywords.'tool.DateGenerator.today'()

CustomKeywords.'tool.robot.type'(fechaHoy)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '90.00')

/**Guardar**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardar.png', 'ComprasAdjudicacion')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardar.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardarActualizacion.png', 'ComprasAdjudicacion', 25)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

/**Ir a solapa Datos Asignacion**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaDatosAsignacion.png', 'ComprasAdjudicacion')