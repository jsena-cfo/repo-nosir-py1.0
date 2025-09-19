import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String numero= this.getBinding().getAt('varNumero').toString()
String tipoProcedimiento= this.getBinding().getAt('varTipoProcedimiento').toString()
String rubro= this.getBinding().getAt('varRubro').toString()
String clase= this.getBinding().getAt('varClase').toString()
String modalidad= this.getBinding().getAt('varModalidad').toString()


Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIraIngreso.png', 'ComprasParametros', 25)
CustomKeywords.'tool.sikuli.dobleClickImg'(screen, 'btnIraIngreso.png', 'ComprasParametros')

/**Tipo procedimiento: 230**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, tipoProcedimiento)
CustomKeywords.'tool.sikuli.keyTab'(screen)

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'().toString()

/**Año**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual)
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Rubro: 7210**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, rubro)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Clase: 10**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, clase)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Modalidad: 0**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, modalidad)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Tipo gestion**/
/**
CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1')
CustomKeywords.'tool.sikuli.keyTab'(screen)**/

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaProcedimientoCont.png', 'ComprasParametros', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaProcedimientoCont.png', 'ComprasParametros')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaSolicitudes.png', 'ComprasParametros', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaSolicitudes.png', 'ComprasParametros')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalSolicitudes.png', 'ComprasParametros', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarModal.png', 'ComprasParametros')

CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'formSolicitudesAutorizadas.png', 'ComprasParametros', 25)

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Ingreso para filtrar en listado**/
String valorBuscado= 'COMPRAS%'+ numero

System.out.println('***Valor buscado: ' + valorBuscado)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, valorBuscado)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keySpace'(screen)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaProc.png', 'ComprasParametros')

/**Presiona boton Guardar**/
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardar.png', 'ComprasParametros')


/**Modal que confirma Guardado**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardar.png', 'ComprasParametros', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarGuardar', 'ComprasParametros')


/**Modal que confirma aviso expediente cabecera**/
if(CustomKeywords.'tool.sikuli.existeImg'(screen, 'modalAviso.png', 'ComprasParametros', 10)) {
   //CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalAviso.png', 'ComprasParametros', 25)
   CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarAviso', 'ComprasParametros')
}

/**Modal que confirma Actualizacion realizada**/
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacionRealizada.png', 'ComprasParametros', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarActualizacionRealizada', 'ComprasParametros')