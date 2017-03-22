package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.BrokerRegistrationDao;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;

@Path(BrokerRegistrationResource.END_POINT)
public class BrokerRegistrationResourceImpl extends DataModelResourceImpl<BrokerRegistrationDao, BrokerRegistration>
		implements BrokerRegistrationResource {

	@Autowired
	public BrokerRegistrationResourceImpl(BrokerRegistrationDao dao) {
		super(dao);
	}
	@Override
	public String getEndPoint() {
		return BrokerRegistrationResource.END_POINT;
	}

}
