package com.workforce.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workforce.models.AccountTypeModel;

public class AccountTypeHelper implements IAccountTypes {
	
	public static AccountTypeModel getAccountTypeByName(String type){
		
		AccountTypeModel ac = null;
		Session session = null;
		Transaction trans = null;
		
		try {
			session = HibernateFactory.getSession().openSession();
			trans = session.beginTransaction();
			
			ac = (AccountTypeModel) session.createQuery("from AccountType where type = :type")
					.setParameter("type", type)
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
