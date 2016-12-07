package com.workforce.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.workforce.contracts.IRepository;

public abstract class CrudRepository<T> extends BaseRepository implements IRepository<T>{

	@Override
	public void Insert(T entity) {
		// TODO Auto-generated method stub
		Session session = null; 
		Transaction trans = null;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			session.save(entity);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		session.clear();
		session.close();
	}
	
	@Override
	public void Update(T entity) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			session.update(entity);
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
	public List<T> GetList(T entity) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		List<T> list = new ArrayList<T>();
		
		System.out.println(entity.getClass().getSimpleName());
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			list = session.createCriteria(entity.getClass())
					.list();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
//		session.close();
		return list;
	}
	
	public List<T> GetListByAccessToken(T entity, int id){
		
		Session session = null;
		Transaction trans = null;
		List<T> list = new ArrayList<T>();
		
		System.out.println(entity.getClass().getSimpleName());
		
		try {
			session = BaseRepository.getSession().openSession();
			trans = session.beginTransaction();
			list = session.createCriteria(entity.getClass())
					.add(Restrictions.eq("ID", id))
					.list();
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		
		return list;
	}
}
