import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String anioActual= CustomKeywords.'tool.DateGenerator.currentYear'()
String fechaActual= CustomKeywords.'tool.DateGenerator.today'()

System.out.println("***Año actual: " + anioActual)
System.out.println("***Fecha actual: " + fechaActual)

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImgTarget'(screen, 'inpEjercicio.png', 'MPCompletarCamposRequerimiento', 46, -2, 10)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpEjercicio.png', 'MPCompletarCamposRequerimiento', 46, -2, anioActual)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpTipoDeAJuste.png', 'MPCompletarCamposRequerimiento', 47, 0, varTipoAjuste)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpActuacionOrigen.png', 'MPCompletarCamposRequerimiento', 50, 0, varActuacion)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpTipoActuacion.png', 'MPCompletarCamposRequerimiento', 47, -1, varTipoActuacion)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpNormaAprobatoria.png', 'MPCompletarCamposRequerimiento', 50, -1, varNorma)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpMotivo.png', 'MPCompletarCamposRequerimiento', 22, -1, varMotivo)

CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inptNroActOrigen.png', 'MPCompletarCamposRequerimiento', 15, -22, varNumero1)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpOfiActOrigen.png', 'MPCompletarCamposRequerimiento', -52, -24, varNumero2)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpFechas.png', 'MPCompletarCamposRequerimiento', -35, -40, anioActual)

CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpNroTipoAct.png', 'MPCompletarCamposRequerimiento', 23, -15, varNumero3)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpOfiTipoAct.png', 'MPCompletarCamposRequerimiento', -57, -18, varNumero4)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpFechas.png', 'MPCompletarCamposRequerimiento', -32, -22, anioActual)

CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpNroNormaAprob.png', 'MPCompletarCamposRequerimiento', 21, -14, varNumero5)
CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inpOfiNormaAprob.png', 'MPCompletarCamposRequerimiento', -56, -11, varNumero6)
CustomKeywords.'tool.sikuli.ingresarInputImgTargetPorcentaje'(screen, 'inpFechas.png', 'MPCompletarCamposRequerimiento', -35, -2, anioActual, 0.70)

CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpFechaActOrigen.png', 'MPCompletarCamposRequerimiento', 30, -24)
CustomKeywords.'tool.robot.type'(fechaActual)
CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpFechaTipoAct.png', 'MPCompletarCamposRequerimiento', 29, -16)
CustomKeywords.'tool.robot.type'(fechaActual)
CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpFechaNormaAprob.png', 'MPCompletarCamposRequerimiento', 28, -10)
CustomKeywords.'tool.robot.type'(fechaActual)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnObservaciones.png', 'MPCompletarCamposRequerimiento')
CustomKeywords.'tool.sikuli.ingresarInputImg'(screen, 'inpSector.png', 'MPCompletarCamposRequerimiento', varSector)
CustomKeywords.'tool.sikuli.ingresarInputImg'(screen, 'inpNroObservacion.png', 'MPCompletarCamposRequerimiento', varObservaciones)
CustomKeywords.'tool.sikuli.ingresarInputImg'(screen, 'inpDescripcion.png', 'MPCompletarCamposRequerimiento', varDescripcion)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnVolver.png', 'MPCompletarCamposRequerimiento')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnGuardar.png', 'MPCompletarCamposRequerimiento')
CustomKeywords.'tool.sikuli.esperarImg'(screen, 'modalGuardar.png', 'MPCompletarCamposRequerimiento', 30)
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnSiGuardar.png', 'MPCompletarCamposRequerimiento')
CustomKeywords.'tool.sikuli.clickImg'(screen, 'btnAceptar.png', 'MPCompletarCamposRequerimiento')
