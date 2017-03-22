package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.LogDao;
import com.charlieaffs.data.tradeit.model.Log;

@Path(LogResource.END_POINT)
public class LogResourceImpl extends DataModelResourceImpl<LogDao, Log> implements LogResource {

	@Autowired
	public LogResourceImpl(LogDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return LogResource.END_POINT;
	}

}
