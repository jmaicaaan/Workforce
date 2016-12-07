package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.CompanyModel;
import com.workforce.models.ParticipantModel;
import com.workforce.models.UserModel;
import com.workforce.models.WorkforceModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.repositories.ParticipantRepository;
import com.workforce.repositories.WorkforceRepository;
import com.workforce.utility.EmailHelper;

/**
 * @author johnm767
 *
 */
public class SendEmail extends ActionSupport implements ServletRequestAware{
	
	private ParticipantModel participant = new ParticipantModel();
	private CompanyModel company = new CompanyModel();
	private HttpServletRequest request;
	private WorkforceRepository _workforceRepository = new WorkforceRepository();
	private ParticipantRepository _participantRepository = new ParticipantRepository();
	private CompanyRepository _companyRepository = new CompanyRepository();
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		//EmailHelper.sendParticipantEmail(user.getEmail());
		UserModel participantUserModel = _participantRepository.GetParticipantDetailsByEmail(participant.getUserModel().getEmail());
		UserModel companyUserModel = _companyRepository.GetCompanyDetailsByEmail(company.getEmail());
		
		participant = participantUserModel.getParticipantModel();
		company = companyUserModel.getCompanyModel();
		
		WorkforceModel workforceModel = new WorkforceModel(participant, company);
		_workforceRepository.Insert(workforceModel);
		
		return SUCCESS;
	}
	
	public void setParticipant(ParticipantModel participant) {
		this.participant = participant;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;		
	}
	
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
}
