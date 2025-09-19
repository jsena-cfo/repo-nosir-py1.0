import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

screen.wait(new Pattern(pathImagen('inpEjercicio.png')).targetOffset(46, -2), 10)

screen.type(new Pattern(pathImagen('inpEjercicio.png')).targetOffset(46, -2), anioActual)

screen.type(new Pattern(pathImagen('inpTipoDeAJuste.png')).targetOffset(47, 0), 'LEY')

screen.type(new Pattern(pathImagen('inpActuacionOrigen.png')).targetOffset(50, 0), 'LEY')

screen.type(new Pattern(pathImagen('inpTipoActuacion.png')).targetOffset(47, -1), 'LEY')

screen.type(new Pattern(pathImagen('inpNormaAprobatoria.png')).targetOffset(50, -1), '28')

screen.type(new Pattern(pathImagen('inpMotivo.png')).targetOffset(22, -1), 'G')

screen.type(new Pattern(pathImagen('inptNroActOrigen.png')).similar(0.90).targetOffset(15, -22), '123')

screen.type(new Pattern(pathImagen('inpOfiActOrigen.png')).similar(0.90).targetOffset(-52, -24), '123')

screen.type(new Pattern(pathImagen('inpFechas.png')).similar(0.70).targetOffset(-35, -40), anioActual)

screen.type(new Pattern(pathImagen('inpNroTipoAct.png')).similar(0.89).targetOffset(23, -15), '123')

screen.type(new Pattern(pathImagen('inpOfiTipoAct.png')).similar(0.90).targetOffset(-57, -18), '123')

screen.type(new Pattern(pathImagen('inpFechas.png')).similar(0.70).targetOffset(-32, -22), anioActual)

screen.type(new Pattern(pathImagen('inpNroNormaAprob.png')).similar(0.89).targetOffset(21, -14), '123')

screen.type(new Pattern(pathImagen('inpOfiNormaAprob.png')).similar(0.86).targetOffset(-56, -11), '123')

screen.type(new Pattern(pathImagen('inpFechas.png')).similar(0.70).targetOffset(-35, -2), anioActual)

screen.click(new Pattern(pathImagen('inpFechaActOrigen.png')).similar(0.81).targetOffset(30, -24))

CustomKeywords.'tool.robot.type'(fechaActual)

screen.click(new Pattern(pathImagen('inpFechaTipoAct.png')).similar(0.85).targetOffset(29, -16))

CustomKeywords.'tool.robot.type'(fechaActual)

screen.click(new Pattern(pathImagen('inpFechaNormaAprob.png')).similar(0.81).targetOffset(28, -10))

CustomKeywords.'tool.robot.type'(fechaActual)

screen.click(pathImagen('btnObservaciones.png'))

screen.type(pathImagen('inpSector.png'), '0')

screen.type(pathImagen('inpNroObservacion.png'), '0')

screen.type(pathImagen('inpDescripcion.png'), 'test')

screen.click(pathImagen('btnVolver.png'))

screen.click(pathImagen('btnGuardar.png'))

screen.click(pathImagen('btnSi.png'))

screen.click(pathImagen('btnAceptar.png'))


def pathImagen(String nombreimagen) {
    def path = System.getProperty('user.dir') + '\\Image Repository\\MPCompletarCamposRequerimiento\\'

    nombreimagen = (path + nombreimagen)

    KeywordUtil.logInfo('ruta imagen: ' + nombreimagen)

    return nombreimagen
}


