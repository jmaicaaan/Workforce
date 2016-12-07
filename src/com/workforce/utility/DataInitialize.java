package com.workforce.utility;

import java.util.List;

import org.hibernate.Session;

import com.workforce.models.AccountTypeModel;
import com.workforce.models.CompanyModel;
import com.workforce.models.ParticipantModel;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.models.UserModel;
import com.workforce.repositories.AccountTypeRepository;
import com.workforce.repositories.BaseRepository;
import com.workforce.repositories.UserRepository;

public class DataInitialize {
	
	public DataInitialize() {
		// TODO Auto-generated constructor stub		
		
//
		String firstname = "Yara",
				lastname = "Palacay",
				email = firstname.toLowerCase() + lastname.toLowerCase() + "@gmail.com",
				language = "Java";
//		
		loadParticipants(firstname, lastname, email, language);
		
		
//		loadCompanies();
//		loadAccountTypes();
//		loadProgrammingLanguages();
	
	}
	
	private void loadAccountTypes(){
		String[] accountTypes = {AccountTypeHelper.ADMIN, 
				AccountTypeHelper.PARTICIPANT, AccountTypeHelper.COMPANY};
		
		for(String ac : accountTypes){
			Session session = BaseRepository.getSession().openSession();
			session.beginTransaction();
			AccountTypeModel accc = new AccountTypeModel(ac);
			session.save(accc);
			session.getTransaction().commit();
		}
	}
	
	private void loadProgrammingLanguages(){
		String[] programmingLanguages = {"Java", "C#", "Ruby", "Python", "PHP"};
		for(String pl : programmingLanguages){
			Session session = BaseRepository.getSession().openSession();
			session.beginTransaction();
			ProgrammingLanguageModel accc = new ProgrammingLanguageModel(pl);
			session.save(accc);
			session.getTransaction().commit();
		}
		
	}
	
	private void loadParticipants(String firstname, String lastname, String email, String language){
		
		//Hard coded
		
		ProgrammingLanguageModel pl = ProgrammingLanguageHelper.getProgrammingLanguageByID(language);
		AccountTypeRepository accountTypeRepository = new AccountTypeRepository();
		AccountTypeModel ac = accountTypeRepository.getAccountTypeByType(AccountTypeHelper.PARTICIPANT);
		
		ParticipantModel part = new ParticipantModel(firstname, lastname, null, null, pl);
		UserModel user = new UserModel(email, SecurityHelper.encrypt("jmsantos"), false, null, false, ac);
		
		user.setParticipantModel(part);
		part.setUserModel(user);
		
		UserRepository userRepository = new UserRepository();
		userRepository.Insert(user);
		
	}
	
	private void loadCompanies(){
		
		AccountTypeModel ac = new AccountTypeModel();
		ac.setID(3);
		
		List<CompanyModel> list = (List<CompanyModel>) ResourceHelper.getJsonList("companies");
		list.forEach(i -> {
			Session session = BaseRepository.getSession().openSession();
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
