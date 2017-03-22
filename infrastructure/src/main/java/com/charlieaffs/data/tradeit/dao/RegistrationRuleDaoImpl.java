package com.charlieaffs.data.tradeit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.RegistrationRule;

@Repository("registrationRuleDao")
public class RegistrationRuleDaoImpl extends BaseDao<RegistrationRule> implements RegistrationRuleDao {
	
	public final static String TABLE_NAME = "RegistrationRule";
	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.RegistrationRule";
	
	public final static String ID = "id";
	public final static String BROKER_ID = "brokerId";
	public final static String COUNTRY_ID = "countryId";
	public final static String IS_ACTIVE = "isActive";
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
	public List<RegistrationRule> getRulesForBroker(Integer brokerId) {
		return findByProperty(BROKER_ID, brokerId);
	}

}
