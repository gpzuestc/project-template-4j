package net.dumbee.project.core.service;

import org.junit.Test;

import net.dumbee.project.core.TestBase;
import net.dumbee.project.core.entity.User;

public class UserCoreServiceTest extends TestBase{
	
	@Test
	public void testSaveUser() throws Exception{
		IUserCoreService userCoreService  = context.getBean(IUserCoreService.class);
		User user = new User();
		user.setName("sobject");
		System.out.println(userCoreService.saveUser(user));
		System.out.println(user.getId());
	}
}
