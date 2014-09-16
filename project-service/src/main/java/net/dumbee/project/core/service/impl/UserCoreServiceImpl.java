package net.dumbee.project.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dumbee.project.core.dao.UserDAO;
import net.dumbee.project.core.entity.User;
import net.dumbee.project.core.service.UserCoreService;

@Service
public class UserCoreServiceImpl implements UserCoreService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User loadUser(Long id) {
		return userDAO.load(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int saveUser(User user) throws Exception{
		int r = userDAO.save(user);
//		throw new Exception("heheh");
		return r;
	}

}
