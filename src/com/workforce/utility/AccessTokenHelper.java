package com.workforce.utility;

import java.util.UUID;

import javax.servlet.http.Cookie;

import com.workforce.models.UserModel;

public class AccessTokenHelper implements IUser{
	
	public static String generateAccessToken(){
		
		return UUID.randomUUID().toString();
	}
	
	public static String getAccessToken(Cookie[] cookies, UserModel user){
		String accessToken = "";
		
		try {

			if(cookies == null || cookies.length < 0)
				accessToken = user.getAccessToken();
			else{
				String cookie_accessToken = CookieHelper.getCookieValue(IUser.userAccessTokenName, cookies);
				if(cookie_accessToken == "")
					accessToken = user.getAccessToken();
				accessToken = cookie_accessToken;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Unable to get AccessToken");
		}
		
		return accessToken;
	}
}
