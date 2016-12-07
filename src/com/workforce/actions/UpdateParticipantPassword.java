package com.workforce.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.ParticipantRepository;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.IUser;
import com.workforce.utility.SecurityHelper;

public class UpdateParticipantPassword extends ActionSupport implements IUser, ServletRequestAware{
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	private ParticipantRepository _participantRepository = new ParticipantRepository();
	private UserRepository _userRepository = new UserRepository();
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
		UserModel userModel = _userRepository.GetUserAccountTypeByAccessToken(accessToken);
		
		try {
			if(_participantRepository.IsParticipantUser(userModel)){
				
				userModel.setPassword(SecurityHelper.encrypt(user.getPassword()));
				userModel.setHasTemporaryPassword(false);
				_userRepository.Update(userModel);
				
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
