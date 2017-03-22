package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.ContentPage;

@Repository("contentPageDao")
public class ContentPageDaoImpl extends BaseDao<ContentPage> implements ContentPageDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.ContentPage";
	public final static String TABLE_NAME = "ContentPage";
	
	public final static String ID = "id";
	public final static String PAGE_TYPE_ID = "pageTypeId";
	public final static String TITLE = "title";
	public final static String DESCRIPTION = "description";
	public final static String ANDROID_ICON_RES_ID = "androidIconResId";
	public final static String TEMPLATE_FILE_NAME = "templateFileName";
	public final static String HTML_CONTENT = "htmlContent";
	public final static String CREATED_AT = "createdAt";
	public final static String UPDATED_AT = "updatedAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
}
