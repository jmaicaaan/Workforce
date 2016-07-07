package com.workforce.utility;

import java.util.List;

import org.hibernate.Session;

import com.workforce.models.AccountTypeModel;
import com.workforce.models.CompanyModel;
import com.workforce.models.ParticipantModel;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.models.UserModel;

public class DataInitialize {
	
	public DataInitialize() {
		// TODO Auto-generated constructor stub
		
//		loadParticipants();
		loadCompanies();
	
	}
	
	private void loadAccountTypes(){
		String[] accountTypes = {"Admin", "Participant", "Company"};
		
		
		for(String ac : accountTypes){
			Session session = HibernateFactory.getSession().openSession();
			session.beginTransaction();
			AccountTypeModel accc = new AccountTypeModel(ac);
			session.save(accc);
			session.getTransaction().commit();
		}
		
	}
	
	private void loadProgrammingLanguages(){
		String[] programmingLanguages = {"Java", "C#", "Ruby", "Python", "PHP"};
		for(String pl : programmingLanguages){
			Session session = HibernateFactory.getSession().openSession();
			session.beginTransaction();
			ProgrammingLanguageModel accc = new ProgrammingLanguageModel(pl);
			session.save(accc);
			session.getTransaction().commit();
		}
		
	}
	
	private void loadParticipants(){
		Session session = HibernateFactory.getSession().openSession();
		session.beginTransaction();
		
		//Hard coded
		ProgrammingLanguageModel pl = new ProgrammingLanguageModel();
		pl.setID(1);
		AccountTypeModel ac = new AccountTypeModel();
		ac.setID(2);
		
		ParticipantModel part = new ParticipantModel("Jm", "Santos", null, null, false, pl);
		UserModel user = new UserModel("jmsantos@yahoo.com", "jmsantos", false, null, false, ac);
		
		user.setParticipantModel(part);
		part.setUserModel(user);
		
		
		session.save(user);
		session.getTransaction().commit();
	}
	
	private void loadCompanies(){
		
		AccountTypeModel ac = new AccountTypeModel();
		ac.setID(3);
		
		Session session = HibernateFactory.getSession().openSession();
		session.beginTransaction();
		List<CompanyModel> list = (List<CompanyModel>) ResourceHelper.getJsonList("companies");
		list.forEach(i -> {
			CompanyModel comp = new CompanyModel(i.getName(), i.getEmail(), i.getImageURL(), null, null, i.getWebsite(), null);
			UserModel user = new UserModel(i.getEmail(), null, false, null, true, ac);
			
			user.setCompanyModel(comp);
			comp.setUserModel(user);
			
			session.save(user);
			session.getTransaction().commit();
		});
		
		session.close();
	}
}
