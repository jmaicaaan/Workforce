package com.workforce.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.INotificationRepository;
import com.workforce.models.NotificationModel;
import com.workforce.models.UserModel;

public class NotificationRepository extends CrudRepository<NotificationModel> implements INotificationRepository {
	
	@Override
	public List<NotificationModel> GetNotificationByUser(UserModel user) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		List<NotificationModel> list = new ArrayList<NotificationModel>();

		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			list = session.createQuery("from Notification where UserID = :userID")
						.setParameter("userID", user.getID())
						.list();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
		}
		session.close();
		return list;
	}
}
