package com.charlieaffs.ifs.external.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.external.OpteckLead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.external.converters.LeadConverter;
import com.charlieaffs.ifs.external.registrars.Registrar;

@Component("opteckLeadHandler")
public class OpteckLeadHandler extends BaseLeadHandler<OpteckLead> implements BrokerLeadHandler {

	@Autowired
	public OpteckLeadHandler(@Qualifier("opteckLeadConverter") LeadConverter<OpteckLead> leadConverter, 
							 @Qualifier("opteckRegistrar") Registrar<OpteckLead> registrar) {
		super(leadConverter, registrar);
	}
	
	@Override
	public BrokerRegistration registerLead(User user, String ip) {
		return (BrokerRegistration) super.registerLead(user, ip);
	}

}
