package com.charlieaffs.ifs.external.registrars;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.external.BrokerLead;
import com.charlieaffs.data.tradeit.dao.BrokerDao;
import com.charlieaffs.data.tradeit.dao.BrokerRegistrationDao;
import com.charlieaffs.data.tradeit.dao.CountryDao;
import com.charlieaffs.data.tradeit.dao.RegistrationRuleDao;
import com.charlieaffs.data.tradeit.model.Broker;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.Country;
import com.charlieaffs.data.tradeit.model.RegistrationRule;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.rest.client.BrokerLeadRestClient;

public abstract class BaseBrokerRegistrar<E extends BrokerLead> extends BaseRegistrar<E> 
		implements BrokerRegistrar<E> {

	@Autowired
	private RegistrationRuleDao ruleDao;
	
	@Autowired
	private BrokerRegistrationDao brDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private BrokerDao brokerDao;

	protected abstract BrokerLeadRestClient<E> getRestClient();
	protected abstract void fillBrokerRegistration(BrokerRegistration br, Map<String, Object> params);
	
	@Override
	public BrokerRegistration registerLead(E lead) {
		if(acceptsLead(lead)) {
			Map<String, Object> respParams = getRestClient().registerLead(lead);
			if(respParams != null) {
				BrokerRegistration br = new BrokerRegistration();
				br.setUserId((Integer) lead.getId());
				br.setBrokerId(getBrokerId());
				br.setIpAddress(lead.getIp());
				br.setCreatedAt(new Date());
				
				fillBrokerRegistration(br, respParams);
				recordRegistration(br);
				return br;
			} else {
				TILogger.getLog().warn("Response from " + getBrokerName() 
							+ " lead registration was null for lead: " 
							+ lead.toString(), true);
			}
		}
		return null;
	}
	
	@Override
	public boolean acceptsLead(E lead) {
		Broker broker = brokerDao.findById(getBrokerId());
		if(broker != null && broker.getIsActive()) {
			List<RegistrationRule> rules = ruleDao.getRulesForBroker(getBrokerId());
			Country country = countryDao.findByIso2(lead.getCountryCode());
			
			if(rules == null || rules.isEmpty() || country == null) {
				String error = rules == null ? "rules are null" : country == null ? "contry is null (lead country code: " + lead.getCountryCode() + ")" : "rules are empty"; 
				TILogger.getLog().debug("Accepting all leads for broker with id " + getBrokerId() + " becuase " + error);
				return true;
			}
			
			for(RegistrationRule rule : rules) {
				if(rule.getCountryId() == country.getId()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected void recordRegistration(BrokerRegistration br) {
		TILogger.getLog().debug("saving broker registration record for broker: " + getBrokerId());
		brDao.save(br);
	}
	
}
