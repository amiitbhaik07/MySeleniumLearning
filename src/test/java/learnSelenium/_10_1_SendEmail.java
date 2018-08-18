package learnSelenium;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class _10_1_SendEmail
{

	public static void main(String[] args) throws Exception 
	{		
		System.out.println("Launching Browser");
		emailNotification();	
	}
	
	
	public static String getMessage() throws Exception
	{
		String messageBody="Test";	
		return messageBody;
	}
	
	
	public static void emailNotification() throws Exception 
	{
        String mailFrom = "pbhopi@cisco.com";
        String mailTo_csv = "abhaik@cisco.com";
        String[] mailTo = mailTo_csv.split(",");
        String mailCc_csv = "pbhopi@cisco.com";
        String[] mailCc = mailCc_csv.split(",");
        String mailSubject = "Now Sweets at my desk :)";
        String emailHost = "javamail.cisco.com";
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", emailHost);
        Session session = Session.getDefaultInstance((Properties)properties);
        try 
        {
        	//New Message
            MimeMessage mimeMessage = new MimeMessage(session);
            
            //Set Message From
            mimeMessage.setFrom((Address)new InternetAddress(mailFrom));
            
            //Set Message To
            InternetAddress[] addressTo = new InternetAddress[mailTo.length];
            int i = 0;
            while (i < mailTo.length) 
            {
                addressTo[i] = new InternetAddress(mailTo[i]);
                ++i;
            }
            mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])addressTo);
            
            //Set Message Cc
            InternetAddress[] addressCc = new InternetAddress[mailCc.length];
            int j = 0;
            while (j < mailCc.length) 
            {
                addressCc[j] = new InternetAddress(mailCc[j]);
                ++j;
            }
            mimeMessage.setRecipients(Message.RecipientType.CC, (Address[])addressCc);
            
            //Set Subject
            mimeMessage.setSubject(mailSubject);
            
            //Create MimeBodyPart and Attach File in this part
           /* MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
            DataSource source = new FileDataSource("C:\\TimeSheetAutomation\\TimesheetDefaulters\\TimeSheetDefaulters_22_4_2016.xlsx");
            mimeBodyPart1.setDataHandler(new DataHandler(source));
            mimeBodyPart1.setFileName("Defaulters_22ndApril.xlsx");*/
            
            //Create MimeBodyPart and add attachment in this part
           /* MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.attachFile("C:\\TimeSheetAutomation\\TimesheetDefaulters\\TimeSheetDefaulters_22_4_2016.xlsx");*/
            
            //Create MimeBodyPart and add some text into this part
            MimeBodyPart mimeBodyPart3 = new MimeBodyPart();
            //mimeBodyPart3.setContent(getMessage(),"text/html");
            mimeBodyPart3.setContent(mailSubject,"text/html");

            //Create Multipart and add All the Body Parts
            Multipart multipart = new MimeMultipart();
            //multipart.addBodyPart(mimeBodyPart1);  
            //multipart.addBodyPart(mimeBodyPart2);
            multipart.addBodyPart(mimeBodyPart3);
            
            //Set Content of Message as Multipart
            mimeMessage.setContent(multipart);
            
            System.out.println("Sending Message......");
            Transport.send((Message)mimeMessage);
            System.out.println("Message Sent Successfully....");
        }
        catch (MessagingException e) {
            System.out.println("Please Check the Email Notification Function");
            e.printStackTrace();
        }
	
	}
	
	
	
	
	
	
	

	

}
