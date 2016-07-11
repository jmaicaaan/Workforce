package com.workforce.contracts;

import com.workforce.models.UserModel;

public interface IUserRepository {
	
	public UserModel Login(UserModel user);
	
	public void RegisterParticipant(UserModel user);
	
	public UserModel UpdateUserToken(UserModel user);
	
	public boolean HasDuplicateUser(UserModel user);
	
	public UserModel GetDashboardUserDetails(UserModel user);	
	
}
