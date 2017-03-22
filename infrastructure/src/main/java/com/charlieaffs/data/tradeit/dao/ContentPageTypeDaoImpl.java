package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.ContentPageType;

@Repository("contentPageTypeDao")
public class ContentPageTypeDaoImpl extends BaseDao<ContentPageType> implements ContentPageTypeDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.ContentPageType";
	public final static String TABLE_NAME = "ContentPageType";
	
	public final static String ID = "id";
	public final static String NAME = "name";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
