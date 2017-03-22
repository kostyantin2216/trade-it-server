package com.charlieaffs.data.tradeit.dao;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.ApiKey;

public interface ApiKeyDao extends CommonDao<ApiKey> {
	ApiKey authenticate(String key);
	ApiKey authenticate(String key, boolean activeOnly);
}
