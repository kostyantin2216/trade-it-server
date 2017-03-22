package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.Log;

@Repository("logDao")
public class LogDaoImpl extends BaseDao<Log> implements LogDao {
	
	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.Log";
	public final static String TABLE_NAME = "Log";
	
	public final static String ID = "id";
	public final static String USER_ID = "userId";
	public final static String TAG = "tag";
	public final static String MESSAGE = "message";
	public final static String STACK_TRACE = "stackTrace";
	public final static String DEVICE_INFO = "deviceInfo";
	public final static String VERSION_INFO = "versionInfo";
	public final static String CREATED_AT = "createdAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
