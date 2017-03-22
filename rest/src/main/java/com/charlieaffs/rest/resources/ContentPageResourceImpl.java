package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.ContentPageDao;
import com.charlieaffs.data.tradeit.model.ContentPage;

@Path(ContentPageResource.END_POINT)
public class ContentPageResourceImpl extends DataModelResourceImpl<ContentPageDao, ContentPage> implements ContentPageResource {

	@Autowired
	public ContentPageResourceImpl(ContentPageDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return ContentPageResource.END_POINT;
	}
	
}
