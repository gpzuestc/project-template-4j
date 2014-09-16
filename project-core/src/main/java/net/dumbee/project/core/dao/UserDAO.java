package net.dumbee.project.core.dao;

import net.dumbee.project.core.entity.User;

public interface UserDAO {

	User load(Long id);
	
	int save(User user);
}
