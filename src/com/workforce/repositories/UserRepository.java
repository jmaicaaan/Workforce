package com.workforce.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IUserRepository;
import com.workforce.models.UserModel;
import com.workforce.utility.AccessTokenHelper;
import com.workforce.utility.SecurityHelper;

public class UserRepository extends CrudRepository<UserModel> implements IUserRepository{

	@Override
	public UserModel Login(UserModel user){
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;

		try {
			session = BaseRepository.getSession().openSession();
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
		
		Hibernate.initialize(userModel.getAccountTypeModel());
		Hibernate.initialize(userModel.getAccessToken());
		
		session.close();
		return userModel;
	}
	
	@Override
	public UserModel UpdateUserToken(UserModel user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;
		
		try {
			session = BaseRepository.getSession().openSession();
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
		
		Hibernate.initialize(userModel);
		Hibernate.initialize(userModel.getAccessToken());
		Hibernate.initialize(userModel.getAccountTypeModel());
		
		session.close();
		return userModel;
	}
	
	@Override
	public UserModel GetUserAccountTypeByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = null;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			userModel = (UserModel) session.createQuery("from Users where accessToken = :accessToken")
						.setParameter("accessToken", accessToken)
						.uniqueResult();
			
			Hibernate.initialize(userModel);
			Hibernate.initialize(userModel.getAccountTypeModel());
			
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		
		
		session.close();
		return userModel;
	}

}
