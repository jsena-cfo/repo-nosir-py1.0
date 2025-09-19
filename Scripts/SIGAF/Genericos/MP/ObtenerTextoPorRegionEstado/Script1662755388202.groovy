import org.sikuli.script.*
//@Grab(module = 'tess4j', version = '4.3.0', group = 'net.sourceforge.tess4j')
//@Grab(group='org.slf4j', module='jul-to-slf4j', version='2.0.0')
import net.sourceforge.tess4j.*
import net.sourceforge.tess4j.Tesseract as Tesseract
import net.sourceforge.tess4j.util.LoadLibs as LoadLibs
import java.io.File as File
import java.io.*
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.nio.file.Path
import java.nio.file.Paths

Screen screen = new Screen()

//Se realiza una captura de pantalla en la region dada
def nroReq = screen.capture(x, y, w, h)

//Se obtiene el path de esa ScreenImage
def path = nroReq.getFilename()

//A traves del metodo aux de tesseract (ocr) se obtiene el nro
def resultado = this.getImgText(path)

println('Resultado obtenido: ' + resultado)

return resultado

//validacion simple
String getImgText(String imageLocation) {
	Tesseract instance = new Tesseract()

	File tessDataFolder = LoadLibs.extractTessResources('tessdata')

	instance.setDatapath(tessDataFolder.getPath())

	try {
		String imgNum = instance.doOCR(new File(imageLocation))

		return imgNum
	}
	catch (TesseractException e) {
		e.getMessage()

		return 'Error al leer la imagen'
	}
}
