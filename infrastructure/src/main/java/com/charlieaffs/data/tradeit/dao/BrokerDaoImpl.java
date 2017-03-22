package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.Broker;

@Repository("brokerDao")
public class BrokerDaoImpl extends BaseDao<Broker> implements BrokerDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.Broker";
	public final static String TABLE_NAME = "Broker";
	
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String DESCRIPTION = "description";
	public final static String LOGO_URL = "logoUrl";
	public final static String MIN_DEPOSIT = "minDeposit";
	public final static String MIN_WITHDRAWAL = "minWithdrawal";
	public final static String PROMOTION = "promotion";
	public final static String RATING = "rating";
	public final static String CREATED_AT = "createdAt";
	public final static String UPDATED_AT = "updatedAt";
	public final static String URL = "url";
	public final static String IS_RECOMMENDED = "isRecommended";
	public final static String IS_ACTIVE = "isActive";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
