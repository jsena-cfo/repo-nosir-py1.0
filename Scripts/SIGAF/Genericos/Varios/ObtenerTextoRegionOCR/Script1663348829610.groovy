import org.sikuli.script.*
//@Grab(module = 'tess4j', version = '4.3.0', group = 'net.sourceforge.tess4j')
//@Grab(group='org.slf4j', module='jul-to-slf4j', version='2.0.0')
import net.sourceforge.tess4j.*
import net.sourceforge.tess4j.Tesseract as Tesseract
import net.sourceforge.tess4j.util.LoadLibs as LoadLibs
import org.sikuli.basics.Settings
import java.io.File as File
import java.io.*
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.nio.file.Path
import java.nio.file.Paths
import java.awt.image.BufferedImage


int x= this.getBinding().getAt('varX').toString().toInteger()
int y= this.getBinding().getAt('varY').toString().toInteger()
int w= this.getBinding().getAt('varW').toString().toInteger()
int h= this.getBinding().getAt('varH').toString().toInteger()
			
Screen screen = new Screen()

//Se realiza una captura de pantalla en la region dada
ScreenImage nroReq = screen.capture(x, y, w, h)

//Se obtiene el path de esa ScreenImage
//String path = nroReq.getFilename()
String path = nroReq.getFile()

//BufferedImage bi= nroReq.getImage()

//A traves del metodo aux de tesseract (ocr) se obtiene el nro
String resultado = this.getImgText(path)

println('Resultado obtenido: ' + resultado)

return resultado

//validacion simple
String getImgText(String imageLocation) {
	Tesseract instance = new Tesseract()

	File tessDataFolder = LoadLibs.extractTessResources('tessdata')

	instance.setDatapath(tessDataFolder.getPath())
	
	instance.setOcrEngineMode(1)

	try {
		String imgNum = instance.doOCR(new File(imageLocation))

		return imgNum
	}
	catch (TesseractException e) {
		e.getMessage()

		return 'Error al leer la imagen'
	}
}
