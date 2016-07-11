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

	public AccountTypeModel(String type){
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;

	@Column(name="Type")
	private String type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountTypeModel")
	private List<UserModel> userModel;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<UserModel> getUserModel() {
		return userModel;
	}

	public void setUserModel(List<UserModel> userModel) {
		this.userModel = userModel;
	}
}
