package net.dumbee.project.core.dao;

import net.dumbee.project.core.TestBase;

import org.junit.Test;

public class UserDAOTest extends TestBase{
	
	IUserDAO userDAO = context.getBean(IUserDAO.class);

	@Test
	public void testLoad(){
		System.out.println(userDAO.get(1L).getName());
	}
	
}
