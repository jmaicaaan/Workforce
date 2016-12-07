package com.workforce.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHelper {

	public static void sendParticipantEmail(String participantEmail){
		
		try{
			
			final Properties emailProperties = EmailConfig.emailProperties();

			Session session = Session.getInstance(emailProperties,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
							emailProperties.getProperty("mail.smtp.user"), 
							emailProperties.getProperty("mail.smtp.password"));
				}
			});

			try{
				MimeMessage message = new MimeMessage(session);
				
				message.setFrom(new InternetAddress(emailProperties.getProperty("mail.smtp.user"), 
						ResourceHelper.getPropertyValue("defaults", "appName")));
				
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(participantEmail));
				message.setSubject("");
				message.setText("");

				Transport transport = session.getTransport("smtp");
				transport.connect(emailProperties.getProperty("mail.smtp.host"), emailProperties.getProperty("mail.smtp.user"), 
						emailProperties.getProperty("mail.smtp.password"));

				message.saveChanges();
				Transport.send(message);
				transport.close();

			}catch(MessagingException e){
				throw new RuntimeException(e);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

