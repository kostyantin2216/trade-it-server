package com.charlieaffs.data.tradeit.dao;

import java.util.List;
import java.util.Map;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;

public interface BrokerRegistrationDao extends CommonDao<BrokerRegistration> {
	List<BrokerRegistration> findByUserId(Integer userId);
	String getIpForUser(Integer userId);
	Map<Integer, String> mapIpsToUserIds(Integer[] userId);
}
