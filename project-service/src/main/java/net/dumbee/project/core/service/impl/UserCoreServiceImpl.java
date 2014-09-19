package net.dumbee.project.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dumbee.project.core.dao.IUserDAO;
import net.dumbee.project.core.entity.User;
import net.dumbee.project.core.service.IUserCoreService;

@Service
public class UserCoreServiceImpl implements IUserCoreService{
	
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User loadUser(Long id) {
		return userDAO.get(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Long saveUser(User user) throws Exception{
		Long r = userDAO.save(user);
//		throw new Exception("heheh");
		return r;
	}

}
