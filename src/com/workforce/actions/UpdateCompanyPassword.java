package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.SecurityHelper;

public class UpdateCompanyPassword extends ActionSupport implements ServletRequestAware{
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	private CompanyRepository _companyRepository = new CompanyRepository();
	private UserRepository _userRepository = new UserRepository();
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		UserModel userModel = _userRepository.GetUserAccountTypeByAccessToken(accessToken);
		
		if(_companyRepository.IsCompanyUser(userModel)){
			
			userModel.setPassword(SecurityHelper.encrypt(user.getPassword()));
			userModel.setHasTemporaryPassword(false);
			user = userModel;
			_userRepository.Update(user);
			
			return SUCCESS;
		}
		return INPUT;
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
