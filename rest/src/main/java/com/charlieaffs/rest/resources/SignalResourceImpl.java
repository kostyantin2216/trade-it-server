package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.SignalDao;
import com.charlieaffs.data.tradeit.model.Signal;

@Path(SignalResource.END_POINT)
public class SignalResourceImpl extends DataModelResourceImpl<SignalDao, Signal> implements SignalResource {
	
	@Autowired
	public SignalResourceImpl(SignalDao dao) {
		super(dao);
	}

	@Override
	public String getEndPoint() {
		return SignalResource.END_POINT;
	}

}
