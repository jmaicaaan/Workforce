package com.workforce.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.contracts.IAccountTypeRepository;
import com.workforce.models.AccountTypeModel;

public class AccountTypeRepository extends CrudRepository<AccountTypeModel> implements IAccountTypeRepository {
	
	@Override
	public AccountTypeModel getAccountTypeByType(String accountType) {
		// TODO Auto-generated method stub
		AccountTypeModel ac = null;
		Session session = null;
		Transaction trans = null;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			
			ac = (AccountTypeModel) session.createQuery("from AccountType where type = :type")
					.setParameter("type", accountType)
					.uniqueResult();
			
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		session.close();
		return ac;
	}
}
