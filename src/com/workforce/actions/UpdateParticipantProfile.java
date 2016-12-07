package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.ParticipantModel;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.models.UserModel;
import com.workforce.repositories.ProgrammingLanguageRepository;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.IUser;

public class UpdateParticipantProfile extends ActionSupport implements ServletRequestAware, IUser {

	private UserModel user = new UserModel();
	private ParticipantModel participant = new ParticipantModel();
	private ProgrammingLanguageModel programmingLanguageModel = new ProgrammingLanguageModel();
	private UserRepository _userRepository = new UserRepository();
	private ProgrammingLanguageRepository _programmingLanguageRepository = new ProgrammingLanguageRepository();
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		int programmingLanguageID = _programmingLanguageRepository
					.GetIdByLanguage(programmingLanguageModel.getLanguage());
		
		
		user = _userRepository.GetUserAccountTypeByAccessToken(accessToken);
		
		participant.setID(user.getParticipantModel().getID());
		programmingLanguageModel.setID(programmingLanguageID);
		participant.setProgrammingLanguageModel(programmingLanguageModel);
		
		
		user.setParticipantModel(participant);
		_userRepository.Update(user);

		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public void setParticipant(ParticipantModel participant) {
		this.participant = participant;
	}
	
	public void setProgrammingLanguageModel(ProgrammingLanguageModel programmingLanguageModel) {
		this.programmingLanguageModel = programmingLanguageModel;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
}
