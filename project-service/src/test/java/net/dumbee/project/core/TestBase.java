package net.dumbee.project.core;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	protected static ApplicationContext context = null;
	protected static String SUCCESS = "SUCCESS";
	protected static long id = 1 ;
	@BeforeClass
	public static void before(){
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-test.xml" });

	}
}
