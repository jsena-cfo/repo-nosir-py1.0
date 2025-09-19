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

String titulo= this.getBinding().getAt('varTitulo').toString()
String emailFrom= this.getBinding().getAt('varEmailFrom').toString()
String pass= this.getBinding().getAt('varPass').toString()
List destinatarios= this.getBinding().getAt('varDestinatarios') as List
String asunto= this.getBinding().getAt('varAsunto').toString()
String body= this.getBinding().getAt('varBodyMail').toString()

System.out.println("Password email: " + pass)

String addresser= emailFrom
String subject= asunto
String to= "jsena@cfotechlatam.com"
//String cc
//String bcc
String content= body
String mimeType= 'text/html;charset=utf-8'

// Init constants of sender email account.
String email = emailFrom
String password = pass
String host = "smtp.office365.com" // e.g. -> "smtp.google.com"
String port = "587" // e.g. -> "465" "587"

// Set up properties.
Properties props = System.getProperties()
props.put("mail.smtp.user", email)
props.put("mail.smtp.host", host)
props.put("mail.smtp.port", port)
props.put("mail.smtp.starttls.enable","true")
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
props.put("mail.smtp.ssl.trust", host) // Change host to "*" if you want to trust all host.

// Set up message.
MimeMessage message = new MimeMessage(Session.getDefaultInstance(props))
message.setFrom(new InternetAddress(addresser))
message.addRecipients(Message.RecipientType.TO, new InternetAddress(to))
//message.addRecipients(Message.RecipientType.CC, new InternetAddress(cc))
//message.addRecipients(Message.RecipientType.CC, new InternetAddress(bcc))
message.setSubject(subject)
message.setContent(content, mimeType)

try {
	// Send mail.
	Transport.send(message, email, password)
} catch (MessagingException e) {
	e.printStackTrace()
}
