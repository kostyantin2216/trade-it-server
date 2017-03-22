package rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.charlieaffs.rest.configuration.RestConfig;

public class SpringJerseryTest {
	
	private ApplicationContext springContext; 
	
	public SpringJerseryTest() {
		springContext = new AnnotationConfigApplicationContext(RestConfig.class);
	}

	public ApplicationContext getSpringContext() {
		return springContext;
	}

}
