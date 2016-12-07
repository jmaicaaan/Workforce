package com.workforce.actions;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.CookieHelper;
import com.workforce.utility.IUser;

public class Login extends ActionSupport implements ServletResponseAware, IUser {
	
	private UserModel user = new UserModel();
	private HttpServletResponse response;
	private UserRepository _userRepository = new UserRepository();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		UserModel userModel = _userRepository.Login(user);
		
		if(userModel != null){
			userModel.setAccessToken(AccessTokenHelper.generateAccessToken());
			userModel.setHasAccessToken(true);
			user = userModel;
			_userRepository.Update(user);
			
			response.addCookie(CookieHelper
					.setCookie(IUser.userAccessTokenName, user.getAccessToken()));
			
			return SUCCESS;
		}
		return INPUT;
	}
	
	public UserModel getUser() {
		return user;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
}
