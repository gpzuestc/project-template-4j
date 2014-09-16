package net.dumbee.project.core.dao;

import net.dumbee.project.core.TestBase;

import org.junit.Test;

public class UserDAOTest extends TestBase{

	@Test
	public void testLoad(){
		UserDAO userDAO = context.getBean(UserDAO.class);
		System.out.println(userDAO.load(1L).getName());
	}
}
