package com.charlieaffs.data.tradeit.dao;

import java.util.List;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.RegistrationRule;

public interface RegistrationRuleDao extends CommonDao<RegistrationRule> {
	List<RegistrationRule> getRulesForBroker(Integer broker);
}
