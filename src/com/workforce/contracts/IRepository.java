package com.workforce.contracts;

import java.util.List;

public interface IRepository<T> {
	
	public void Insert(final T entity);
	
	public void Update(final T entity);
	
	public List<T> GetList(final T entity);
	
}
