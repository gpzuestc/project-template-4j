package net.dumbee.project.core.dao;

import java.io.Serializable;
import java.util.List;


public interface IBaseDAO <T, ID extends Serializable> {
	
	T get(ID id);
	
	ID save(T entity);
	
	void delete(T entity);
	
	void saveOrUpdate(T entity);
	
	void update(T entity);
	
	List<T> findByExample(T entity);
	
	List<T> findByExample(T entity, int firstResult, int maxResult);
}
