package net.dumbee.project.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import net.dumbee.project.core.dao.IBaseDAO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class BaseDAO<T, ID extends Serializable> implements IBaseDAO<T, ID>{
	
	@Autowired
	protected HibernateTemplate hibernateTpl;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDAO(){
		entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
	}
	
	private DetachedCriteria getCriteria(){
		return DetachedCriteria.forClass(entityClass);
	}

	@Override
	public T get(Serializable id) {
		return hibernateTpl.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID save(T entity) {
		return (ID)hibernateTpl.save(entity);
	}

	@Override
	public void delete(T entity) {
		hibernateTpl.delete(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		hibernateTpl.saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		hibernateTpl.update(entity);
	}
	
	@Override
	public List<T> findByExample(T entity) {
		return findByExample(entity, false);
	}
	
	@Override
	public List<T> findByExample(T entity, int firstResult, int maxResults){
		return hibernateTpl.findByExample(entity, firstResult, maxResults);
	}

	@Override
	public List<T> findByExample(T entity, boolean desc) {
		return findByExample(entity, desc, null);
	}

	@Override
	public List<T> findByExample(T entity, boolean desc, String orderProperty) {
		return findByExample(entity, 0, 0, desc, orderProperty);
	}

	@Override
	public List<T> findByExample(T entity, int firstResult, int maxResults,
			boolean desc) {
		return findByExample(entity, firstResult, maxResults, desc, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T entity, int firstResult, int maxResults,
			boolean desc, String orderProperty) {
		DetachedCriteria dc = getCriteria();
		if(entity != null){
			dc.add(Example.create(entity));
		}
		if(desc && orderProperty != null){
			dc.addOrder(Order.desc(orderProperty));
		}
		return (List<T>) hibernateTpl.findByCriteria(dc, firstResult, maxResults);
	}

	@Override
	public Long count() {
		return countByExample(null);
	}
	
	@Override
	public Long countByExample(T entity) {
		DetachedCriteria dc = getCriteria();
		if(entity != null){
			dc.add(Example.create(entity));
		}
		dc.setProjection(Projections.rowCount());
		return (Long)hibernateTpl.findByCriteria(dc).get(0);
	}

}
