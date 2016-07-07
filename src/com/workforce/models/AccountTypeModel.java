package com.workforce.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "AccountType")
public class AccountTypeModel {

	public AccountTypeModel() {}

	public AccountTypeModel(String accountType){
		this.accountType = accountType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;

	@Column(name="AccountType")
	private String accountType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountTypeModel")
	private List<UserModel> userModel;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<UserModel> getUserModel() {
		return userModel;
	}

	public void setUserModel(List<UserModel> userModel) {
		this.userModel = userModel;
	}
}
