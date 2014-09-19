package net.dumbee.project.core.dao.impl;

import net.dumbee.project.core.dao.IUserDAO;
import net.dumbee.project.core.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAO<User, Long> implements IUserDAO{
	
}
