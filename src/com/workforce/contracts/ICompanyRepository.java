package com.workforce.contracts;

import com.workforce.models.UserModel;

public interface ICompanyRepository {
	
	public UserModel GetCompanyDetailsByAccessToken(String accessToken);
	
	public UserModel GetCompanyParticipantsByAccessToken(String accessToken);
	
	public boolean IsCompanyUser(UserModel user);
	
	public int GetCompanyIDByEmail(String email);
	
	public UserModel GetCompanyDetailsByEmail(String email);
}
