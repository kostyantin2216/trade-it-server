package com.charlieaffs.data.tradeit.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.ApiKey;

@Repository("apiKeyDao")
public class ApiKeyDaoImpl extends BaseDao<ApiKey> implements ApiKeyDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.ApiKey";
	public final static String TABLE_NAME = "ApiKey";
	
	public final static String KEY = "apiKey";
	public final static String DESCRIPTION = "description";
	public final static String IS_ACTIVE = "isActive";
	
	private final static ConcurrentMap<String, ApiKey> keysCache = new ConcurrentHashMap<>();
	
	public final static ApiKey INACTIVE_DUMMY_KEY = new ApiKey("", "", false);
	
	@Override
	public ApiKey authenticate(String key) {
		return authenticate(key, true);
	}
	
	@Override
	public ApiKey authenticate(String key, boolean activeOnly) {
		if(key == null) {
			return null;
		}
		
		ApiKey apiKey = keysCache.get(key);
		if(apiKey == null) {
			apiKey = findById(key);
			keysCache.putIfAbsent(key, apiKey != null ? apiKey : INACTIVE_DUMMY_KEY);
		}
		
		if(activeOnly && apiKey != null && !apiKey.getIsActive()) {
			return null;
		}
		return apiKey;
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
