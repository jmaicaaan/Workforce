package com.workforce.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.AccountTypeModel;
import com.workforce.models.ParticipantModel;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccountTypeHelper;
import com.workforce.utility.ProgrammingLanguageHelper;

public class RegisterParticipant extends ActionSupport{
	
	private UserModel user = new UserModel();
	private ProgrammingLanguageModel pl = new ProgrammingLanguageModel();
	private ParticipantModel participant = new ParticipantModel();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		try {
			
			ProgrammingLanguageModel pModel = ProgrammingLanguageHelper
					.getProgrammingLanguageByID(pl.getLanguage());
			
			AccountTypeModel acModel = AccountTypeHelper
					.getAccountTypeByName(AccountTypeHelper.PARTICIPANT);
			
			UserModel uModel = new UserModel(user.getEmail(), user.getPassword(), false, null, false, acModel);
			uModel.setParticipantModel(participant);
			
			participant.setProgrammingLanguageModel(pModel);
			participant.setUserModel(uModel);
			
			UserRepository userRepository = new UserRepository();
			userRepository.RegisterParticipant(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	public ProgrammingLanguageModel getPl() {
		return pl;
	}

	public void setPl(ProgrammingLanguageModel pl) {
		this.pl = pl;
	}

	public ParticipantModel getParticipant() {
		return participant;
	}

	public void setParticipant(ParticipantModel participant) {
		this.participant = participant;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
}
