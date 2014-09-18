package net.dumbee.project.core.dao;

import net.dumbee.project.core.TestBase;

import org.junit.Test;

public class UserDAOTest extends TestBase{
	
	UserDAO userDAO = context.getBean(UserDAO.class);

	@Test
	public void testLoad(){
		System.out.println(userDAO.load(1L).getName());
	}
	
	@Test
	public void testFindByName(){
		System.out.println(userDAO.findByNameAndStartAndSize("sobject", 2, 3).get(1).getId());
	}
}
