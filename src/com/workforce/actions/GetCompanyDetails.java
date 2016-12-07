package com.workforce.actions;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.IUser;

public class GetCompanyDetails extends ActionSupport implements ServletRequestAware, IUser {
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	private CompanyRepository _companyRepository = new CompanyRepository();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
 		
		user = _companyRepository.GetCompanyDetailsByAccessToken(accessToken);
		user.getCompanyModel().getWorkforceModel();
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
