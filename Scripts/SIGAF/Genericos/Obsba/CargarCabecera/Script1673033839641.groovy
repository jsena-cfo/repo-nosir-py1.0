import org.sikuli.script.*

Screen screen = new Screen()

//CustomKeywords.'tool.sikuli.esperarImg'(screen, 'inpNroEjercicio.png', 'ObsbaCarga', 5)

CustomKeywords.'tool.sikuli.delay'(2)

//CustomKeywords.'tool.sikuli.ingresarInputImgTargetPorcentaje'(screen, 'inpNroEjercicio.png', 'ObsbaCarga', 0, 0, ejercicio, 0.80)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpNroEjercicio.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, ejercicio)

//CustomKeywords.'tool.sikuli.ingresarInputImg'(screen, 'inpNroEjercicio.png', 'ObsbaCarga', ejercicio)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, nroCarpeta)

screen.type(Key.TAB)

screen.type(Key.F9)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, unidadEjecutora)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, ente)

screen.type(Key.TAB)

//CustomKeywords.'tool.sikuli.delay'(1)

screen.type(Key.F9)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

screen.type(Key.F9)

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.sikuli.keyEnter'(screen)

//CustomKeywords.'tool.sikuli.keyTab'(screen)

screen.type(Key.TAB)

screen.type(Key.F9)

screen.type(Key.F9)

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.robot.type'(observaciones)

//CustomKeywords.'tool.sikuli.ingresarInput'(screen, observaciones)

//CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpFechaEmision.png', 'ObsbaCarga', 35, -1)

//CustomKeywords.'tool.robot.type'(fechaActual)




