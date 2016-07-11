package com.workforce.actions;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.CookieHelper;
import com.workforce.utility.IUser;

public class Login extends ActionSupport implements ServletResponseAware, IUser {
	
	private UserModel user = new UserModel();
	private HttpServletResponse response;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		UserRepository userRepository = new UserRepository();
		UserModel userModel = userRepository.Login(this.user);
		
		if(userModel != null){
			this.user = userRepository.UpdateUserToken(userModel);
			
			response.addCookie(CookieHelper
					.setCookie(IUser.userAccessTokenName, this.user.getAccessToken()));
			
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
