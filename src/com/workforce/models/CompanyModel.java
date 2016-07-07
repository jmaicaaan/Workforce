package com.workforce.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name="Company")
public class CompanyModel {

	public CompanyModel() {}

	public CompanyModel(String name, String email, String imageURL, String description, 
			String location, String website, ProgrammingLanguageModel language){

		this.name = name;
		this.email = email;
		this.imageURL = imageURL;
		this.description = description;
		this.location = location;
		this.website = website;
		this.programmingLanguageModel = language;
	}


	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters = @Parameter(name = "property", value = "userModel"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="ID", unique = true, nullable = false)
	private int ID;	

	@Column(name="Name")
	private String name;

	@Column(name="Email")
	private String email;

	@Column(name="ImageURL")
	private String imageURL;

	@Column(name="Description")
	private String description;

	@Column(name="Location")
	private String location;

	@Column(name="Website")
	private String website;

	@ManyToOne
	@JoinColumn(name="ProgrammingLanguageID")
	private ProgrammingLanguageModel programmingLanguageModel;

	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UserModel userModel;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public ProgrammingLanguageModel getProgrammingLanguageModel() {
		return programmingLanguageModel;
	}

	public void setProgrammingLanguageModel(ProgrammingLanguageModel programmingLanguageModel) {
		this.programmingLanguageModel = programmingLanguageModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
