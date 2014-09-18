package net.dumbee.project.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.dumbee.project.core.entity.User;

public interface UserDAO {

	User load(Long id);
	
	int save(User user);
	
	List<User> findByNameAndStartAndSize(@Param("name") String name, @Param("start") Integer start, @Param("size") Integer size);
}
