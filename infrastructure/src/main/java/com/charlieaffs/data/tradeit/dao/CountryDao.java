package com.charlieaffs.data.tradeit.dao;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.Country;

public interface CountryDao extends CommonDao<Country> {
	String BEAN_NAME = "countryDao";
	
	Country findByName(String name);
	Country findByIso2(String iso2);
}
