package com.workforce.utility;

import java.util.Arrays;

import javax.servlet.http.Cookie;

public class CookieHelper {
	
	public static Cookie setCookie(String cookieName, String cookieValue){
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(864000000); //10 days
		return cookie;
	}
	
	public static String getCookieValue(String cookieName, Cookie[] cookies){
		
		String cookieValue = Arrays.asList(cookies)
				.stream()
				.filter(i -> i.getName().equals(cookieName))
				.map(i -> i.getValue())
				.findAny()
				.orElse("Error 404: No cookies has found.");
		
		return cookieValue;
	}
}
