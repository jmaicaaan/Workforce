package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.CompanyModel;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.models.UserModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.repositories.ProgrammingLanguageRepository;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;

public class UpdateCompanyProfile extends ActionSupport implements ServletRequestAware {
	
	private UserModel user = new UserModel();
	private CompanyModel company = new CompanyModel();
	private ProgrammingLanguageModel programmingLanguageModel = new ProgrammingLanguageModel();
	private CompanyRepository _companyRepository = new CompanyRepository();
	private UserRepository _userRepository = new UserRepository();
	private ProgrammingLanguageRepository _programmingLanguageRepository = new ProgrammingLanguageRepository();
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		user = _userRepository.GetUserAccountTypeByAccessToken(accessToken);

		if(_companyRepository.IsCompanyUser(user)){
			
			int programmingLanguageID = _programmingLanguageRepository
					.GetIdByLanguage(programmingLanguageModel.getLanguage());

			company.setID(user.getCompanyModel().getID());
			programmingLanguageModel.setID(programmingLanguageID);
			company.setProgrammingLanguageModel(programmingLanguageModel);
			
			user.setCompanyModel(company);
			_userRepository.Update(user);
			
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	
	public void setProgrammingLanguageModel(ProgrammingLanguageModel programmingLanguageModel) {
		this.programmingLanguageModel = programmingLanguageModel;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
