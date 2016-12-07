package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.utility.AccessTokenHelper;

public class GetCompanyParticipants extends ActionSupport implements ServletRequestAware{
	
	private UserModel user = new UserModel();	
	private CompanyRepository _companyRepository = new CompanyRepository();
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		
		user = _companyRepository.GetCompanyParticipantsByAccessToken(accessToken);
		
		return SUCCESS;
	}
	
	public UserModel getUser() {
		return user;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
