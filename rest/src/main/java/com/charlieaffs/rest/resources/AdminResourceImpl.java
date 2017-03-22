package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.AdminDao;
import com.charlieaffs.data.tradeit.model.Admin;

@Path(AdminResource.END_POINT)
public class AdminResourceImpl extends DataModelResourceImpl<AdminDao, Admin> implements AdminResource {

	@Autowired
	public AdminResourceImpl(AdminDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return AdminResource.END_POINT;
	}

}
