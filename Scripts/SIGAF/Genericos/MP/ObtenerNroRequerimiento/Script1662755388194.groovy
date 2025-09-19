import org.sikuli.script.*
import java.io.File
import java.io.*
@Grab(module = 'tess4j', version = '4.3.0', group = 'net.sourceforge.tess4j')
import net.sourceforge.tess4j.*
import net.sourceforge.tess4j.util.LoadLibs as LoadLibs


Screen screen = new Screen()
//Se realiza una captura de pantalla en la region dada
def nroReq = screen.capture(x, y, w, h)
//Se obtiene la imagen de esa captura
def image = nroReq.getImage()

String inputImagePath = CustomKeywords.'tool.image.grayToBlackAndWhite'(image, 100)
//String outputImagePath = CustomKeywords.'tool.image.resize'(inputImagePath, 300, 100)
String outputImagePath = CustomKeywords.'tool.image.resizeWithPercent'(inputImagePath, 3)


def resultado = getImgText(outputImagePath)
println "Resultado obtenido: "+ resultado

return resultado

String getImgText(String imageLocation) {
	Tesseract instance = new Tesseract()
	
	File tessDataFolder = LoadLibs.extractTessResources('tessdata')
	instance.setDatapath(tessDataFolder.getPath())
	instance.setTessVariable('tessedit_char_whitelist', '0123456789')
	instance.setTessVariable('tessedit_char_blacklist', "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz")
	try {
		String imgNum = instance.doOCR(new File(imageLocation))
		return imgNum
	}
	catch (TesseractException e) {
		e.getMessage()
		return 'Error al leer la imagen'
	}
}




