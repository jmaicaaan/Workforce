package com.workforce.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IParticipantRepository;
import com.workforce.models.ParticipantModel;
import com.workforce.models.UserModel;
import com.workforce.utility.IAccountTypes;

public class ParticipantRepository extends CrudRepository<ParticipantModel> implements IParticipantRepository, IAccountTypes {
	
	@Override
	public void RegisterParticipant(UserModel user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction trans = null;
		
		try {
			
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
	}
	
	@Override
	public UserModel GetParticipantDetailsByAccessToken(String accessToken) {
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
			Hibernate.initialize(userModel.getParticipantModel());
			Hibernate.initialize(userModel.getParticipantModel().getProgrammingLanguageModel());
			Hibernate.initialize(userModel.getNotificationModel());
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
		}
		
		session.close();
		return userModel;
	}
	
	@Override
	public boolean IsParticipantUser(UserModel user) {
		// TODO Auto-generated method stub
		return user.getAccountTypeModel().getType().equals(IAccountTypes.PARTICIPANT) ? true : false;
	}
	
	@Override
	public int GetParticipantIDByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		int participantID = 0;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			participantID = (int) session.createSQLQuery("Select ID from Users where email = :email")
					.setParameter("email", email)
					.uniqueResult();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		return participantID;
	}
	
	@Override
	public UserModel GetParticipantDetailsByEmail(String email) {
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
		}
		
		session.close();
		return userModel;
	}
}
