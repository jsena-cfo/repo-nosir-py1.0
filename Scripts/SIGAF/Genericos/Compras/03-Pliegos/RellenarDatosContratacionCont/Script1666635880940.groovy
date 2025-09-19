import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1') //lugar

CustomKeywords.'tool.sikuli.keyTab'(screen)

//plazo y horario
//CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Lunes a viernes de 09:00 a 18:00') 

CustomKeywords.'tool.robot.type'('Lunes a viernes de 09:00 a 18:00')

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '100.00') //valor

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto ingreso 01') //texto ingreso

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto ingreso 02 documento') //texto ingreso

CustomKeywords.'tool.sikuli.keyTab'(screen)