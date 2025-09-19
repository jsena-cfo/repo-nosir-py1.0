import org.sikuli.script.*

Screen screen = new Screen()

CustomKeywords.'tool.sikuli.esperarImg'(screen, 'tabDetallePres.png', 'ObsbaCarga', 5)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'tabDetallePres.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.ingresarInputImgTargetPorcentaje'(screen, 'inpObjetoGasto.png', 'ObsbaCarga', 4, 17, objetoGasto, 0.70)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, acta)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, ff)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, tm)

screen.type(Key.TAB)

CustomKeywords.'tool.sikuli.ingresarInput'(screen, ug)

screen.type(Key.TAB)

/*

CustomKeywords.'tool.sikuli.clickImg'(screen, 'tabCabecera1.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.delay'(1)

//CustomKeywords.'tool.sikuli.clickImgTarget'(screen, 'inpFechaEmision.png', 'ObsbaCarga', 29, -3)

CustomKeywords.'tool.sikuli.clickImg'(screen, 'inpFechaEmision.png', 'ObsbaCarga')

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.robot.type'(fechaEmision)

CustomKeywords.'tool.sikuli.delay'(1)

CustomKeywords.'tool.sikuli.keyTab'(screen)

CustomKeywords.'tool.robot.type'(fechaCarpeta)

CustomKeywords.'tool.sikuli.delay'(1)
*/

