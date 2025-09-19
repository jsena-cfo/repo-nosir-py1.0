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
	
	System.out.println("Password email: " + pass)

    Properties props = new Properties()
	props.setProperty("mail.smtp.host", varHost)
    props.setProperty("mail.smtp.port", varPort)
    props.setProperty("mail.smtp.auth", "true")
    props.setProperty("mail.smtp.starttls.enable", "true")
    props.setProperty("mail.smtp.connectiontimeout", varTimeout)
    props.setProperty("mail.smtp.timeout", varTimeout)
    props.setProperty("mail.smtp.writetimeout", varTimeout)
    props.setProperty("mail.debug", "true")
	

	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		//Session session = Session.getInstance(properties, new Authenticator() {
	    @Override
		protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(emailFrom, pass)
        }
	})
    try {
        MimeMessage message = new MimeMessage(session)
        //message.setFrom(new InternetAddress(from))
		message.setFrom(new InternetAddress(emailFrom, titulo))
		// message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario))
		destinatarios.each { to -> message.addRecipient(Message.RecipientType.TO, new InternetAddress(to))}         
        message.setSubject(asunto)
        message.setContent(body,"text/html;charset=UTF-8")

        Transport.send(message)
        println("Correo enviado exitosamente...")
    } catch (MessagingException mex) {
        mex.printStackTrace()
        println("No se pudo enviar el correo.")
    }
