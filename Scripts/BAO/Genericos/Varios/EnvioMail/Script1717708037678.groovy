import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import javax.mail.*
import javax.mail.internet.*
import java.util.Properties


    String host = "smtp.office365.com"
    String from = "klonautomation@hotmail.com"
    String password = "Automation1234"

    Properties properties = new Properties()
    properties.setProperty("mail.smtp.host", host)
    properties.setProperty("mail.smtp.port", "587")
    properties.setProperty("mail.smtp.auth", "true")
    properties.setProperty("mail.smtp.starttls.enable", "true")
    properties.setProperty("mail.smtp.connectiontimeout", "10000")
    properties.setProperty("mail.smtp.timeout", "10000")
    properties.setProperty("mail.smtp.writetimeout", "10000")
    properties.setProperty("mail.debug", "true")

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password)
        }
    })

    try {
        MimeMessage message = new MimeMessage(session)
        //message.setFrom(new InternetAddress(from))
		message.setFrom(new InternetAddress(from,"QA Automation - CFO"));
		// message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario))
		destinatario.each { to -> message.addRecipient(Message.RecipientType.TO, new InternetAddress(to))}         
        message.setSubject(asunto)
        message.setContent(cuerpoMail,"text/html;charset=UTF-8")

        Transport.send(message)
        println("Correo enviado exitosamente...")
    } catch (MessagingException mex) {
        mex.printStackTrace()
        println("No se pudo enviar el correo.")
    }
