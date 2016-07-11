package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.CookieHelper;
import com.workforce.utility.IUser;
import com.workforce.utility.SecurityHelper;

public class GetDashboardUserDetails extends ActionSupport implements ServletRequestAware, IUser {
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String accessToken = CookieHelper
				.getCookieValue(IUser.userAccessTokenName, request.getCookies());
		
		UserModel userModel = new UserModel();
		userModel.setAccessToken(accessToken);
		
		UserRepository userRepository = new UserRepository();
		userModel = userRepository.GetDashboardUserDetails(this.user);
		
		this.user = userModel;
		
		return SUCCESS;
	}

	public UserModel getUser() {
		return user;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
