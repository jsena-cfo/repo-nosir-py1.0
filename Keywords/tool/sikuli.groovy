package tool
import org.sikuli.script.*
import org.sikuli.script.FindFailed
import org.sikuli.script.Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.util.KeywordUtil
//import internal.GlobalVariable as GlobalVariable
import java.util.concurrent.TimeUnit
import org.sikuli.script.SikuliEvent


public class sikuli {
	static String path = System.getProperty("user.dir") + "\\Image Repository\\"
	Screen screen = new Screen()
	Region region = new Region()
	//Screen screenAux

	def String pathImagen(String nombreimagen) {
		nombreimagen = path + nombreimagen + ".png"
		KeywordUtil.logInfo("ruta imagen: " + nombreimagen)
		return nombreimagen
	}

	/**
	 * Click izquierdo sobre el objeto presente en la imagen
	 * @param imagen - nombre de la imagen
	 */
	@Keyword
	def click(String imagen) {
		def match = screen.exists(new Pattern(pathImagen(imagen)).similar(0.9),15)
		if (match) {
			screen.click(pathImagen(imagen))
		}
	}

	/**
	 * Doble click izquierdo sobre el objeto presente en la imagen
	 * @param imagen - nombre de la imagen
	 */
	@Keyword
	def doubleClick(String imagen) {
		def match = screen.exists(new Pattern(pathImagen(imagen)).similar(0.9),15)
		if (match) {
			screen.doubleClick(pathImagen(imagen))
		}
	}

	/**
	 * Escribe un texto
	 * @param nombreimagen
	 * @param txt
	 * @throws FindFailed
	 */
	@Keyword
	def type(String imagen,String txt) throws FindFailed {
		def match = screen.exists(new Pattern(pathImagen(imagen)).similar(0.9),15)
		if (match) {
			screen.click(pathImagen(imagen))
			screen.type(txt)
		}
	}
	/**
	 * Click izquierdo por posicion
	 * @param x - coordenada en x
	 * @param y - coordenada en y
	 */
	@Keyword
	def clickLocation(int x, int y) {
		def location = new Location(x,y)
		screen.click(location)
	}

	@Keyword
	def Screen getScreen() {
		//return screenAux
	}

	@Keyword
	def setScreen(Screen screen) {
		//this.screenAux= screen
	}

	/**retorna la ruta armada por el nombre de la imagen y la carpeta asociada**/
	@Keyword
	def pathImg(String nombreimagen, String folder) {
		def path = System.getProperty('user.dir') + '\\Image Repository' + '\\' + folder + '\\'
		nombreimagen = (path + nombreimagen)
		KeywordUtil.logInfo('ruta imagen: ' + nombreimagen)
		return nombreimagen
	}

	/**espera parametrizable por cantidad de segundos**/
	@Keyword
	def delay(int segundos) {
		TimeUnit.SECONDS.sleep(segundos) //2 segundos
	}

	//presiona tecla TAB y espera 1 segundo
	@Keyword
	def keyTab(Screen screen) {
		screen.type(Key.TAB)
		this.delay(1) //1 segundos
	}
	
	//presiona tecla TAB y espera 1 segundo
	@Keyword
	def keyBackspace(Screen screen) {
		screen.type(Key.BACKSPACE)
		this.delay(1) //1 segundos
	}

	//presiona tecla Enter y espera 1 segundo
	@Keyword
	def keyEnter(Screen screen) {
		screen.type(Key.ENTER)
		//this.delay(1) //1 segundos
	}

	//presiona tecla Space y espera 1 segundo
	@Keyword
	def keySpace(Screen screen) {
		screen.type(Key.SPACE)
		this.delay(1) //1 segundos
	}

	//presiona tecla F7 y espera 1 segundo
	@Keyword
	def keyF7(Screen screen) {
		screen.type(Key.F7)
		this.delay(1) //1 segundos
	}

	//presiona tecla F8 y espera 1 segundo
	@Keyword
	def keyF8(Screen screen) {
		screen.type(Key.F8)
		this.delay(1) //1 segundos
	}

	//presiona tecla arriba y espera 1 segundo
	@Keyword
	def keyUp(Screen screen) {
		screen.type(Key.UP)
		this.delay(1) //1 segundos
	}

	//presiona tecla abajo y espera 1 segundo
	@Keyword
	def keyDown(Screen screen) {
		screen.type(Key.DOWN)
		this.delay(1) //1 segundos
	}


	//presiona tecla arriba y espera 1 segundo
	@Keyword
	def keyAltPlusF4(Screen screen) {
		//screen.type(Key.ALT, Key.F4)
		screen.keyDown(Key.ALT)
		screen.keyDown(Key.F4)
		screen.keyUp()
		this.delay(1) //1 segundos
	}

	//presiona combinacion de teclas que despliegan el reloj
	@Keyword
	def keyOpenTime(Screen screen){
		//Windows + Alt + D
		screen.keyDown(Key.WIN)
		screen.keyDown(Key.ALT)
		screen.keyDown('d')
		screen.keyUp()
		this.delay(1) //1 segundos
	}

	//espera hasta bque este presente la imagen en el target ingresado con acierto del 90%
	@Keyword
	def esperarImgTarget(Screen screen, String imagen, String carpeta, int x, int y, int tiempo) {
		screen.wait(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90).targetOffset(x, y), tiempo)
	}

	//espera hasta bque este presente la imagen con acierto del 90%
	@Keyword
	def esperarImg(Screen screen, String imagen, String carpeta, int espera) {
		screen.wait(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90), espera)
	}

	//ingresa informacion al input en donde se esta posicionado
	@Keyword
	def ingresarInput(Screen screen, String valor) {
		screen.type(valor)
	}

	//ingresa informacion al input asociado a la imagen a traves de un target con acierto del 90%
	@Keyword
	def ingresarInputImgTarget(Screen screen, String imagen, String carpeta, int x, int y, String valor) {
		screen.type(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90).targetOffset(x, y), valor)
	}

	//ingresa informacion al input asociado a la imagen a traves de un target con acierto parametrizable
	@Keyword
	def ingresarInputImgTargetPorcentaje(Screen screen, String imagen, String carpeta, int x, int y, String valor, float porcentaje) {
		screen.type(new Pattern(this.pathImg(imagen, carpeta)).similar(porcentaje).targetOffset(x, y), valor)
	}

	//ingresa informacion al input asociado a la imagen con  acierto del 90% por default
	@Keyword
	def ingresarInputImg(Screen screen, String imagen, String carpeta, String valor) {
		screen.type(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90), valor)
	}

	//click simple sobre donde se esta
	@Keyword
	def click(Screen screen) {
		screen.click()
	}

	//click por imagen con 90% de acierto por default
	@Keyword
	def clickImg(Screen screen, String imagen, String carpeta) {
		screen.click(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90))
	}

	//click por imagen con acierto parametrizable
	@Keyword
	def clickImgPorcentaje(Screen screen, String imagen, String carpeta, float porcentaje) {
		screen.click(new Pattern(this.pathImg(imagen, carpeta)).similar(porcentaje))
	}

	//click por imagen con 90% de acierto por default con target parametrizable
	@Keyword
	def clickImgTarget(Screen screen, String imagen, String carpeta, int x, int y) {
		screen.click(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90).targetOffset(x, y))
	}

	//doble click sobre imagen con acierto del 90% por default
	@Keyword
	def dobleClickImg(Screen screen, String imagen, String carpeta) {
		screen.doubleClick(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90))
	}

	@Keyword
	def encontrar(Screen screen, String imagen, String carpeta) {
		return screen.find(new Pattern(this.pathImg(imagen, carpeta)))
	}

	//posicionar puntero en una region
	@Keyword
	def enfocar(Screen screen, int x, int y, int w, int h) {
		screen.hover(new Region(x, y, w, h))
	}

	/**Valida que la imagen existe en la pantalla**/
	@Keyword
	def existeImg(Screen screen,  String imagen, String carpeta, double tiempo) {
		Match match = screen.exists(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90), tiempo)
		if(match != null) {
			return true
		}
		else {
			return false
		}
	}

	def handler(SikuliEvent event) {
		event.getRegion().highlight(3)
	}

	def onAppear(Region reg, String imagen, String carpeta, SikuliEvent event) {
		Region reg2= event.getRegion()
		System.out.println("Tomo la region")

		reg2.onAppear(new Pattern(this.pathImg(imagen, carpeta)).similar(0.90), handler(event))
	}
}

