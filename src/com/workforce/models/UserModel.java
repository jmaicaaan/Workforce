package com.workforce.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="Users")
public class UserModel {

	public UserModel() {}

	public UserModel(String email, String password, boolean hasAccessToken, 
			String accessToken, boolean hasTemporaryPassword, AccountTypeModel accountType){
		
		this.email = email;
		this.password = password;
		this.hasAccessToken = hasAccessToken;
		this.accessToken = accessToken;
		this.timestamp = LocalDateTime.now().toString();
		this.hasTemporaryPassword = hasTemporaryPassword;
		this.accountTypeModel = accountType;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;

	@Column(name="Email")
	private String email;

	@Column(name="Password")
	private String password;

	@Column(name="HasAccessToken")
	private boolean hasAccessToken;

	@Column(name="AccessToken", nullable = true)
	private String accessToken;

	@Column(name="Timestamp")
	private String timestamp;
	
	@Column(name="HasTemporaryPassword")
	private boolean hasTemporaryPassword;

	@OneToOne(mappedBy="userModel", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ParticipantModel participantModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AccountTypeID")
	private AccountTypeModel accountTypeModel;

	@OneToOne(mappedBy="userModel", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private CompanyModel companyModel;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public ParticipantModel getParticipantModel() {
		return participantModel;
	}

	public void setParticipantModel(ParticipantModel participantModel) {
		this.participantModel = participantModel;
	}

	public AccountTypeModel getAccountTypeModel() {
		return accountTypeModel;
	}

	public void setAccountTypeModel(AccountTypeModel accountTypeModel) {
		this.accountTypeModel = accountTypeModel;
	}

	public boolean isHasAccessToken() {
		return hasAccessToken;
	}

	public void setHasAccessToken(boolean hasAccessToken) {
		this.hasAccessToken = hasAccessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}

	public boolean isHasTemporaryPassword() {
		return hasTemporaryPassword;
	}

	public void setHasTemporaryPassword(boolean hasTemporaryPassword) {
		this.hasTemporaryPassword = hasTemporaryPassword;
	}
}
