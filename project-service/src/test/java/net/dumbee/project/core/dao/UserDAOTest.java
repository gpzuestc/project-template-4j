package net.dumbee.project.core.dao;

import java.util.List;

import net.dumbee.project.core.TestBase;
import net.dumbee.project.core.entity.User;

import org.junit.Test;

public class UserDAOTest extends TestBase{
	
	IUserDAO userDAO = context.getBean(IUserDAO.class);

	@Test
	public void testLoad(){
		System.out.println(userDAO.get(1L).getName());
	}
	
	@Test
	public void testFindByExample(){
		User user = new User();
		user.setName("sobject");
		
//		List<User> list = userDAO.findByExample(user);
//		List<User> list = userDAO.findByExample(user, 0, 0, true, "id");
		List<User> list = userDAO.findByExample(user, 0, 0, true, null);
		System.out.println(userDAO.countByExample(user));
		System.out.println(list.size());
		System.out.println(list.get(0).getId());
		
	}
}
