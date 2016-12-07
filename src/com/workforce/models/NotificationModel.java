package com.workforce.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Notification")
public class NotificationModel {
	
	public NotificationModel() {
		// TODO Auto-generated constructor stub
		this.timestamp = LocalDateTime.now().toString();
	}
	
	public NotificationModel(String message, boolean isRead, UserModel user){
		this.message = message;
		this.isRead = isRead;
		this.user = user;
		this.timestamp = LocalDateTime.now().toString();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int notificationID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UserID")
	private UserModel user;
	
	@Column(name="Message")
	private String message;
	
	@Column(name="IsRead")
	private boolean isRead;
	
	@Column(name="Timestamp")
	private String timestamp;

	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
