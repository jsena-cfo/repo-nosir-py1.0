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

/**Script envio mail**/
	String titulo= this.getBinding().getAt('varTitulo').toString()
	String emailFrom= this.getBinding().getAt('varEmailFrom').toString()
	String pass= this.getBinding().getAt('varPass').toString()
	List destinatarios= this.getBinding().getAt('varDestinatarios') as List
	String asunto= this.getBinding().getAt('varAsunto').toString()
	String body= this.getBinding().getAt('varBodyMail').toString()
	
	// provide recipient's email ID
	//String to = "jsenat@cfotechlatam.com"
	// provide sender's email ID
	String from = emailFrom

	// provide Mailtrap's username
	final String username
	//username = "QA Automation CFOTech"
	//username= "Klona Auto"
	username= emailFrom
	final String password = pass

	// provide Mailtrap's host address
	String host 
	host= varHost //smtp.office365.com
	//host = "smtp.gmail.com"

	// configure Mailtrap's SMTP details
	Properties props = new Properties()
	props.put("mail.smtp.auth", "true")
	props.put("mail.smtp.starttls.enable", "true")
	props.put("mail.smtp.host", host)
	props.put("mail.smtp.port", varPort)

	// create the Session object
	Session session = Session.getInstance(props,
		new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, pass)
			}
		})

	try {
		// create a MimeMessage object
		Message message = new MimeMessage(session)
		// set From email field
		message.setFrom(new InternetAddress(from))
		// set To email field
		//message.setRecipient(Message.RecipientType.TO, new InternetAddress(to))
		// set email subject field
		//message.setSubject("Hello from the Mailtrap team")
		// set the content of the email message
		//message.setText("Enjoy sending emails from Jakarta Mail!")
		
		destinatarios.each { to -> message.addRecipient(Message.RecipientType.TO, new InternetAddress(to))}
		message.setSubject(asunto)
		message.setContent(body,"text/html;charset=UTF-8")

		// send the email message
		Transport.send(message)

		System.out.println("Email Message Sent Successfully!")
	} 
	catch (MessagingException e) {
		e.printStackTrace()
		System.out.println("Error send Email Message!")
		//throw new RuntimeException(e)
	}
