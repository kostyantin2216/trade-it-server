package com.charlieaffs.ifs.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.charlieaffs.ifs.logging.TILogger;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.charlieaffs.ifs.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	
	@Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setMappingResources(mappingResources());
   //     sessionFactory.setPackagesToScan(new String[] { "com.charlieaffs.ifs.data.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
    @Bean
    public DataSource dataSource() {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
    	try {
			dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
		} catch (IllegalStateException | PropertyVetoException e) {
			TILogger.getLog().error("Could not set driver class for combo pooled data source", e);
			return null;
		}
    	dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
    	dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
    	dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
    	
        dataSource.setPreferredTestQuery("SELECT 1");
        //dataSource.setConnectionCustomizerClassName("com.charlieaffs.ifs.logging.ConnectionPoolLogger");
        
    	/* 	POOL PROPERTIES	 
    	  
    	   	The point of Connection pooling is to bear the cost of acquiring a Connection 
        	only once, and then to reuse the Connection many, many times. Most databases 
        	support Connections that remain open for hours at a time. There's no need to churn 
        	through all your Connections every few seconds or minutes. Setting maxConnectionAge 
        	or maxIdleTime to 1800 (30 minutes) is quite aggressive. For most databases, 
        	several hours may be more appropriate. You can ensure the reliability of your 
        	Connections by testing them, rather than by tossing them. 
        	(see Configuring Connection Testing.) The only one of these parameters that 
        	should generally be set to a few minutes or less is maxIdleTimeExcessConnections.   
    	 */
    	
    	dataSource.setAcquireIncrement(3);
    	/*	Determines how many connections at a time c3p0 will try to acquire when 
            the pool is exhausted. default - 3	*/
    	 
    	 dataSource.setAcquireRetryAttempts(3);
        /*  Defines how many times c3p0 will try to acquire a new Connection from the 
            database before giving up. If this value is less than or equal to zero, 
            c3p0 will keep trying to fetch a Connection indefinitely. default - 30	*/
    	 
        dataSource.setAcquireRetryDelay(4500); // Milliseconds
        /*  Time c3p0 will wait between acquire attempts.	*/
         
        dataSource.setAutoCommitOnClose(false);
        /*	Default value - false.	*/
         
        dataSource.setInitialPoolSize(3);
        /*	Unreasonable values of initialPoolSize will be ignored, and minPoolSize 
            will be used instead. 
            minPoolSize <= maxPoolSize.	*/
         
        dataSource.setMaxPoolSize(100);
        /*  Default: 15 Maximum number of Connections a pool will maintain at any given time.	*/
         
        dataSource.setMinPoolSize(10);
        /*  Default: 3 Minimum number of Connections a pool will maintain at any given time.	*/
         
        dataSource.setMaxIdleTime(7200); // 2 hours
        /*  Default: 0    
            Seconds a Connection can remain pooled but unused before being discarded. 
            Zero means idle connections never expire.	*/
         
        dataSource.setMaxConnectionAge(14400); // 4 hours
        /*  Default: 0
        	Seconds, effectively a time to live. A Connection older than maxConnectionAge 
        	will be destroyed and purged from the pool. This differs from maxIdleTime 
        	in that it refers to absolute age. Even a Connection which has not been much 
        	idle will be purged from the pool if it exceeds maxConnectionAge. 
        	Zero means no maximum absolute age is enforced.	*/
        
        dataSource.setMaxIdleTimeExcessConnections(2400); // 40 minutes
        /*	maxIdleTimeExcessConnections is about minimizing the number of 
        	Connections held by c3p0 pools when the pool is not under load. By default, 
        	c3p0 pools grow under load, but only shrink if Connections fail a Connection 
        	test or are expired away via the parameters described above. Some users want 
        	their pools to quickly release unnecessary Connections after a spike in usage 
        	that forces a large pool size. You can achieve this by setting 
        	maxIdleTimeExcessConnections to a value much shorter than maxIdleTime, forcing 
        	Connections beyond your set minimum size to be released if they sit idle for 
	        more than a short period of time. 	*/
        
        // dataSource.setMaxStatements(50);
	    /*	Use only if statement caching is used.  */
        
        //dataSource.setAutomaticTestTable("connectionTestTable");
        /* 	Most convenient way to speed up Connection testing is to define 
        	the parameter automaticTestTable.
            If provided, c3p0 will create an empty table of the specified name, 
        	and use queries against that table to test the Connection. If 
        	automaticTestTable is provided, c3p0 will generate its own test query, 
        	therefore any preferredTestQuery set will be ignored. You should not work 
        	with the named table after c3p0 creates it; it should be strictly for 
        	c3p0's use in testing your Connection.	*/
        
        /*	The most reliable time to test Connections is on check-out. But this 
        	is also the most costly choice from a client-performance perspective. Most 
        	applications should work quite reliably using a combination of 
        	idleConnectionTestPeriod and testConnectionsOnCheckIn. Both the idle test 
        	and the check-in test are performed asynchronously, which leads to 
        	better performance, both perceived and actual.	*/
        
        dataSource.setIdleConnectionTestPeriod(180); // 3 minutes
        /*	Default: 0
            If this is a number greater than 0, c3p0 will test all idle, 
        	pooled but unchecked-out connections, every this number of seconds. */
        
        dataSource.setTestConnectionOnCheckin(true);
        /* 	Default: false
            If true, an operation will be performed asynchronously at every 
        	connection check-in to verify that the connection is valid. Use 
        	in combination with idleConnectionTestPeriod for quite reliable, 
        	always asynchronous Connection testing	*/
        
        dataSource.setTestConnectionOnCheckout(true);
        /*	Default: false
        	Use only if necessary. Expensive. If true, an operation will be performed 
        	at every connection checkout to verify that the connection is valid.	*/
        
        return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));/*
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));*/
        return properties;        
    }
    
    private String[] mappingResources() {
    	return new String[] {
    			"mappings/tradeit/Admin.hbm.xml",
    			"mappings/tradeit/ApiKey.hbm.xml",
    			"mappings/tradeit/Broker.hbm.xml",
    			"mappings/tradeit/BrokerRegistration.hbm.xml",
    			"mappings/tradeit/ContentPage.hbm.xml",
    			"mappings/tradeit/ContentPageType.hbm.xml",
    			"mappings/tradeit/Country.hbm.xml",
    			"mappings/tradeit/DataTableUpdateTime.hbm.xml",
    			"mappings/tradeit/Log.hbm.xml",
    			"mappings/tradeit/MarketReview.hbm.xml",
    			"mappings/tradeit/RegistrationRule.hbm.xml",
    			"mappings/tradeit/Signal.hbm.xml",
    			"mappings/tradeit/User.hbm.xml",
    			"mappings/web/Metadata.hbm.xml"
    	};
    }
    
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
	
}
