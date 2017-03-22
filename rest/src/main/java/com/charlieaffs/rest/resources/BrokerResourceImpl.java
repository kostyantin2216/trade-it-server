package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.BrokerDao;
import com.charlieaffs.data.tradeit.model.Broker;

@Path(BrokerResource.END_POINT)
public class BrokerResourceImpl extends DataModelResourceImpl<BrokerDao, Broker> implements BrokerResource {

	@Autowired
	public BrokerResourceImpl(BrokerDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return BrokerResource.END_POINT;
	}

}
