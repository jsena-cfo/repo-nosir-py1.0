package tool

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.awt.*
import java.awt.datatransfer.*
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

import com.kms.katalon.core.configuration.RunConfiguration

import org.openqa.selenium.Keys as Keys

public class UploadFile {
	@Keyword
	def uploadFile (TestObject to, String filePath) {
		String inicialPath= "C:"
		WebUI.click(to)
		StringSelection ss1 = new StringSelection(inicialPath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null)
		Robot robot1 = new Robot()
		//robot.keyPress(KeyEvent.VK_ENTER)
		//robot.keyRelease(KeyEvent.VK_ENTER)
		robot1.delay(3000)
		robot1.keyPress(KeyEvent.VK_CONTROL)
		robot1.keyPress(KeyEvent.VK_V)
		robot1.keyRelease(KeyEvent.VK_V)
		robot1.keyRelease(KeyEvent.VK_CONTROL)
		robot1.keyPress(KeyEvent.VK_ENTER)
		robot1.keyRelease(KeyEvent.VK_ENTER)
		robot1.delay(3000)
		StringSelection ss2 = new StringSelection(filePath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null)
		Robot robot2 = new Robot()
		//robot.keyPress(KeyEvent.VK_ENTER)
		//robot.keyRelease(KeyEvent.VK_ENTER)
		robot2.delay(3000)
		robot2.keyPress(KeyEvent.VK_CONTROL)
		robot2.keyPress(KeyEvent.VK_V)
		robot2.keyRelease(KeyEvent.VK_V)
		robot2.keyRelease(KeyEvent.VK_CONTROL)
		robot2.keyPress(KeyEvent.VK_ENTER)
		robot2.keyRelease(KeyEvent.VK_ENTER)
	}

	@Keyword
	def closeModal () {
		Robot robot1 = new Robot()
		//robot.keyPress(KeyEvent.VK_ENTER)
		//robot.keyRelease(KeyEvent.VK_ENTER)
		robot1.delay(2000)
		/**robot1.keyPress(KeyEvent.VK_TAB)
		 robot1.keyRelease(KeyEvent.VK_TAB)
		 robot1.keyPress(KeyEvent.VK_TAB)
		 robot1.keyRelease(KeyEvent.VK_TAB)
		 robot1.keyPress(KeyEvent.VK_CONTROL)
		 robot1.keyPress(KeyEvent.VK_F4)
		 robot1.keyRelease(KeyEvent.VK_F4)
		 robot1.keyRelease(KeyEvent.VK_CONTROL)**/
		robot1.keyPress(KeyEvent.VK_ESCAPE)
		robot1.keyRelease(KeyEvent.VK_ESCAPE)
	}
	
	@Keyword
	def closeModalWeb() {
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/div_Subir Archivo'), Keys.chord(Keys.ENTER))
	}
	
	@Keyword
	def closeModalImgCancelar() {
		WebUI.delay(2)
		WebUI.click(findTestObject('ObsbaPortal/Page_ObSBA_AdministrarCarpetaDocumento/img_modalBtnCancelar'))
	}

	@Keyword
	def uploadFileWeb(TestObject to, String filePath) {
		String inicialPath= "C:"
		WebUI.click(to)

		WebUI.delay(2)
		'Uploading the File using Send Keys method by passing the File path'
		WebUI.sendKeys(findTestObject('Upload File'), filePath)

		WebUI.delay(2)
	}

	/**Retorna el path relativo del home del usuario**/
	/**Ej: C:\Users\Pepe**/
	/**Ej: C:\Devs\Projects\Katalon\NOSIR**/
	@Keyword
	def pathHome() {
		String home = System.getProperty('user.home').toString()
		return home
	}

	/**Retorna el path relativo desde donde se encuentra el proyecto**/
	/**Retorna lo indicado como location**/
	/**Ej: C:/Devs/Projects/Katalon/NOSIR**/
	@Keyword
	def pathRelativeProject() {
		String dirName = RunConfiguration.getProjectDir().toString()
		return dirName
	}
}
