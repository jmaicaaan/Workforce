package com.workforce.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.models.ProgrammingLanguageModel;

public class ProgrammingLanguageHelper {
	
	public static ProgrammingLanguageModel getProgrammingLanguageByID(String language){
		
		ProgrammingLanguageModel pl = null;
		Session session = null;
		Transaction trans = null;
		
		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();
			
			pl = (ProgrammingLanguageModel) session.createQuery("from ProgrammingLanguage where Language = :language")
				.setParameter("language", language)
				.uniqueResult();
			
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
		return pl;
	}
}
