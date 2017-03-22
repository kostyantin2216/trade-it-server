package com.charlieaffs.rest.resources;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.CountryDao;
import com.charlieaffs.data.tradeit.model.Country;

@Path(CountryResource.END_POINT)
public class CountryResourceImpl extends DataModelResourceImpl<CountryDao, Country> implements CountryResource {

	@Autowired
	public CountryResourceImpl(CountryDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return CountryResource.END_POINT;
	}

}
