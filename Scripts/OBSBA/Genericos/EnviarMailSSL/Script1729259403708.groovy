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
import java.util.Properties

import javax.mail.Authenticator
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
//import javax.mail.util
//import javax.mail.internet
//import javax.activation
import javax.mail.Message
import javax.mail.MessagingException

import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


/**Script envio mail**/
	String titulo= this.getBinding().getAt('varTitulo').toString()
	String emailFrom= this.getBinding().getAt('varEmailFrom').toString()
	String pass= this.getBinding().getAt('varPass').toString()
	List destinatarios= this.getBinding().getAt('varDestinatarios') as List
	String asunto= this.getBinding().getAt('varAsunto').toString()
	String body= this.getBinding().getAt('varBodyMail').toString()
	
	System.out.println("Password email: " + pass)

	final String fromEmail = emailFrom //requires valid gmail id
	final String password = pass // correct password for gmail id
	final String toEmail = "jsena@cfotechlatam.com" // can be any email id
	
	System.out.println("SSLEmail Start")
	Properties props = new Properties()
	props.put("mail.smtp.host", varHost) //SMTP Host
	props.put("mail.smtp.socketFactory.port", varPort) //SSL Port
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory") //SSL Factory Class
	props.put("mail.smtp.auth", "true") //Enabling SMTP Authentication
	props.put("mail.smtp.port", varPort) //SMTP Port
	props.put("mail.smtp.starttls.enable", "true")
	
	//email.server.port=25
	
	Authenticator auth = new Authenticator() {
		//override the getPasswordAuthentication method
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(fromEmail, password)
		}
	}
	
	Session session = Session.getDefaultInstance(props, auth)
	System.out.println("Session created")
	
	try {
	  Message message = new MimeMessage(session)
	  message.setFrom(new InternetAddress(fromEmail))
	  message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail))
	
	  message.setSubject(asunto)
	  message.setContent(body,"text/html;charset=UTF-8")

	  // send the email message
	  System.out.println("Starting send mail")
	  Transport.send(message)
	
	  //EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body")
	  System.out.println("Email Message Sent Successfully!")
	}
	catch (MessagingException e) {
		e.printStackTrace()
		System.out.println("Error send Email Message!")
		//throw new RuntimeException(e)	
	}