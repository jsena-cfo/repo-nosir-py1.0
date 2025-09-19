import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

screen.wait(pathImagen('mnuPresupuesto.png'), 30)
screen.click(pathImagen('mnuPresupuesto.png'))
screen.doubleClick(pathImagen('optionMP.png'))
screen.doubleClick(pathImagen('optionIngresoYModifReq.png')) 

//METODO AUXILIAR
def pathImagen(String nombreimagen) {
    def path = System.getProperty('user.dir') + '\\Image Repository\\MPNavegarAIngresoYMP\\'

    nombreimagen = (path + nombreimagen)

    KeywordUtil.logInfo('ruta imagen: ' + nombreimagen)

    return nombreimagen
}