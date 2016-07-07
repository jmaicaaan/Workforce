package com.workforce.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IUserRepository;
import com.workforce.models.UserModel;
import com.workforce.utility.HibernateFactory;

public class UserRepository implements IUserRepository {

	@Override
	public UserModel Login(UserModel user){
		
		Session session = null;
		Transaction trans = null;
		UserModel userModel = new UserModel();

		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();

			userModel = (UserModel) session.createQuery("from Users where email = :email and password = :password")
					.setString("email", user.getEmail())
					.setString("password", user.getPassword())
					.uniqueResult();
			Hibernate.initialize(userModel.getAccountTypeModel());
			
			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
		} finally {
			session.close();
		}

		return userModel;
	}
}
