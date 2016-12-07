package com.workforce.contracts;

import com.workforce.models.UserModel;

public interface IParticipantRepository {
	
	public void RegisterParticipant(UserModel user);
	
	public UserModel GetParticipantDetailsByAccessToken(String accessToken);
	
	public boolean IsParticipantUser(UserModel user);
	
	public int GetParticipantIDByEmail(String email);
	
	public UserModel GetParticipantDetailsByEmail(String email);
}
