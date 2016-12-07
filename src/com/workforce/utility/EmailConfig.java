package com.workforce.utility;

import java.util.Properties;

public class EmailConfig {

	private static String getSystemEmailAddress(){
		return ResourceHelper.getPropertyValue("email", "systemEmailAddress");
	}
	private static String getSystemEmailPassword(){
		return ResourceHelper.getPropertyValue("email", "systemEmailPassword");
	}
	private static String getSystemEmailHost(){
		return ResourceHelper.getPropertyValue("email", "systemEmailHost");
	}
	private static String getSystemEmailPort(){
		return ResourceHelper.getPropertyValue("email", "systemEmailPort");
	}
	
	public static Properties emailProperties(){
		
		Properties emailProperties = new Properties();	
		
		emailProperties.put("mail.smtp.starttls.enable", "true");
		emailProperties.put("mail.smtp.host", getSystemEmailHost());
		emailProperties.put("mail.smtp.port", getSystemEmailPort());
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.debug", "true");
		emailProperties.put("mail.smtp.user", getSystemEmailAddress());
		emailProperties.put("mail.smtp.password", getSystemEmailPassword());
		
		return emailProperties;
	}
}
