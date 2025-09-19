import org.sikuli.script.Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.sikuli.script.ObserveEvent
import org.sikuli.script.SikuliEvent
import org.sikuli.script.Sikulix


Screen screen = new Screen()

System.out.println("Se activa el observer")

//Region reg = screen.selectRegion()
Region reg= new Region()
reg.setX(30)
reg.setY(270)
reg.setW(106)
reg.setH(116)

//Match mat= 

SikuliEvent event= new SikuliEvent()

event.setRegion(reg)
//event.setMatch(mat)

CustomKeywords.'tool.sikuli.onAppear'(reg, 'imgLogo.png', 'ObsbaCarga', event)

reg.observeInBackground(10)

System.out.println("Aparecio la imagen")

