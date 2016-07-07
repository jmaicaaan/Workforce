package com.workforce.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="ProgrammingLanguage")
public class ProgrammingLanguageModel {

	public ProgrammingLanguageModel(){}

	public ProgrammingLanguageModel(String language){
		this.language = language;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;

	@Column(name="Language")
	private String language;

	@OneToMany(mappedBy="programmingLanguageModel", fetch = FetchType.LAZY)
	private List<ParticipantModel> participantModel;

	@OneToMany(mappedBy="programmingLanguageModel", fetch = FetchType.LAZY)
	private List<CompanyModel> companyModel;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<ParticipantModel> getParticipantModel() {
		return participantModel;
	}

	public void setParticipantModel(List<ParticipantModel> participantModel) {
		this.participantModel = participantModel;
	}

	public List<CompanyModel> getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(List<CompanyModel> companyModel) {
		this.companyModel = companyModel;
	}


}
