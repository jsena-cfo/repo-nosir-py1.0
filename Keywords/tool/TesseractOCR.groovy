package tool

import org.sikuli.script.*
import java.io.File
@Grab(module = 'tess4j', version = '4.3.0', group = 'net.sourceforge.tess4j')
import net.sourceforge.tess4j.*
import net.sourceforge.tess4j.ITesseract as ITesseract
import net.sourceforge.tess4j.Tesseract as Tesseract
import net.sourceforge.tess4j.TesseractException as TesseractException

import net.sourceforge.tess4j.util.LoadLibs as LoadLibs
import com.kms.katalon.core.annotation.Keyword


//NO HUBO FORMA DE HACER FUNCIONAR ESTA CUSTOM KEYWORD
public class TesseractOCR {

	String validateDigits(String numero) {
		int cantidadFallas= 0
		def digitos = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
		for(int i=0; i<numero.length(); i++) {
			char chr = numero.charAt(i)
			if(!digitos.contains(chr)){
				System.out.println('Validacion digito falla detectada: ' + chr)
				cantidadFallas= cantidadFallas + 1
			}
		}
		return cantidadFallas.toString()
	}

	@Keyword
	String validateImg(String imgNum1, String imgNum2, String imgNum3) {
		if((imgNum1.equals(imgNum2)) && (imgNum2.equals(imgNum3)) && (imgNum1.equals(imgNum3))) {
			System.out.println('Porcentaje OCR de exactitud: 100%')
			System.out.println('Cantidad fallas detectadas: ' + this.validateDigits(imgNum1))
			return imgNum1
		}
		else{
			if((imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
				System.out.println('Porcentaje OCR de exactitud: 80%')
				System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1))
				System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum3))
				return imgNum1
			}
			else{
				if((!imgNum1.equals(imgNum2)) && (imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
					System.out.println('Porcentaje OCR de exactitud: 80%')
					System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1))
					System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2))
					return imgNum2
				}
				else {
					if((!imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (imgNum1.equals(imgNum3))) {
						System.out.println('Porcentaje OCR de exactitud: 80%')
						System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1))
						System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2))
						return imgNum1
					}
					else {
						if((!imgNum1.equals(imgNum2)) && (!imgNum2.equals(imgNum3)) && (!imgNum1.equals(imgNum3))) {
							System.out.println('Inconsistencia OCR')
							System.out.println('Cantidad fallas detectadas en primer valor: ' + this.validateDigits(imgNum1))
							System.out.println('Cantidad fallas detectadas en segundo valor: ' + this.validateDigits(imgNum2))
							System.out.println('Cantidad fallas detectadas en tercer valor: ' + this.validateDigits(imgNum3))
							return '0000'
						}
					}
				}
			}
		}
		//CustomKeywords.'tool.File.agregarLineaEstadisticaOCR'(imgNum1, porcentaje)
	}

	@Keyword
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

	@Keyword
	String getImgTextWithValidation(String imageLocation) {
		Tesseract instance = new Tesseract()

		File tessDataFolder = LoadLibs.extractTessResources('tessdata')
		instance.setDatapath(tessDataFolder.getPath())
		try {
			String imgNum1 = instance.doOCR(new File(imageLocation))
			String imgNum2 = instance.doOCR(new File(imageLocation))
			String imgNum3 = instance.doOCR(new File(imageLocation))
			return this.validateImg(imgNum1, imgNum2, imgNum3)
		}
		catch (TesseractException e) {
			e.getMessage()
			return 'Error al leer la imagen'
		}
	}

	@Keyword
	String getImgTextOCRJNA(String pathImg) {
		System.out.println("***GetImgTextOCR path: " + pathImg)
		File imageFile = new File(pathImg);
		ITesseract instance = new Tesseract();  // JNA Interface Mapping
		// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		instance.setDatapath("tessdata"); // path to tessdata directory

		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
			return result
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return 'Error al leer imagen'
		}
	}

	@Keyword
	String getImgTextOCR(String pathImg){
		Tesseract tesseract = new Tesseract();
		try {

			tesseract.setDatapath("tessdata");
			// the path of your tess data folder
			// inside the extracted file

			String text= tesseract.doOCR(new File(pathImg));
			// path of your image file

			System.out.print(text);
			return text
		}
		catch (TesseractException e) {
			e.printStackTrace();
			System.out.print('Error al leer imagen');
			return 'Error al leer imagen'
		}
	}
}
