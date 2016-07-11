package com.workforce.utility;

import java.util.UUID;

public class AccessTokenHelper {
	
	public static String generateAccessToken(){
		
		return UUID.randomUUID().toString();
	}
}
