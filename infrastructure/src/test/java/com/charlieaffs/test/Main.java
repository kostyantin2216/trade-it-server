package com.charlieaffs.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.charlieaffs.data.tradeit.dao.SignalDao;
import com.charlieaffs.data.tradeit.model.Signal;
import com.charlieaffs.ifs.configuration.InfastructureConfig;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(InfastructureConfig.class);

		SignalDao dao = (SignalDao) context.getBean("signalDao");
		
		List<Signal> signals = dao.findAll();
		
		if(signals.isEmpty()) {
			System.out.println("no signals");
		} else {
			for(Signal signal : signals) {
				System.out.println(signal.toString());
			}
		}
		
		context.close();
		
	}

}
