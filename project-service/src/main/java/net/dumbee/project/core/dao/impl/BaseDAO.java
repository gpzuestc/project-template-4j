package net.dumbee.project.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import net.dumbee.project.core.dao.IBaseDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class BaseDAO<T, ID extends Serializable> implements IBaseDAO<T, ID>{
	
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDAO(){
		entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
	}

	@Override
	public T get(Serializable id) {
		return hibernateTemplate.get(entityClass, id);
	}

	@Override
	public ID save(T entity) {
		return (ID)hibernateTemplate.save(entity);
	}

}
