import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'solapaItems.png', 'ComprasPliegos', 25)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'solapaItems.png', 'ComprasPliegos')

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '295') //ingresa codigo de catalogo 01

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '651503') //ingresa codigo de catalogo 02

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '9032747') //ingresa codigo de catalogo 03

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1') //ingreso de cantidad

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen) //despliega el selector

CustomKeywords.'tool.sikuli.keyEnter'(screen) //selecciona la opcion

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keySpace'(screen) //seleciona la fila tildandola
