package com.charlieaffs.ifs.controllers;

import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;

public interface BrokerController {

	
	BrokerRegistration[] registerWithBrokers(User user, String ip);
	BrokerRegistration[] registerWithBrokers(User user, String ip, Integer[] brokerIds);
	BrokerRegistration[] registerOldUsersWithBrokers(Integer[] userIds, Integer[] brokerIds);	
	
}
