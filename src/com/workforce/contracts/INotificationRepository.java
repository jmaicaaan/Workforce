package com.workforce.contracts;

import java.util.List;

import com.workforce.models.NotificationModel;
import com.workforce.models.UserModel;

public interface INotificationRepository {
	
	public List<NotificationModel> GetNotificationByUser(UserModel user);
}
