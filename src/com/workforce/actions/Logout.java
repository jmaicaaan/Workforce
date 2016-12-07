package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;

public class Logout extends ActionSupport implements ServletRequestAware{
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	private UserRepository _userRepository = new UserRepository();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		user = _userRepository.GetUserAccountTypeByAccessToken(accessToken);
		user.setAccessToken(null);
		
		_userRepository.Update(user);
		
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
}
