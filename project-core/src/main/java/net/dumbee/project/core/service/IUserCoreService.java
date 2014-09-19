package net.dumbee.project.core.service;

import net.dumbee.project.core.entity.User;

public interface IUserCoreService {
	User loadUser(Long id);
	
	Long saveUser(User user) throws Exception;
}
