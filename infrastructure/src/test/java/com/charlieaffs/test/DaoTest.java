package com.charlieaffs.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.ifs.configuration.InfastructureConfig;
import com.charlieaffs.ifs.logging.TILogger;

public class DaoTest {
	
	private final static String[] DAOS_TO_TEST = new String[] {
			"adminDao",
			"apiKeyDao",
			"brokerDao",
			"brokerRegistrationDao",
			"contentPageDao",
			"contentPageTypeDao",
			"countryDao",
			"updateTimeDao",
			"logDao",
			"marketReviewDao",
			"signalDao",
			"userDao"
	};
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(InfastructureConfig.class);

		for(String daoToTest : DAOS_TO_TEST) {
			CommonDao dao = (CommonDao) context.getBean(daoToTest);
			try {
				testDao(dao);
			} catch(Exception e) {
				TILogger.getLog().error("Error during " + dao.getTableName() + " test", e);
			}
		}
		
		context.close();
	}
	
	private static void testDao(CommonDao dao) {
		TILogger.getLog().info("Testing dao: " + dao.getTableName());
		
		int count = dao.findAll().size();
		TILogger.getLog().info("found " + count + " items");
	}

}
