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

@Entity(name="Workforce")
public class WorkforceModel {

	public WorkforceModel() {
		// TODO Auto-generated constructor stub
		this.timestamp = LocalDateTime.now().toString();
	}
	
	public WorkforceModel(ParticipantModel participant, CompanyModel company) {
		// TODO Auto-generated constructor stub
		this.participant = participant;
		this.company = company;
		this.timestamp = LocalDateTime.now().toString();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ParticipantID")
	private ParticipantModel participant;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="CompanyID")
	private CompanyModel company;
	
	@Column(name="Timestamp")
	private String timestamp;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ParticipantModel getParticipant() {
		return participant;
	}

	public void setParticipant(ParticipantModel participant) {
		this.participant = participant;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
