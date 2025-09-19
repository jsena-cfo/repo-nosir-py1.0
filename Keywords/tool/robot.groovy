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


public class robot {
	Robot robot = new Robot()

	/**
	 * Click izquierdo por coordenada(x,y)
	 * @param x - coordenada en la posicion x
	 * @param y - coordenada en la posicion y
	 */
	@Keyword
	def click(int x, int y) {
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	/**
	 * Escribe un texto por coordenada(x,y)
	 * @param x - coordenada en la posicion x
	 * @param y - coordenada en la posicion y
	 * @param text - string a escribir
	 */
	@Keyword
	def typeInCoordinate(int x, int y, String text) {
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * Click izquierdo por coordenada(x,y)
	 * @param x - coordenada en la posicion x
	 * @param y - coordenada en la posicion y
	 */
	@Keyword
	def doubleClick(int x, int y) {
		robot.mouseMove(x, y);
		// primer click
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// segundo click
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	/**
	 * Escribe texto en la posicion donde se encuentre
	 * @param x - coordenada en la posicion x
	 * @param y - coordenada en la posicion y
	 * @param text - string a escribir
	 */
	@Keyword
	def type(String text) {
		StringSelection stringSelection = new StringSelection(text)
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
		clipboard.setContents(stringSelection, stringSelection)

		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
	}

	@Keyword
	def mouseOver(int x, int y) {
		robot.mouseMove(x, y)
	}

	@Keyword
	def pressKeyArrowRight() {
		robot.keyPress(KeyEvent.VK_RIGHT)
		robot.keyRelease(KeyEvent.VK_RIGHT)
	}
	
	@Keyword
	def pressTab() {
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyRelease(KeyEvent.VK_TAB)

	}
}
