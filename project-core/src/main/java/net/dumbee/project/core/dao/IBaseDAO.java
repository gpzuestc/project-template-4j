package net.dumbee.project.core.dao;

import java.io.Serializable;


public interface IBaseDAO <T, ID extends Serializable> {
	T get(ID id);
	
	ID save(T entity);
	
}
