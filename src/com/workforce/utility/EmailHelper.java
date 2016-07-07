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
							EmailConfig.getSystemEmailAddress(), EmailConfig.getSystemEmailPassword());
				}
			});

			try{
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(EmailConfig.getSystemEmailAddress(), "Workforce"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(participantEmail));
				message.setSubject("");
				message.setText("");

				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", EmailConfig.getSystemEmailAddress(), EmailConfig.getSystemEmailPassword());

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

