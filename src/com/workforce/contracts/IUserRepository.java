package com.workforce.contracts;

import com.workforce.models.UserModel;

public interface IUserRepository {
	
	public UserModel Login(UserModel user);
}
