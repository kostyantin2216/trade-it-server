package com.charlieaffs.ifs.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.tradeit.dao.CountryDao;
import com.charlieaffs.data.tradeit.dao.LogDao;
import com.charlieaffs.data.tradeit.dao.UserDao;
import com.charlieaffs.ifs.controllers.BrokerController;
import com.charlieaffs.ifs.controllers.UserController;

@Component
public class SpringContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
    public static Object getBean(String beanName) {
    	return context.getBean(beanName);
    }
    
    public static <T> T getBean(Class<T> requiredType) {
    	return context.getBean(requiredType);
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	// Data Access Objects
	
	public static CountryDao getCountryDao() {
		return context.getBean(CountryDao.class);
	}
	
	public static LogDao getLogDao() {
		return context.getBean(LogDao.class);
	}
	
	public static UserDao getUserDao() {
		return context.getBean(UserDao.class);
	}
	
	// Controllers
	
	public static BrokerController getBrokerController() {
		return context.getBean(BrokerController.class);
	}
	
	public static UserController getUserController() {
		return context.getBean(UserController.class);
	}

}
