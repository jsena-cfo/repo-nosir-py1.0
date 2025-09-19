import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


String unidadEjecutora= this.getBinding().getAt('varUnidadEjecutora').toString() 	
String delegacion= this.getBinding().getAt('varDelegacion').toString()
String oficinaCompras= this.getBinding().getAt('varOficinaCompras').toString()  
String unidadSolicitante= this.getBinding().getAt('varUnidadSolicitante').toString() 
String objSolicitud= this.getBinding().getAt('varObjSolicitud').toString() 
String rubro= this.getBinding().getAt('varRubro').toString()
String actuadoDelegacion= this.getBinding().getAt('varActuadoDelegacion').toString()
String actuadoTipo= this.getBinding().getAt('varActuadoTipo').toString() 
String actuadoNumero= this.getBinding().getAt('varActuadoNumero').toString()  
String sadeTipo= this.getBinding().getAt('varSadeTipo').toString() 
String sadeNumero= this.getBinding().getAt('varSadeNumero').toString() 
String repActuado= this.getBinding().getAt('varRepActuado').toString() 
String repUsuario= this.getBinding().getAt('varRepUsuario').toString() 
String procSeleccion= this.getBinding().getAt('varProcSeleccion').toString()  
String clase= this.getBinding().getAt('varClase').toString() 
String modalidad= this.getBinding().getAt('varModalidad').toString()


Screen screen = new Screen()
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnIrAIngreso.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnIrAIngreso.png', 'ComprasSolicitudGasto')

/**Encabezado**/

CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Unidad ejecutora: '420'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, unidadEjecutora) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Delegacion: '260'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, delegacion) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Oficina de compras: '%4201' o '%402'**/
CustomKeywords.'tool.sikuli.keyEnter'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.ingresarInput'(screen, oficinaCompras)
CustomKeywords.'tool.sikuli.keyEnter'(screen)
CustomKeywords.'tool.sikuli.delay'(2)
CustomKeywords.'tool.sikuli.keyEnter'(screen)
CustomKeywords.'tool.sikuli.delay'(2)

CustomKeywords.'tool.sikuli.keyTab'(screen)
//CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyBackspace'(screen)


/**Unidad solicitante: 'ORTOPEDIA Y TRAUMATOLOGIA'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, unidadSolicitante) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

/**Obj de la solicitud: 'UTILES MEDICOS QUIRURGICOS Y DE LABORATORIO'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, objSolicitud) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Rubro: '7210'**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, rubro) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Actuado**/

/**Delegacion: 260**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, actuadoDelegacion) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.delay'(2)

/**Tipo: EXP**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, actuadoTipo) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Numero: 714613**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, actuadoNumero) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'().toString()

/**Año**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Actuado SADE**/

/**Tipo: EX**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, sadeTipo)
CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, anioActual)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Numero: 714613**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, sadeNumero) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Rep Actuado: HGNRG**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, repActuado) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Rep usuario: HGNRG**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, repUsuario) 
CustomKeywords.'tool.sikuli.keyTab'(screen)
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Proc Seleccion: 230**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, procSeleccion) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Clase: 10**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, clase) 
CustomKeywords.'tool.sikuli.keyTab'(screen)

/**Modalidad: 0**/
CustomKeywords.'tool.sikuli.ingresarInput'(screen, modalidad)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaSolicitudGastoContinuacion.png', 'ComprasSolicitudGasto')
CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaSolicitudGasto.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'btnGuardarSolicitud.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardarSolicitud.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardarDatos.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSi.png', 'ComprasSolicitudGasto')

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalActualizacionRealizada.png', 'ComprasSolicitudGasto', 25)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptarActualizacion.png', 'ComprasSolicitudGasto')
