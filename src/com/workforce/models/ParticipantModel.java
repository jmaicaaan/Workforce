package com.workforce.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name="Participant")
public class ParticipantModel {

	public ParticipantModel() {}

	public ParticipantModel(String firstname, String lastname, String imageURL, 
			String location, ProgrammingLanguageModel language){

		this.firstname = firstname;
		this.lastname = lastname;
		this.imageURL = imageURL;
		this.location = location;
		this.programmingLanguageModel = language;
	}

	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters = @Parameter(name = "property", value = "userModel"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="ID", unique = true, nullable = false)
	private int ID;

	@Column(name="Firstname")
	private String firstname;

	@Column(name="Lastname")
	private String lastname;

	@Column(name="ImageURL", nullable = true)
	private String imageURL;

	@Column(name="Location")
	private String location;

	@ManyToOne
	@JoinColumn(name="ProgrammingLanguageID")
	private ProgrammingLanguageModel programmingLanguageModel;

	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UserModel userModel;

	@OneToMany(fetch = FetchType.LAZY,  mappedBy="participant")
	private List<WorkforceModel> workforceModel;


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public ProgrammingLanguageModel getProgrammingLanguageModel() {
		return programmingLanguageModel;
	}

	public void setProgrammingLanguageModel(ProgrammingLanguageModel programmingLanguageModel) {
		this.programmingLanguageModel = programmingLanguageModel;
	}

	public List<WorkforceModel> getWorkforceModel() {
		return workforceModel;
	}

	public void setWorkforceModel(List<WorkforceModel> workforceModel) {
		this.workforceModel = workforceModel;
	}
}
