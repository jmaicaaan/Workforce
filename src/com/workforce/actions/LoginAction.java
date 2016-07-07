package com.workforce.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.UserModel;
import com.workforce.repositories.UserRepository;
import com.workforce.utility.DataInitialize;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserModel user = new UserModel();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		DataInitialize d = new DataInitialize();
		
		user.setEmail("jmsantos@yahoo.com");
		user.setPassword("jmsantos");
		UserRepository userRepository = new UserRepository();
		UserModel model = userRepository.Login(user);
		
		if(model != null){
			user = model;
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
}
