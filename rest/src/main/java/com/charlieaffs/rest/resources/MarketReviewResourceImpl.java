package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.MarketReviewDao;
import com.charlieaffs.data.tradeit.model.MarketReview;

@Path(MarketReviewResource.END_POINT)
public class MarketReviewResourceImpl extends DataModelResourceImpl<MarketReviewDao, MarketReview> implements MarketReviewResource {

	@Autowired
	public MarketReviewResourceImpl(MarketReviewDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return MarketReviewResource.END_POINT;
	}

}
