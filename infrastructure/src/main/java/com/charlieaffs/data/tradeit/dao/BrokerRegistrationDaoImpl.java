package com.charlieaffs.data.tradeit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;

@Repository("brokerRegistrationDao")
public class BrokerRegistrationDaoImpl extends BaseDao<BrokerRegistration> implements BrokerRegistrationDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.BrokerRegistration";
	public final static String TABLE_NAME = "BrokerRegistration";
	
	public final static String ID = "id";
	public final static String USER_ID = "userId";
	public final static String BROKER_ID = "brokerId";
	public final static String USER_BROKER_ID = "userBrokerId";
	public final static String MESSAGE = "message";
	public final static String IS_SUCCESS = "isSuccess";
	public final static String TRACKING_ID = "trackingId";
	public final static String IP_ADDRESS = "ipAddress";
	public final static String CREATED_AT = "createdAt";
	
	@Override
	public List<BrokerRegistration> findByUserId(Integer userId) {
		return findByProperty(USER_ID, userId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public String getIpForUser(Integer userId) {
		List<String> ips = getSession()
				.createSQLQuery("SELECT " + IP_ADDRESS 
							 + " FROM " + TABLE_NAME 
							 + " WHERE " + USER_ID + " = " + userId)
				.list();
		for(String ip : ips) {
			if(ip != null) {
				return ip;
			}
		}
		return null;
	}

	@Override
	public Map<Integer, String> mapIpsToUserIds(Integer[] userIds) {
		Map<Integer, String> ipsByIds = new HashMap<>();
		for(Integer userId : userIds) {
			ipsByIds.put(userId, getIpForUser(userId));
		}
		return ipsByIds;
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
