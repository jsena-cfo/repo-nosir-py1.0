import org.sikuli.script.Screen as Screen
import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.ingresarInputImgTarget'(screen, 'inputsCondicionPagos.png', 'ComprasPliegos', 7, -2, '5')//condicion de pagos

//CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inputsCondicionPagos.png', 'ComprasPliegos', 90, 0)//condicion de pagos selector

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyUp'(screen) //hace dos vecs arriba para selecionar 'Corridos'

CustomKeywords.'tool.sikuli.keyUp'(screen)

//CustomKeywords.'tool.sikuli.keyEnter'(screen) //selecciona con ENTER

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto detalle 01') //ingresa objeto de la contratacion

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '5') //cantidad de dias

CustomKeywords.'tool.sikuli.keyTab'(screen)

//hace dos veces arriba para selecionar 'Corridos'

CustomKeywords.'tool.sikuli.keyUp'(screen) 

CustomKeywords.'tool.sikuli.keyUp'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'texto detalle 02') //texto detalle

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '5') //plazo entrega

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, '1') //lugar entrega

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'Texto observaciones') //texto observaciones

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyEnter'(screen) //carga moneda nacional

CustomKeywords.'tool.sikuli.keyEnter'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'texto detalle 05') //texto detalle

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, 'texto detalle 06') //texto detalle

CustomKeywords.'tool.sikuli.keyTab'(screen)

