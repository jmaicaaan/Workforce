package com.workforce.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.ICompanyRepository;
import com.workforce.models.CompanyModel;
import com.workforce.models.UserModel;
import com.workforce.utility.IAccountTypes;

public class CompanyRepository extends CrudRepository<CompanyModel> implements ICompanyRepository, IAccountTypes{

	@Override
	public UserModel GetCompanyDetailsByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		UserModel userModel = new UserModel();
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			userModel = (UserModel) session.createQuery("from Users where accessToken = :accessToken")
						.setParameter("accessToken", accessToken)
						.uniqueResult();
			trans.commit();
			
			Hibernate.initialize(userModel.getAccountTypeModel());
			Hibernate.initialize(userModel.getCompanyModel());
			Hibernate.initialize(userModel.getCompanyModel().getProgrammingLanguageModel());
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
		return userModel;
	}
	
	@Override
	public UserModel GetCompanyParticipantsByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		UserModel userModel = new UserModel();
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			userModel = (UserModel) session.createQuery("from Users where accessToken = :accessToken")
					.setParameter("accessToken", accessToken)
					.uniqueResult();
			
			trans.commit();
			
			Hibernate.initialize(userModel.getAccountTypeModel());
			Hibernate.initialize(userModel.getCompanyModel());
			Hibernate.initialize(userModel.getCompanyModel().getProgrammingLanguageModel());
			Hibernate.initialize(userModel.getCompanyModel().getProgrammingLanguageModel().getParticipantModel());
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		return userModel;
	}
	
	@Override
	public boolean IsCompanyUser(UserModel user) {
		// TODO Auto-generated method stub
		return user.getAccountTypeModel().getType().equals(IAccountTypes.COMPANY) ? true : false;
	}
	
	@Override
	public int GetCompanyIDByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		int companyID = 0;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			companyID = (int) session.createSQLQuery("Select ID from Users where email = :email")
						.setParameter("email", email)
						.uniqueResult();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		
		return companyID;
	}
	
	@Override
	public UserModel GetCompanyDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		UserModel userModel = new UserModel();
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			userModel = (UserModel) session.createQuery("from Users where email = :email")
						.setParameter("email", email)
						.uniqueResult();
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
