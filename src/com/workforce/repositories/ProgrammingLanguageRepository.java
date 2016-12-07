package com.workforce.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IProgrammingLanguageRepository;
import com.workforce.models.ProgrammingLanguageModel;


public class ProgrammingLanguageRepository extends CrudRepository<ProgrammingLanguageModel> implements IProgrammingLanguageRepository {
	
	public int GetIdByLanguage(String language){
		
		Session session = null;
		Transaction trans = null;
		int languageID = 0;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			ProgrammingLanguageModel pl = (ProgrammingLanguageModel) session.createQuery("from ProgrammingLanguage where language = :language")
							.setParameter("language", language)
							.uniqueResult();
			
			languageID = pl.getID();

			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
		return languageID;
	}
}
