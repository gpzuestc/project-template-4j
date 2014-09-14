package net.dumbee.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LogTest {
	private static final Logger log = LogManager.getLogger(LogTest.class);
	
	@Test
	public void test(){
		log.entry();
		log.trace("1、trace log");
		log.debug("2、debug log");
		log.info("3、info log");
		log.warn("4、warn log");
		log.error("5、error log");
		log.fatal("6、fatal log");
	}
}
