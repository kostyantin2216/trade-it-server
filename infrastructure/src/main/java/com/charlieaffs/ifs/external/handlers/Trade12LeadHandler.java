package com.charlieaffs.ifs.external.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.external.Trade12Lead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.external.converters.LeadConverter;
import com.charlieaffs.ifs.external.registrars.Registrar;

@Component("trade12LeadHandler")
public class Trade12LeadHandler extends BaseLeadHandler<Trade12Lead> implements BrokerLeadHandler {
	
	@Autowired
	public Trade12LeadHandler(@Qualifier("trade12LeadConverter") LeadConverter<Trade12Lead> leadConverter, 
							  @Qualifier("trade12Registrar") Registrar<Trade12Lead> registrar) {
		super(leadConverter, registrar);
	}
	
	@Override
	public BrokerRegistration registerLead(User user, String ip) {
		return (BrokerRegistration) super.registerLead(user, ip);
	}

}
