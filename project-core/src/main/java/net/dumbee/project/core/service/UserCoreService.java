package net.dumbee.project.core.service;

import net.dumbee.project.core.entity.User;

public interface UserCoreService {
	User loadUser(Long id);
	
	int saveUser(User user) throws Exception;
}
