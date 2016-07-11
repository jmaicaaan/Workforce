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
		
		loadParticipants();
		loadCompanies();
//		loadAccountTypes();
//		loadProgrammingLanguages();
	
	}
	
	private void loadAccountTypes(){
		String[] accountTypes = {AccountTypeHelper.ADMIN, 
				AccountTypeHelper.PARTICIPANT, AccountTypeHelper.COMPANY};
		
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
		ProgrammingLanguageModel pl = ProgrammingLanguageHelper.getProgrammingLanguageByID("Java");
		AccountTypeModel ac = AccountTypeHelper.getAccountTypeByName(AccountTypeHelper.PARTICIPANT);
		System.out.println(ac.getID());
		ParticipantModel part = new ParticipantModel("Jm", "Santos", null, null, false, pl);
		UserModel user = new UserModel("jmsantos@yahoo.com", SecurityHelper.encrypt("jmsantos"), false, null, false, ac);
		
		user.setParticipantModel(part);
		part.setUserModel(user);
		
		
		session.save(user);
		session.getTransaction().commit();
	}
	
	private void loadCompanies(){
		
		AccountTypeModel ac = new AccountTypeModel();
		ac.setID(3);
		
		List<CompanyModel> list = (List<CompanyModel>) ResourceHelper.getJsonList("companies");
		list.forEach(i -> {
			Session session = HibernateFactory.getSession().openSession();
			session.beginTransaction();
			
			CompanyModel comp = new CompanyModel(i.getName(), i.getEmail(), i.getImageURL(), null, null, i.getWebsite(), null);
			UserModel user = new UserModel(i.getEmail(), SecurityHelper.getDefaultPassword(), false, null, true, ac);
			
			user.setCompanyModel(comp);
			comp.setUserModel(user);
			
			session.save(user);
			session.getTransaction().commit();
			session.close();
		});
	}
}
