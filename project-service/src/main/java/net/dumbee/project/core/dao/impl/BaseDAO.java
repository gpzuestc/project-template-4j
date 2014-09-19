package net.dumbee.project.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import net.dumbee.project.core.dao.IBaseDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDAO<T, ID extends Serializable> implements IBaseDAO<T, ID>{
	
	@Autowired
	protected HibernateTemplate hbtpl;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDAO(){
		entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
	}

	@Override
	public T get(Serializable id) {
		return hbtpl.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID save(T entity) {
		return (ID)hbtpl.save(entity);
	}

	@Override
	public List<T> findByExample(T entity) {
		return hbtpl.findByExample(entity);
	}

	@Override
	public void delete(T entity) {
		hbtpl.delete(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		hbtpl.saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		hbtpl.update(entity);
	}
	
	@Override
	public List<T> findByExample(T entity, int firstResult, int maxResult){
		return hbtpl.findByExample(entity, firstResult, maxResult);
	}
	

}
