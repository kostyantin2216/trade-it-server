package com.charlieaffs.ifs.external.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.external.UBinaryLead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.external.converters.LeadConverter;
import com.charlieaffs.ifs.external.registrars.Registrar;

@Component("uBinaryLeadHandler")
public class UBinaryLeadHandler extends BaseLeadHandler<UBinaryLead> implements BrokerLeadHandler {
	
	@Autowired
	public UBinaryLeadHandler(@Qualifier("uBinaryLeadConverter") LeadConverter<UBinaryLead> converter, 
							  @Qualifier("uBinaryRegistrar") Registrar<UBinaryLead> registrar) {
		super(converter, registrar);
	}
	
	@Override
	public BrokerRegistration registerLead(User user, String ip) {
		return (BrokerRegistration) super.registerLead(user, ip);
	}
}
