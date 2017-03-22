package com.charlieaffs.data.tradeit.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.Country;

@Repository(CountryDao.BEAN_NAME)
public class CountryDaoImpl extends BaseDao<Country> implements CountryDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.Country";
	public final static String TABLE_NAME = "Country";
	
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String ISO_2 = "iso2";
	public final static String ISO_3 = "iso3";
	public final static String DIAL_CODE = "dialCode";
	public final static String UPDATED_AT = "updatedAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public Country findByName(String name) {
		return (Country) getSession()
				.createCriteria(CLASS_NAME)
				.add(Restrictions.ilike(NAME, name))
				.uniqueResult();
	}
	
	@Override
	public Country findByIso2(String iso2) {
		List<Country> result = findByProperty(ISO_2, iso2.toUpperCase());
		if(result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
