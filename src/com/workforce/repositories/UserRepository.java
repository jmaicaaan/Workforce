package com.workforce.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IUserRepository;
import com.workforce.models.UserModel;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.HibernateFactory;
import com.workforce.utility.SecurityHelper;

public class UserRepository implements IUserRepository {

	@Override
	public UserModel Login(UserModel user){
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;

		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();

			userModel = (UserModel) session.createQuery("from Users where email = :email and password = :password")
					.setString("email", user.getEmail())
					.setString("password", SecurityHelper.encrypt(user.getPassword()))
					.uniqueResult();
		
			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
		}

		session.close();
		return userModel;
	}
	
	@Override
	public void RegisterParticipant(UserModel user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		
		try {
			
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public UserModel UpdateUserToken(UserModel user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;
		
		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();
			
			userModel = (UserModel) session.get(UserModel.class, user.getID());
			userModel.setAccessToken(AccessTokenHelper.generateAccessToken());
			
			session.update(userModel);
			
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		return userModel;
	}
	
	@Override
	public boolean HasDuplicateUser(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public UserModel GetDashboardUserDetails(UserModel user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;
		
		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();
			
			userModel = (UserModel) session.createQuery("from Users where accessToken = :accessToken")
						.setParameter("accessToken", user.getAccessToken())
						.uniqueResult();
			
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		return userModel;
	}
}
