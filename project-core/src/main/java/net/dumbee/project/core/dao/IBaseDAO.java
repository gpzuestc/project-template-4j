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
	
	List<T> findByExample(T entity, boolean desc);

	List<T> findByExample(T entity, boolean desc, String orderProperty);
	
	List<T> findByExample(T entity, int firstResult, int maxResults);
	
	List<T> findByExample(T entity, int firstResult, int maxResults, boolean desc);
	
	List<T> findByExample(T entity, int firstResult, int maxResults, boolean desc, String orderProperty);
	
	Long count();
	
	Long countByExample(T entity);
	
}
