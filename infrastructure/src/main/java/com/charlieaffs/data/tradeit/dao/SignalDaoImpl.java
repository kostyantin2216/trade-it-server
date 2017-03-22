package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.Signal;

@Repository("signalDao")
public class SignalDaoImpl extends BaseDao<Signal> implements SignalDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.Signal";
	public final static String TABLE_NAME = "Signals";
	
	public final static String ID = "id";
	public final static String ASSET = "asset";
	public final static String ENTRY_RATE = "entryRate";
	public final static String EXPIRY_RATE = "expiryRate";
	public final static String IS_CALL = "isCall";
	public final static String EXPIRY_TIME = "expiryTime";
	public final static String CREATED_AT = "createdAt";
	public final static String STATUS = "status";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
}
