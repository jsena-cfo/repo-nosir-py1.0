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
//String pathAbsoluteTxt= 'C:\\Devs\\Txt\\logVisualizacionOCR.txt'
String pathRelativeTxt = System.getProperty("user.dir") + "\\Txt\\" + 'logVisualizacionOCR.txt'
println('Este es el path relativo: ' + pathRelativeTxt)

File txt = new File(pathRelativeTxt)
FileOutputStream fos = new FileOutputStream(txt, true)
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))

//Se realiza una captura de pantalla en la region dada
def nroReq = screen.capture(x, y, w, h)

//Se obtiene el path de esa ScreenImage
def path = nroReq.getFilename()

//A traves del metodo aux de tesseract (ocr) se obtiene el nro
def resultado = this.getImgTextWithValidation(path, bw)

println('Resultado obtenido: ' + resultado)

bw.close()

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

//validacion toma 3 capturas del numero y los compara
String getImgTextWithValidation(String imageLocation, BufferedWriter bw) {
    Tesseract instance = new Tesseract()

    File tessDataFolder = LoadLibs.extractTessResources('tessdata')

    instance.setDatapath(tessDataFolder.getPath())

    try {
        String imgNum1 = instance.doOCR(new File(imageLocation))

        String imgNum2 = instance.doOCR(new File(imageLocation))

        String imgNum3 = instance.doOCR(new File(imageLocation))
		
		return this.validateImg(imgNum1, imgNum2, imgNum3, bw)

    }
    catch (TesseractException e) {
        e.getMessage()

        return 'Error al leer la imagen'
    } 
}

String validateImg(String imgNum1, String imgNum2, String imgNum3, BufferedWriter bw) {
	String digitos1
	String digitos2
	String digitos3
	String fechaHoy= CustomKeywords.'tool.DateGenerator.today'()
	bw.write('**************************'+fechaHoy+'************************\n')
	bw.newLine()
	if((imgNum1.equals(imgNum2)) && (imgNum2.equals(imgNum3)) && (imgNum1.equals(imgNum3))) {
		System.out.println('Numero: '+ imgNum1)
		bw.write('Numero: ' + imgNum1)
		bw.newLine()
		System.out.println('Porcentaje OCR de exactitud: 100%')
		bw.write('Porcentaje OCR de exactitud: 100%\n')
		bw.newLine()
		digitos1= this.validateDigits(imgNum1, bw)
		System.out.println('Cantidad fallas detectadas: ' + digitos1)
		bw.write('Cantidad fallas detectadas: ' + digitos1 + '\n')
		bw.newLine()
		bw.newLine()
		return imgNum1
	}
	else{
		if((imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
			System.out.println('Numero: '+ imgNum1)
			System.out.println('Porcentaje OCR de exactitud: 80%')
			System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1, bw))
			System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum3, bw))
			return imgNum1
		}
		else{
			if((!imgNum1.equals(imgNum2)) && (imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
				System.out.println('Porcentaje OCR de exactitud: 80%')
				System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1, bw))
				System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2, bw))
				return imgNum2
			}
			else {
				if((!imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (imgNum1.equals(imgNum3))) {
					System.out.println('Porcentaje OCR de exactitud: 80%')
					System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1, bw))
					System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2, bw))
					return imgNum1
				}
				else {
					if((!imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
						System.out.println('Inconsistencia OCR')
						System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1, bw))
						System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2, bw))
						System.out.println('Cantidad fallas detectadas en tercer valor: ' + this.validateDigits(imgNum3, bw))
						return '0000'
					}
				}
			}
		}
	}
}


String validateDigits(String numero, BufferedWriter bw) {
	int cantidadFallas= 0
	def digitos = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
	int fin= numero.length()-1
	System.out.println('Fin: ' + fin.toString())
	for(int i=0; i<fin; i++) {
		String chr = numero.charAt(i).toString()
		System.out.println('Digito validado: ' + chr)
		bw.write('Digito validado: ' + chr + '\n')
		bw.newLine()
		if(!digitos.contains(chr)){
			System.out.println('Validacion digito falla detectada: ' + chr)
			bw.write('Validacion digito falla detectada: ' + chr + '\n')
			bw.newLine()
			cantidadFallas= cantidadFallas + 1
		}
	}
	return cantidadFallas.toString()
}