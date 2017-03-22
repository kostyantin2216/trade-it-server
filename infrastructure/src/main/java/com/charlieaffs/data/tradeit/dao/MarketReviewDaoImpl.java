package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.MarketReview;

@Repository("marketReviewDao")
public class MarketReviewDaoImpl extends BaseDao<MarketReview> implements MarketReviewDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.MarketReview";
	public final static String TABLE_NAME = "MarketReview";
	
	public final static String ID = "id";
	public final static String TITLE = "title";
	public final static String CONTENT = "content";
	public final static String IMAGE_URL = "imageUrl";
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
