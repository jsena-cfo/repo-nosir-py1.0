import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/**Author: JER**/
//def pathExcel = System.getProperty('user.dir') + '\\Xls\\obsba\\UsuariosSigaf.xls'
def pathExcel = System.getProperty('user.dir') + '\\Xls\\obsba\\usersSigafXls\\UsuariosSigaf.xlsx'

def pathRelativo = pathExcel.replace('\\', '\\\\')

int paramRetorno = getBinding().getAt('varRetornoParam')

String password = getBinding().getAt('varPassword').toString()

System.out.println('Parametros de retorno: ' + paramRetorno.toString())

TestData data = findTestData('UsuariosSigaf')

row_control = data.getRowNumbers()

//def index= data.getObjectValue('Index', 1)
//System.out.println("Valor index: " + index)
String hoy = CustomKeywords.'tool.DateGenerator.today'().toString()

for (int i = 1; i <= row_control; i++) {
    def estado = findTestData('UsuariosSigaf').getValue('Estado', i)

    if (estado == '') {
        def cuitDisponible = findTestData('UsuariosSigaf').getValue('CUIT', i)

        def UserSigaf = findTestData('UsuariosSigaf').getValue('UserSigaf', i)

        KeywordUtil.logInfo('Proximo cuit disponible en excel es: ' + cuitDisponible)

        def registroSatisfactorio = WebUI.callTestCase(findTestCase('OBSBA/Genericos/RegistrarInternoGenerico'), [('varPassword') : password
                , ('varUsuario') : UserSigaf, ('varCuil') : cuitDisponible], FailureHandling.STOP_ON_FAILURE)

        if (registroSatisfactorio == true) {
            String cuilSinGuiones = CustomKeywords.'adicionales.CuilRandomGenerator.quitarGuionesyBlancos'(cuitDisponible)

            String token = WebUI.callTestCase(findTestCase('OBSBA/Genericos/ObtenerTokenBD'), [('varUsuario') : cuilSinGuiones], 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('OBSBA/Genericos/ActivarUsuario'), [('varCuil') : cuitDisponible, ('varToken') : token], 
                FailureHandling.STOP_ON_FAILURE)

            //CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 2, i, 'Registrado')
            //columna Estado
            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 3, i, 'Registrado')

            //columna FechaUsado
            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 4, i, hoy)

            if (paramRetorno.equals(1)) {
                //retorna el cuit
                return cuitDisponible //retorna el cuit y el usuario
            } else if (paramRetorno.equals(2)) {
                def mapDatos = [('cuil') : cuitDisponible, ('usuario') : UserSigaf]

                return mapDatos
            }
            
            break //CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 2, i, 'Usuario registrado previamente o invalido')
            //columna Estado
            //columna FechaUsado
            //CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 3, 1, i)
        } else {
            WebUI.takeScreenshot()

            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 3, i, 'Usuario registrado previamente o invalido')

            CustomKeywords.'tool.Excel.SetValueInCell'(pathRelativo, 'Hoja1', 4, i, hoy)
        }
    } else {
        KeywordUtil.logInfo('Estado del usuario: ' + estado)
    }
}

